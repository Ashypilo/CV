package com.ashypilov.cv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_my_projects.*
import kotlinx.android.synthetic.main.activity_unit.*

class MyProjectsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_projects)

        setSupportActionBar(toolbar_my_projects_activity)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = "My Projects"
        }

        toolbar_my_projects_activity.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}
