package com.moon.mapApplicationTest.utils.dialogUtils

import com.moon.mapApplicationTest.ui.base.IBaseNavigator

interface IDialogNavigation : IBaseNavigator {
    fun onNext()
    fun onPositive()
    fun onCancel()
}