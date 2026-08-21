package com.example.codenox.feature.auth.presentation.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.core.designsystem.components.OnboardingProgressBar
import com.example.codenox.feature.auth.presentation.onboarding.components.OnboardingAction
import com.example.codenox.feature.auth.presentation.onboarding.components.OnboardingBottomSection
import com.example.codenox.feature.auth.presentation.onboarding.components.OnboardingEffect
import com.example.codenox.feature.auth.presentation.onboarding.components.OnboardingPager
import kotlinx.coroutines.launch


@Composable
fun OnboardingScreen(
    onFinish: () -> Unit
) {
    BaseScreen<OnboardingUiState, OnboardingViewModel> { uiState, viewModel ->
        val pagerState = rememberPagerState(pageCount = { uiState.totalSteps })
        val scope = rememberCoroutineScope()

        LaunchedEffect(pagerState.currentPage) {
            viewModel.onAction(OnboardingAction.PageChanged(pagerState.currentPage))
        }

        LaunchedEffect(Unit) {
            viewModel.effect.collect { effect ->
                when (effect) {
                    OnboardingEffect.NavigateToHome -> onFinish()
                    is OnboardingEffect.ShowError -> { /* Handle Error */ }
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
                    stepCount = uiState.totalSteps,
                    currentStep = pagerState.currentPage,
                    modifier = Modifier.padding(top = 16.dp)
                )

                OnboardingPager(
                    pagerState = pagerState,
                    uiState = uiState,
                    onAction = viewModel::onAction,
                    modifier = Modifier.weight(1f)
                )

                OnboardingBottomSection(
                    currentStep = pagerState.currentPage,
                    stepCount = uiState.totalSteps,
                    isButtonEnabled = uiState.isButtonEnabled,
                    onNextClick = {
                        if (pagerState.currentPage < uiState.totalSteps - 1) {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        } else {
                            viewModel.onAction(OnboardingAction.CompleteOnboarding)
                        }
                    }
                )
            }
        }
    }
}
