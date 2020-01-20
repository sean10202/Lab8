package com.home.lab8

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        btn_send.setOnClickListener {
            when {
                ed_name.length() < 1 ->
                    Toast.makeText(this, "請輸入姓名", Toast.LENGTH_SHORT).show()
                ed_phone.length() < 1 ->
                    Toast.makeText(this, "請輸入電話號碼", Toast.LENGTH_SHORT).show()
                else -> {
                    val bundle = Bundle()
                    bundle.putString("name", ed_name.text.toString())
                    bundle.putString("phone", ed_phone.text.toString())

                    setResult(Activity.RESULT_OK, Intent().putExtras(bundle))
                    finish()
                }
            }
        }
    }
}
