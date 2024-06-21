package com.route.neuronseekinglearn.common

import android.content.Context
import android.content.SharedPreferences
import com.route.neuronseekinglearn.Constant
import com.route.neuronseekinglearn.model.User

class PreferencesManager(val context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("User Data", Context.MODE_PRIVATE)

    private val editor = sharedPreferences.edit()

    fun saveUserData(user: User) {
        editor.putString(Constant.USER_NAME, user.userName)
        editor.putString(Constant.USER_EMAIL, user.email)
        editor.putString(Constant.USER_ID, user.id)
        editor.commit()
    }

    fun setUserLoginState(isLoggedIn : Boolean ){
        editor.putBoolean(Constant.IS_LOGIN, true)
    }

    fun getSavedUser() : User {
        val userName = sharedPreferences.getString(Constant.USER_NAME, null)
        val userId = sharedPreferences.getString(Constant.USER_ID, null)
        val userEmail = sharedPreferences.getString(Constant.USER_EMAIL, null)

        return User(id = userId , userName = userName, email = userEmail)
    }
    fun getLoginState():Boolean{
        return sharedPreferences.getBoolean(Constant.IS_LOGIN ,false )
    }

}