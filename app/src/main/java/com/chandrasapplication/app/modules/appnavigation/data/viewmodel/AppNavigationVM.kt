package com.chandrasapplication.app.modules.appnavigation.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chandrasapplication.app.modules.appnavigation.`data`.model.AppNavigationModel

public class AppNavigationVM : ViewModel() {
  public val appNavigationModel: MutableLiveData<AppNavigationModel> =
      MutableLiveData(AppNavigationModel())

  public var navArguments: Bundle? = null
}
