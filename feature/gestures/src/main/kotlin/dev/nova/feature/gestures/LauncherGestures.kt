package dev.nova.feature.gestures

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput

@Composable
fun LauncherGestures(
    modifier: Modifier = Modifier,
    onSwipeUp: () -> Unit = {},
    onSwipeDown: () -> Unit = {},
    onDoubleTap: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onDoubleTap = { onDoubleTap() })
            }
            .pointerInput(Unit) {
                detectVerticalDragGestures { _, dragAmount ->
                    if (dragAmount < -50f) onSwipeUp()
                    if (dragAmount > 50f) onSwipeDown()
                }
            }
    ) {
        content()
    }
}
