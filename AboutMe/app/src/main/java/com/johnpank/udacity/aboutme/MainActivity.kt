package com.johnpank.udacity.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.johnpank.udacity.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var myName:MyName = MyName("JohnPank")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
//        findViewById<Button>(R.id.btnDone).setOnClickListener{
//            addNickname(it)
//        }
        binding.btnDone.setOnClickListener(){
            addNickname(it)
        }

    }

    private fun addNickname(view: View){
        binding.apply {
            binding.myName?.nickName = etNickname.text.toString()
            invalidateAll()
            etNickname.visibility = View.GONE
            view.visibility = View.GONE
            twNickname.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}
