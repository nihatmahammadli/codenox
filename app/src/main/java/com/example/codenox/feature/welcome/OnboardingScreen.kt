package com.example.codenox.feature.welcome

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.core.designsystem.components.CodeNoxButton
import com.example.codenox.core.designsystem.components.OnboardingProgressBar
import com.example.codenox.feature.welcome.steps.PersonalizeStep
import com.example.codenox.feature.welcome.steps.SkillLevelStep
import kotlinx.coroutines.launch

data class OnboardingData(
    val name: String = "",
    val nickname: String = "",
    val selectedLevel: Int = 1
)

@Composable
fun OnboardingScreen(
    onFinish: (OnboardingData) -> Unit
) {
    val stepCount = 2
    val pagerState = rememberPagerState(pageCount = { stepCount })
    val scope = rememberCoroutineScope()
    
    // State hoisted here, can be easily moved to a ViewModel
    var onboardingData by remember { mutableStateOf(OnboardingData()) }

    CodeNoxBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                // Added navigationBarsPadding and extra bottom padding to lift the button
                .navigationBarsPadding()
                .padding(bottom = 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            
            OnboardingProgressBar(
                stepCount = stepCount,
                currentStep = pagerState.currentPage,
                modifier = Modifier.padding(top = 16.dp)
            )

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f),
                userScrollEnabled = false
            ) { page ->
                when (page) {
                    0 -> PersonalizeStep(
                        name = onboardingData.name,
                        onNameChange = { onboardingData = onboardingData.copy(name = it) },
                        nickname = onboardingData.nickname,
                        onNicknameChange = { onboardingData = onboardingData.copy(nickname = it) }
                    )
                    1 -> SkillLevelStep(
                        selectedLevel = onboardingData.selectedLevel,
                        onLevelSelected = { onboardingData = onboardingData.copy(selectedLevel = it) }
                    )
                }
            }

            CodeNoxButton(
                text = if (pagerState.currentPage == stepCount - 1) "Start Learning" else "Continue",
                onClick = {
                    if (pagerState.currentPage < stepCount - 1) {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    } else {
                        onFinish(onboardingData)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = Color.Black
                    )
                }
            )
        }
    }
}
