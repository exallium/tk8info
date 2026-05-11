package dev.ahart.tk8.info.roster

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import dev.ahart.tk8.info.R

const val SPRITE_COLUMNS = 6
const val SPRITE_COUNT = 40

private const val CELL_WIDTH = 74
private const val CELL_HEIGHT = 90

@Composable
fun rememberSpriteSheet(): ImageBitmap = ImageBitmap.imageResource(R.drawable.tk8_spritesheet)

@Composable
fun spritePainter(spriteSheet: ImageBitmap, index: Int): BitmapPainter =
  remember(spriteSheet, index) {
    val col = index % SPRITE_COLUMNS
    val row = index / SPRITE_COLUMNS
    BitmapPainter(
      image = spriteSheet,
      srcOffset = IntOffset(col * CELL_WIDTH, row * CELL_HEIGHT),
      srcSize = IntSize(CELL_WIDTH, CELL_HEIGHT)
    )
  }
