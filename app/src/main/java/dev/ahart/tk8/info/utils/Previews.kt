package dev.ahart.tk8.info.utils

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import dev.ahart.tk8.info.ui.theme.TK8InfoTheme

object Previews {
  @Composable
  fun Preview(content: @Composable () -> Unit) {
    TK8InfoTheme {
      Surface {
        content()
      }
    }
  }
}