package com.example.codenox.core.designsystem.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import kotlin.math.roundToInt

@Composable
fun CodeNoxBottomBar(
    pagerState: PagerState,
    onTabSelected: (BottomBarTab) -> Unit,
    modifier: Modifier = Modifier
) {
    val tabs = BottomBarTab.entries
    val density = LocalDensity.current
    var barWidth by remember { mutableIntStateOf(0) }
    
    val indicatorWidth = if (barWidth > 0) (barWidth / tabs.size) else 0
    val indicatorPadding = 8.dp
    
    val offsetFraction = pagerState.currentPage + pagerState.currentPageOffsetFraction
    val indicatorOffset = with(density) {
        (offsetFraction * indicatorWidth).toDp()
    }

    Box(
        modifier = modifier
            .navigationBarsPadding()
            .padding(horizontal = 16.dp)
            .padding(bottom = 12.dp, top = 8.dp)
            .height(84.dp)
            .clip(RoundedCornerShape(42.dp))
            .background(CodeNoxTheme.colors.surface)
            .onGloballyPositioned { barWidth = it.size.width }
    ) {
        if (barWidth > 0) {
            Box(
                modifier = Modifier
                    .offset { IntOffset(with(density) { indicatorOffset.toPx() }.roundToInt(), 0) }
                    .width(with(density) { indicatorWidth.toDp() })
                    .fillMaxHeight()
                    .padding(indicatorPadding),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(48.dp)
                        .background(CodeNoxTheme.colors.primary.copy(alpha = 0.12f), CircleShape)
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            tabs.forEachIndexed { index, tab ->
                val isSelected = pagerState.currentPage == index
                val contentColor by animateColorAsState(
                    targetValue = if (isSelected) CodeNoxTheme.colors.primary else CodeNoxTheme.colors.textSecondary,
                    label = "color"
                )

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = { onTabSelected(tab) }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(id = tab.icon),
                            contentDescription = stringResource(tab.titleRes),
                            tint = contentColor,
                            modifier = Modifier.size(26.dp)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = stringResource(tab.titleRes),
                            style = CodeNoxTheme.typography.dmSans12Medium,
                            color = contentColor
                        )
                    }
                }
            }
        }
    }
}
