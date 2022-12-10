package com.example.characterapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberImagePainter
import com.example.characterapp.data.models.Result

@Composable
fun HomeListView(
    character: LazyPagingItems<Result>,
    onItemClick: () -> Unit,
) {
    LazyColumn(content = {
        items(character) { item ->
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .pointerInput(Unit) {
                            detectTapGestures(

                                onTap = {
                                    onItemClick()
                                }
                            )
                        }
                ) {
                    Image(
                        painter = rememberImagePainter(data = item?.image),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(110.dp)
                            .clip(AbsoluteRoundedCornerShape(10.dp))
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = item?.name.toString(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(text = "Species: ${item?.species}", fontSize = 15.sp)
                        Text(text = "Gender: ${item?.gender}", fontSize = 15.sp)
                    }
                    Spacer(modifier = Modifier.width(90.dp))

                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        tint = Color.Black,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(25.dp)
                    )
                }
                Divider()
            }

        }
    })
}