package com.srikanth.androidmvpkotlin.presentation.views.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.srikanth.androidmvpkotlin.R
import com.srikanth.androidmvpkotlin.presentation.views.fragments.UserListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addUserListFragment()
    }

    private fun addUserListFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, UserListFragment()).commit()
    }

    fun addDetailsFragmentWithTransition(fragment: Fragment) {
        val transaction = supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack("")

        transaction.commit()
    }
}
