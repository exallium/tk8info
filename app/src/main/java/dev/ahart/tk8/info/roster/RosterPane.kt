package dev.ahart.tk8.info.roster

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.ahart.tk8.info.TK8Info

@Composable
fun RosterPane(onSpriteClick: (Int) -> Unit) {
  val spriteSheet = rememberSpriteSheet()
  var query by rememberSaveable { mutableStateOf("") }

  val names = TK8Info.entries.map { stringResource(it.displayName) }
  val visibleIndices = remember(query, names) {
    if (query.isBlank()) names.indices.toList()
    else names.mapIndexedNotNull { i, name ->
      if (name.contains(query, ignoreCase = true)) i else null
    }
  }

  Surface(modifier = Modifier.fillMaxSize()) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding()
    ) {
      OutlinedTextField(
        value = query,
        onValueChange = { query = it },
        placeholder = { Text("Search") },
        singleLine = true,
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 8.dp)
      )
      LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 88.dp),
        contentPadding = PaddingValues(8.dp)
      ) {
        items(visibleIndices, key = { it }) { index ->
          Image(
            painter = spritePainter(spriteSheet, index),
            contentDescription = names[index],
            contentScale = ContentScale.Fit,
            modifier = Modifier
              .padding(4.dp)
              .aspectRatio(74f / 90f)
              .clickable { onSpriteClick(index) }
          )
        }
      }
    }
  }
}
