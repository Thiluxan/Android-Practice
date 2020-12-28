package com.example.internalstorage

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.FileOutputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    lateinit var nameText: EditText
    lateinit var messageText: EditText
    lateinit var save:Button
    lateinit var view:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameText = findViewById(R.id.name)
        messageText = findViewById(R.id.message)
        save = findViewById(R.id.save)
        view = findViewById(R.id.view)

        save.setOnClickListener {
            var fileName = nameText.text.toString()
            var message = messageText.text.toString()

            var fos:FileOutputStream
            try {
                fos = openFileOutput(fileName, Context.MODE_PRIVATE);
                //default mode is PRIVATE, can be APPEND etc.
                fos.write(message.toByteArray());
                fos.close();
                Toast.makeText(this,"Data Saved",Toast.LENGTH_SHORT).show()
                nameText.text.clear()
                messageText.text.clear()
            }
            catch (e:Exception){
                e.printStackTrace()
            }
        }

        view.setOnClickListener {
            var fileName = nameText.text.toString()
            var stringBuffer = StringBuffer()
            try {
                val inputReader = BufferedReader(
                    InputStreamReader(
                        openFileInput(fileName)
                    )
                )
                var inputString: String
                //Reading data line by line and storing it into the stringbuffer
                //Reading data line by line and storing it into the stringbuffer
                while (inputReader.readLine().also { inputString = it } != null) {
                    stringBuffer.append(
                        """
                            $inputString
                            
                            """.trimIndent()
                    )
                }
            }
            catch (e:Exception){
                e.printStackTrace()
            }
            Toast.makeText(this,stringBuffer.toString(),Toast.LENGTH_LONG).show()
            findViewById<TextView>(R.id.display).text = stringBuffer.toString()
        }
    }
}