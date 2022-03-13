package com.chandrasapplication.app.modules.welcome.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.chandrasapplication.app.R
import com.chandrasapplication.app.appcomponents.base.BaseActivity
import com.chandrasapplication.app.databinding.ActivityWelcomeBinding
import com.chandrasapplication.app.modules.welcome.`data`.viewmodel.WelcomeVM
import kotlin.String
import kotlin.Unit

public class WelcomeActivity : BaseActivity<ActivityWelcomeBinding>(R.layout.activity_welcome) {
  private val viewModel: WelcomeVM by viewModels<WelcomeVM>()

  public override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras
    binding.welcomeVM = viewModel
  }

  public override fun setUpClicks(): Unit {
  }

  public companion object {
    public const val TAG: String = "WELCOME_ACTIVITY"

    public fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, WelcomeActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
