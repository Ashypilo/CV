package com.ashypilov.cv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_unit.*

class UnitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit)

        setSupportActionBar(toolbar_unit_activity)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = "Unit Factory"
        }

        toolbar_unit_activity.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}
