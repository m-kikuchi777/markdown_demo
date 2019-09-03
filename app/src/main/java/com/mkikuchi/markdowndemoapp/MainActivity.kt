package com.mkikuchi.markdowndemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.noties.markwon.Markwon
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val markwon = Markwon.create(this)

        try {
            val cheatsheet = assets.open("Markdown-Here-Cheatsheet.md")
            val br = BufferedReader(InputStreamReader(cheatsheet))

            var text = ""

            while (true) {
                val str = br.readLine()
                if (str != null) {
                    text += str + "\n"
                } else {
                    break
                }
            }

            markwon.setMarkdown(markdownTextView, text)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
