package com.srikanth.androidmvpkotlin.views.viewmodels

import com.srikanth.androidmvpkotlin.views.adapters.AdapterConstants
import com.srikanth.androidmvpkotlin.views.adapters.ViewType


data class UserViewModel(val userId: Long,
                         val displayName: String,
                         val reputation: Long,
                         val profileImage: String) : ViewType {
   /* override fun getViewType(): Int {
        return AdapterConstants.USER_DETAILS
    }*/
    override fun getViewType()  = AdapterConstants.USER_DETAILS
}