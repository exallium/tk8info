# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What this app is

TK8Info is a single-screen Android reference app for Tekken 8 players. It lists all 32 characters with two competitive attributes each: sidestep direction (SSR/SSL/SSC) and throw-game category (NONE/ONE/TWO/CROUCH/FULL). All data is hardcoded — there is no network, database, or user input.

## Architecture

The codebase is intentionally flat. There is no MVVM/repository/DI layer.

- `app/src/main/java/dev/ahart/tk8/info/MainActivity.kt` — `ComponentActivity` that sets a Compose tree containing `TK8InfoList` (Scaffold + TopAppBar + LazyColumn over `TK8Info.entries`).
- `app/src/main/java/dev/ahart/tk8/info/TK8Info.kt` — defines the `SideStep` and `ThrowGame` enums, the `TK8Info` enum (the whole dataset), and the `TK8InfoRow` composable that renders each row.
- `app/src/main/java/dev/ahart/tk8/info/ui/theme/` — Material3 theme; supports dynamic color on Android 12+.
- `app/src/main/java/dev/ahart/tk8/info/utils/` — `Previews.Preview { … }` wrapper applies `TK8InfoTheme` + `Surface`; `@TK8InfoPreview` renders both light and dark.

Adding a character requires two coordinated edits: a new `<string>` in `app/src/main/res/values/strings.xml` and a new entry in the `TK8Info` enum referencing it via `R.string.<name>`.

## Conventions

- Kotlin source uses **2-space indentation** (not the IDE default).
- Compose previews use `@TK8InfoPreview` and wrap content in `Previews.Preview { … }` so light and dark renders share theming.
- Colors come from `MaterialTheme.colorScheme` tokens, not hardcoded values. The enum-to-color mapping for sidesteps lives in `SideStepText` in `TK8Info.kt`.

## Build / test commands

The project uses the Gradle wrapper. Standard commands:

- `./gradlew assembleDebug` — build debug APK
- `./gradlew installDebug` — install on a connected device/emulator
- `./gradlew test` — JVM unit tests
- `./gradlew connectedAndroidTest` — instrumented (Espresso/Compose) tests
- `./gradlew lint` — Android Lint

Run a single instrumented test class:
`./gradlew :app:connectedDebugAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=dev.ahart.tk8.info.ExampleInstrumentedTest`

Versions are pinned in `gradle/libs.versions.toml` (AGP 8.11.0, Kotlin 2.0.21, Compose BOM 2024.09.00, compileSdk/targetSdk 36, minSdk 24, JVM target 11).

## Shell note (this user)

This user has SCM Breeze installed, which breaks bare commands with `_safe_eval: command not found`. Prefix Bash invocations with `command`:

```
command ./gradlew assembleDebug
```
