package com.hamsterdev.subscriber.presentation.main.activeSubscriptions.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hamsterdev.subscriber.R
import com.hamsterdev.subscriber.domain.model.Subscription
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ActiveSubsListItem(
    subscription: Subscription,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick.invoke() }
            .background(colorResource(id = R.color.colorItemBackground), shape = RoundedCornerShape(12.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GlideImage(
            imageModel = subscription.imageUrl,
            modifier = Modifier
                .size(48.dp, 48.dp)
                .clip(CircleShape),
            circularReveal = CircularReveal(),
        )
        Text(
            modifier = Modifier
                .wrapContentWidth(align = Alignment.Start)
                .padding(start = 10.dp, end = 10.dp),
            text = subscription.name,
            textAlign = TextAlign.Left,
            fontSize = 20.sp
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp),
            text = subscription.cost,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Right,
            fontSize = 20.sp
        )
    }
}