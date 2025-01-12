package com.example.p9cloudfirebase.ui.CustomWidget

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopAppBar(
    title: @Composable () -> Unit,
    navigationIcon: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Tombol Navigasi
        if (navigationIcon != null) {
            Box(
                modifier = Modifier.padding(end = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                navigationIcon()
            }
        }

        // Judul
        Box(
            modifier = Modifier
                .weight(1f)
                .wrapContentWidth(Alignment.Start), // Judul berada di sebelah kanan tombol navigasi
            contentAlignment = Alignment.CenterStart
        ) {
            title()
        }
    }
}
