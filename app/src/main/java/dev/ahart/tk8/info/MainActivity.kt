package dev.ahart.tk8.info

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfoV2
import androidx.compose.material3.adaptive.layout.calculatePaneScaffoldDirective
import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy
import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import dev.ahart.tk8.info.nav.CharacterDetail
import dev.ahart.tk8.info.nav.Roster
import dev.ahart.tk8.info.roster.CharacterDetailPane
import dev.ahart.tk8.info.roster.CharacterDetailPlaceholder
import dev.ahart.tk8.info.roster.RosterPane
import dev.ahart.tk8.info.ui.theme.TK8InfoTheme

class MainActivity : ComponentActivity() {
  @OptIn(ExperimentalMaterial3AdaptiveApi::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      TK8InfoTheme {
        val backStack = rememberNavBackStack(Roster)

        val windowAdaptiveInfo = currentWindowAdaptiveInfoV2()
        val directive = remember(windowAdaptiveInfo) {
          calculatePaneScaffoldDirective(windowAdaptiveInfo)
            .copy(horizontalPartitionSpacerSize = 0.dp)
        }
        val sceneStrategy = rememberListDetailSceneStrategy<NavKey>(directive = directive)

        val slideOffsetPx = with(LocalDensity.current) { 80.dp.roundToPx() }
        val pushTransform = remember(slideOffsetPx) {
          ContentTransform(
            targetContentEnter = slideInHorizontally(initialOffsetX = { slideOffsetPx }),
            initialContentExit = fadeOut() + slideOutHorizontally(targetOffsetX = { -slideOffsetPx }),
          )
        }
        val popTransform = remember(slideOffsetPx) {
          ContentTransform(
            targetContentEnter = slideInHorizontally(initialOffsetX = { -slideOffsetPx }),
            initialContentExit = fadeOut() + slideOutHorizontally(targetOffsetX = { slideOffsetPx }),
          )
        }

        Surface(modifier = Modifier.fillMaxSize()) {
          NavDisplay(
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            sceneStrategies = listOf(sceneStrategy),
            transitionSpec = { pushTransform },
            popTransitionSpec = { popTransform },
            predictivePopTransitionSpec = { popTransform },
            entryProvider = entryProvider {
              entry<Roster>(
                metadata = ListDetailSceneStrategy.listPane(
                  detailPlaceholder = { CharacterDetailPlaceholder() }
                )
              ) {
                RosterPane(
                  onSpriteClick = { index ->
                    val next = CharacterDetail(index)
                    if (backStack.lastOrNull() is CharacterDetail) {
                      backStack[backStack.lastIndex] = next
                    } else {
                      backStack.add(next)
                    }
                  }
                )
              }
              entry<CharacterDetail>(
                metadata = ListDetailSceneStrategy.detailPane()
              ) { detail ->
                CharacterDetailPane(spriteIndex = detail.spriteIndex)
              }
            }
          )
        }
      }
    }
  }
}
