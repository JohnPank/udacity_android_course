package com.johnpank.udacity.colormyviews

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners(){
        val clickableViews = setOf(textView,textView2, textView3, textView4, textView5, btnBlue, btnGreen, btnYellow)
        for (v in clickableViews)
            v.setOnClickListener {  makeColoredIt(it)  }
    }

    private fun makeColoredIt(view: View?) {
        when(view?.id){
            // Boxes using Color class colors for background
            R.id.textView -> view.setBackgroundColor(Color.DKGRAY)
            R.id.textView2 -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.textView3 -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.textView4 -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.textView5 -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom colors for background
            R.id.btnBlue -> textView3.setBackgroundResource(R.color.my_red)
            R.id.btnGreen -> textView4.setBackgroundResource(R.color.my_yellow)
            R.id.btnYellow -> textView5.setBackgroundResource(R.color.my_green)

            else -> view?.setBackgroundColor(Color.LTGRAY)
        }

    }
}
