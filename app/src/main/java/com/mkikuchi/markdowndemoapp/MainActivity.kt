package com.mkikuchi.markdowndemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        val node = markwon.parse(
            BufferedReader(
                InputStreamReader(resources.openRawResource(R.raw.markdown_sample))).use {
                    it.readText()
            }
        )
        markwon.setParsedMarkdown(markdownTextView, markwon.render(node))
    }
}
