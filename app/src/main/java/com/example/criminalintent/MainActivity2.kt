package com.example.criminalintent

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.TextView
import java.util.*

class MainActivity2 : AppCompatActivity() {
    private lateinit var fAB: FloatingActionButton
    private lateinit var txtView: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        txtView = findViewById(R.id.textView) as TextView
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val hours = calendar.get(Calendar.HOUR_OF_DAY)
        val minutes = calendar.get(Calendar.MINUTE)
        txtView.text = "$day.$month.$year $hours:$minutes"

        val text = getString(R.string.clicked_button)
        val text2 = getString(R.string.back)
        val parentLayout = findViewById<View>(android.R.id.content)
        //Snackbar.make(parentLayout,text, Snackbar.LENGTH_LONG).show()
        val snackbar = Snackbar.make(parentLayout,text,Snackbar.LENGTH_LONG)
        snackbar.setAction(text2,View.OnClickListener { startActivity(Intent(this@MainActivity2, MainActivity::class.java)) }).show()

        fAB = findViewById(R.id.fab2)
        fAB.setOnClickListener {
            startActivity(Intent(this@MainActivity2, MainActivity::class.java))
        }
    }
}