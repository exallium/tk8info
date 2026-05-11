package dev.ahart.tk8.info.roster

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.ahart.tk8.info.SideStep
import dev.ahart.tk8.info.TK8Info
import dev.ahart.tk8.info.ThrowGame
import dev.ahart.tk8.info.rememberCharacterStates

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailPane(spriteIndex: Int) {
  val character = TK8Info.entries[spriteIndex]
  val spriteSheet = rememberSpriteSheet()
  val name = stringResource(character.displayName)
  val states = rememberCharacterStates(character)

  Surface(modifier = Modifier.fillMaxSize()) {
    Scaffold(
      containerColor = Color.Transparent,
      topBar = {
        TopAppBar(
          navigationIcon = {
            Image(
              painter = spritePainter(spriteSheet, spriteIndex),
              contentDescription = null,
              modifier = Modifier
                .padding(start = 8.dp)
                .size(40.dp)
            )
          },
          title = { Text(name) }
        )
      }
    ) { padding ->
      LazyColumn(
        modifier = Modifier.padding(padding),
        contentPadding = PaddingValues(horizontal = 16.dp)
      ) {
        item { SectionHeader("Basic Info") }
        item {
          ListItem(
            headlineContent = { Text("Side Step") },
            trailingContent = { SideStepText(character.sideStep) },
            colors = transparentListItemColors()
          )
        }
        item {
          ListItem(
            headlineContent = { Text("Throw Break") },
            trailingContent = { ThrowGameText(character.throwGame) },
            colors = transparentListItemColors()
          )
        }
        items(states) { state ->
          HorizontalDivider()
          SectionHeader(
            "${stringResource(state.fullName)} · ${stringResource(state.code)}"
          )
          stringArrayResource(state.bullets).forEach { bullet ->
            BulletRow(bullet)
          }
        }
      }
    }
  }
}

@Composable
fun CharacterDetailPlaceholder() {
  Surface(modifier = Modifier.fillMaxSize()) {
    Column(
      modifier = Modifier.fillMaxSize().padding(24.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      Text(
        text = "Pick a character",
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.onSurfaceVariant
      )
    }
  }
}

@Composable
private fun BulletRow(text: String) {
  Row(modifier = Modifier.padding(vertical = 4.dp)) {
    Text(
      text = "•",
      style = MaterialTheme.typography.bodyLarge,
      modifier = Modifier.padding(end = 8.dp)
    )
    Text(
      text = text,
      style = MaterialTheme.typography.bodyLarge
    )
  }
}

@Composable
private fun SectionHeader(text: String) {
  Text(
    text = text,
    style = MaterialTheme.typography.titleMedium,
    color = MaterialTheme.colorScheme.primary,
    modifier = Modifier.padding(vertical = 12.dp)
  )
}

@Composable
private fun SideStepText(sideStep: SideStep) {
  Text(
    text = sideStep.name,
    color = when (sideStep) {
      SideStep.SSR -> MaterialTheme.colorScheme.error
      SideStep.SSL -> MaterialTheme.colorScheme.primary
      SideStep.SSC -> MaterialTheme.colorScheme.secondary
    },
    style = MaterialTheme.typography.titleMedium
  )
}

@Composable
private fun ThrowGameText(throwGame: ThrowGame) {
  Text(
    text = throwGame.name,
    style = MaterialTheme.typography.titleMedium
  )
}

@Composable
private fun transparentListItemColors() =
  androidx.compose.material3.ListItemDefaults.colors(containerColor = Color.Transparent)
