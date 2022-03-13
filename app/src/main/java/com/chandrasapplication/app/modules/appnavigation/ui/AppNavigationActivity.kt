package com.chandrasapplication.app.modules.appnavigation.ui

import androidx.activity.viewModels
import com.chandrasapplication.app.R
import com.chandrasapplication.app.appcomponents.base.BaseActivity
import com.chandrasapplication.app.databinding.ActivityAppNavigationBinding
import com.chandrasapplication.app.modules.appnavigation.`data`.viewmodel.AppNavigationVM
import com.chandrasapplication.app.modules.welcome.ui.WelcomeActivity
import kotlin.String
import kotlin.Unit

public class AppNavigationActivity :
    BaseActivity<ActivityAppNavigationBinding>(R.layout.activity_app_navigation) {
  private val viewModel: AppNavigationVM by viewModels<AppNavigationVM>()

  public override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras
    binding.appNavigationVM = viewModel
  }

  public override fun setUpClicks(): Unit {
    binding.linearWelcome.setOnClickListener {
      val destIntent = WelcomeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  public companion object {
    public const val TAG: String = "APP_NAVIGATION_ACTIVITY"
  }
}
