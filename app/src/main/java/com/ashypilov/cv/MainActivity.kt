package com.ashypilov.cv

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.dialog_confirmation.*

class MainActivity : AppCompatActivity() {

    private val phoneConfirmation: String = "Call the phone?"
    private val emailConfirmation: String = "Send a letter to the mail?"
    private val addresses = arrayOf("shipilov2332@gmail.com")
    private val number: String = "0678735765"
    private var subject: String? = null
    private var emailText: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        call_image_view.setOnClickListener {
            customDialogConfirmation(phoneConfirmation)
        }
        email_image_view.setOnClickListener {
            customDialogConfirmation(emailConfirmation)
        }

        unitFactoryButton.setOnClickListener {
            val intent = Intent(this, UnitActivity::class.java)
            startActivity(intent)
        }

        projectButton.setOnClickListener {
            val intent = Intent(this, MyProjectsActivity::class.java)
            startActivity(intent)
        }

        mindyButton.setOnClickListener {
            dialogMindySupport()
        }
    }

    private fun submitOrder() {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:") // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, addresses)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, emailText)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
    }

    private fun callPhone() {

        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$number")
        startActivity(intent)
    }

    private fun customDialogConfirmation(confirmation: String) {
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.dialog_confirmation)
        customDialog.text_view_confirmation.text = confirmation
        customDialog.tvYes.setOnClickListener {
            if(customDialog.text_view_confirmation.text.equals(phoneConfirmation)) {
                callPhone()
            }
            else {
                submitOrder()
            }
            customDialog.dismiss()
        }
        customDialog.tvNo.setOnClickListener {
            customDialog.dismiss()
        }
        customDialog.show()
//        Log.e("PhoneCustom: ", "" + confirm)
    }

    private fun dialogMindySupport() {
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.dialog_confirmation)
        customDialog.tv_information.visibility = View.VISIBLE
        customDialog.tv_information.setText(R.string.MindySupport)
        customDialog.tvYes.visibility = View.GONE
        customDialog.text_view_confirmation.visibility = View.GONE
        customDialog.tvNo.text = "Сlose"
        customDialog.text_view_confirmation.setTextSize(16.0f)
        customDialog.tvNo.setOnClickListener {
            customDialog.dismiss()
        }
        customDialog.show()
    }

    fun openWebCourse(view: View) {

        when(view) {
            view.iv_udacityKotlinWeb -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.udacity.com/course/kotlin-bootcamp-for-programmers--ud9011"))
                startActivity(intent)
            }
            view.iv_udacityAndroidWeb ->  {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.udacity.com/course/developing-android-apps-with-kotlin--ud9012"))
                startActivity(intent)
            }
            view.iv_udemyAndroidWeb ->  {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.udemy.com/course/android-kak-po-notam-a/"))
                startActivity(intent)
            }
            view.iv_udemyMasterclassWeb ->  {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.udemy.com/course/android-kotlin-developer/"))
                startActivity(intent)
            }
        }
    }
}
