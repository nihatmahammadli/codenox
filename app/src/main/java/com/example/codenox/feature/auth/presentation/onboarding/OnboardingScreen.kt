package com.example.codenox.feature.auth.presentation.onboarding

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
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.core.designsystem.components.CodeNoxButton
import com.example.codenox.core.designsystem.components.OnboardingProgressBar
import com.example.codenox.feature.auth.model.OnboardingData
import com.example.codenox.feature.auth.presentation.onboarding.steps.PersonalizeStep
import com.example.codenox.feature.auth.presentation.onboarding.steps.SkillLevelStep
import kotlinx.coroutines.launch



@Composable
fun OnboardingScreen(
    onFinish: () -> Unit
) {
    BaseScreen<OnboardingUiState, OnboardingViewModel> { uiState, viewModel ->
        val stepCount = 2
        val pagerState = rememberPagerState(pageCount = { stepCount })
        val scope = rememberCoroutineScope()

        LaunchedEffect(pagerState.currentPage) {
            viewModel.onAction(
                OnboardingAction.PageChanged(pagerState.currentPage)
            )
        }

        LaunchedEffect(Unit) {
            viewModel.effect.collect { effect ->

                when(effect){
                    OnboardingEffect.NavigateToHome -> {
                        onFinish()
                    }
                    is OnboardingEffect.ShowError -> {
                        // Snackbar əlavə edə bilərik
                    }
                }
            }
        }

        CodeNoxBackground {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
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
                        0 -> PersonalizeStep(state = uiState, onAction = viewModel::onAction)
                        1 -> SkillLevelStep(state = uiState, onAction = viewModel::onAction)
                    }
                }

                CodeNoxButton(
                    text = if (pagerState.currentPage == stepCount - 1) "Start Learning" else "Continue",
                    enabled = uiState.isButtonEnabled,
                    onClick = {
                        if (pagerState.currentPage < stepCount - 1) {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        } else {
                            viewModel.onAction(
                                OnboardingAction.CompleteOnboarding
                            )
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
}
