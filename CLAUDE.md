# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What this app is

Android reference app for Tekken 8 players. List-detail UI built on **Navigation 3** + **Material3 adaptive**: the list pane is a reflowable grid of character icons sliced from a sprite sheet, with a name-filtered search field; the detail pane shows a Scaffold with a character TopAppBar (sprite + name), a "Basic Info" section (sidestep direction + throw-break category), and one section per character "state" (stances, installs, heat) with bullet-point notes. Compact widths show one pane at a time; anything larger gets the split. All data is hardcoded — no network or DB.

## Architecture

Nav3 setup lives entirely in `MainActivity.kt`.

- Two `NavKey`s in `nav/Destinations.kt`: `Roster` and `CharacterDetail(spriteIndex: Int)`. Both are `@Serializable` so `rememberNavBackStack` survives process death.
- `rememberListDetailSceneStrategy<NavKey>(directive = calculatePaneScaffoldDirective(currentWindowAdaptiveInfoV2()))` handles the single-pane/two-pane decision automatically — the default directive already collapses to a single pane on compact width or height.
- `CharacterDetail` is single-top: the list pane's click handler replaces `backStack[backStack.lastIndex]` when a `CharacterDetail` is already on top, instead of pushing a second one. So the stack stays at `[Roster, CharacterDetail(X)]` no matter how many sprites are tapped in two-pane mode.
- Custom `ContentTransform`s on `NavDisplay`: an 80dp slide-from-end + fade for `transitionSpec` (push), and a mirrored slide-from-start + fade for `popTransitionSpec` and `predictivePopTransitionSpec`. Exit always fades; enter just slides. Predictive back is opted in via `android:enableOnBackInvokedCallback="true"` in `AndroidManifest.xml`.
- **Per-pane Surface pattern**: `RosterPane`, `CharacterDetailPane`, and `CharacterDetailPlaceholder` all wrap their content in `Surface(modifier = Modifier.fillMaxSize())`. Without these, the predictive-back drag shows floating content over the underlying canvas. An outer `Surface` also wraps the `NavDisplay` so any uncovered space picks up the theme's surface color.

**Sprite sheet** — a single 444×630 WebP at `res/drawable-nodpi/tk8_spritesheet.webp` holds 40 character icons in a 6×7 grid of 74×90 cells. `roster/SpriteSheet.kt` exposes `rememberSpriteSheet()` (one-shot `ImageBitmap.imageResource`) and `spritePainter(spriteSheet, index)`, which builds a `BitmapPainter` with `srcOffset` / `srcSize` for the cell. The file must live in `drawable-nodpi/` — otherwise Android density-scales it on launch and the pixel offsets break.

**Ordinal invariant** — `TK8Info.entries[i]` is the character at sprite index `i`, and `CharacterDetail(spriteIndex)` references that same index. Adding a character means (in order): add a cell to the sprite sheet, add the `<string>` to `strings.xml`, add a new enum value at the right ordinal in `TK8Info`, and add a `getXxxCharacterStates()` helper in `CharacterState.kt`. Re-ordering or skipping breaks everything.

## Data

Two hardcoded sources, both ordinal-aligned with the sprite sheet:

- **`TK8Info` enum** (`TK8Info.kt`) — one entry per character, in sprite order. Each carries `displayName: @StringRes`, `sideStep: SideStep` (SSR/SSL/SSC), `throwGame: ThrowGame` (NONE/ONE/TWO/CROUCH/FULL).
- **`CharacterState`** (`CharacterState.kt`) — `data class` of `(fullName: @StringRes, code: @StringRes, bullets: @ArrayRes)`. `rememberCharacterStates(character)` is a `@Composable` that dispatches through a `when` block to one `private fun getXxxCharacterStates()` **per character**; placeholders return `emptyList()`. Bullet content comes from `<string-array>` resources resolved via `stringArrayResource`. Each helper carries `@RememberInComposition`. Keep the indirection — don't inline `emptyList()` back into the `when`; this layout means filling in state for a new character is a single-function edit and keeps startup fast.

## Conventions

- 2-space indentation in Kotlin source (not the IDE default).
- All user-facing strings come from resources, including bullet lists (`<string-array>`).
- Every navigable pane wraps in its own `Surface`.
- `MaterialTheme.colorScheme` tokens only; no hardcoded colors. SSR/SSL/SSC → error/primary/secondary mapping lives in `SideStepText` inside `CharacterDetailPane.kt`.

## Build / test commands

The project uses the Gradle wrapper (9.3.1). Standard commands:

- `./gradlew assembleDebug` — build debug APK
- `./gradlew installDebug` — install on a connected device/emulator
- `./gradlew test` — JVM unit tests
- `./gradlew connectedAndroidTest` — instrumented (Espresso/Compose) tests
- `./gradlew lint` — Android Lint

Run a single instrumented test class:
`./gradlew :app:connectedDebugAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=dev.ahart.tk8.info.ExampleInstrumentedTest`

Version pins in `gradle/libs.versions.toml`:
- AGP **9.1.1**, Gradle **9.3.1**, Kotlin 2.0.21, Compose BOM **2026.05.00** (stable).
- Plugins: `kotlin-compose`, `kotlin-serialization` (for `@Serializable` `NavKey`s). Do **not** apply `kotlin-android` — AGP 9.x folds it in.
- Navigation 3 runtime/ui **1.2.0-alpha02**, Material3 adaptive-navigation3 **1.3.0-beta01**. Both pinned explicitly (not in the stable BOM).
- compileSdk **37** / targetSdk 36 / minSdk 24 / JVM target 11.

**AGP 9.x gotchas:** configure JVM target via the top-level `kotlin { compilerOptions { jvmTarget = JvmTarget.JVM_11 } }` block — the old `android { kotlinOptions { } }` DSL is gone. Adaptive-nav3 ≥ 1.3 requires compileSdk 37 and AGP 9.1+; downgrading either breaks the build.

## Shell note (this user)

SCM Breeze is installed; bare commands fail with `_safe_eval: command not found`. Prefix Bash invocations with `command`:

```
command ./gradlew assembleDebug
```
