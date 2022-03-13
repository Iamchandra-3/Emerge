package com.chandrasapplication.app.modules.welcome.`data`.model

import com.chandrasapplication.app.R
import com.chandrasapplication.app.appcomponents.di.MyApp
import kotlin.String

public data class WelcomeModel(
  /**
   * TODO Replace with dynamic value
   */
  public var txtEMERGE: String? = MyApp.getInstance().resources.getString(R.string.lbl_emerge)
  ,
  /**
   * TODO Replace with dynamic value
   */
  public var txtWELCOMETO: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_welcome_to)
  ,
  /**
   * TODO Replace with dynamic value
   */
  public var txtOFFICESAFETY: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_office_safety)

)
