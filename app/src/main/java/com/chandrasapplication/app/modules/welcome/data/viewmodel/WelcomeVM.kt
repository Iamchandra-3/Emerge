package com.chandrasapplication.app.modules.welcome.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chandrasapplication.app.modules.welcome.`data`.model.WelcomeModel

public class WelcomeVM : ViewModel() {
  public val welcomeModel: MutableLiveData<WelcomeModel> = MutableLiveData(WelcomeModel())

  public var navArguments: Bundle? = null
}
