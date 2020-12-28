package com.example.timerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*
import java.util.Timer

class MainActivity : AppCompatActivity() {
    var timer = 0
    var minute = 0
    var hour = 0
    var myTimer: Timer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var timerDisplay = findViewById<TextView>(R.id.textView)
        var minuteDisplay = findViewById<TextView>(R.id.minuteView)
        var hourDisplay = findViewById<TextView>(R.id.hourView)

        findViewById<Button>(R.id.start).setOnClickListener {
            if(myTimer != null){
                return@setOnClickListener
            }
            myTimer = Timer()
            myTimer!!.schedule(object :TimerTask(){
                override fun run() {
                    runOnUiThread(object : Runnable{
                        override fun run() {
                            if(timer == 60){
                                minute++
                                if(minute == 60){
                                    hour++
                                    hourDisplay.text = hour.toString()
                                    minute = 0
                                }
                                minuteDisplay.text = minute.toString()
                                timer = 0
                            }
                            timerDisplay.text = timer.toString()
                            timer++
                        }

                    })
                }

            },0,1000)
        }

        findViewById<Button>(R.id.pause).setOnClickListener {
            if(myTimer != null){
                myTimer!!.cancel()
                myTimer = null
            }
        }

        findViewById<Button>(R.id.stop).setOnClickListener {
            if(myTimer != null){
                myTimer!!.cancel()
                myTimer = null
            }
            timer = 0
            timerDisplay.text = timer.toString()
        }

    }
}