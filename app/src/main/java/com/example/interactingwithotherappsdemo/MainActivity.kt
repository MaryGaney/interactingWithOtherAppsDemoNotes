package com.example.interactingwithotherappsdemo

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.CalendarContract
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        findViewById<Button>(R.id.button).setOnClickListener{
//            // Create the text message with a string.
//            val sendIntent = Intent().apply {
//                action = Intent.ACTION_SEND
//                putExtra(Intent.EXTRA_TEXT, "hello world")
//                type = "text/plain"
//            }
//            // Try to invoke the intent.
//            try {
//                startActivity(sendIntent)
//            } catch (e: ActivityNotFoundException) {
//            // Define what your app should do if no activity can handle the
//                Log.w("MYTAG","activity was not found")
//            }
//        }
//        findViewById<Button>(R.id.button2).setOnClickListener{
//            val intent = Intent(Intent.ACTION_INSERT).apply {
//                data = CalendarContract.Events.CONTENT_URI
//                putExtra(CalendarContract.Events.TITLE, "Exam")
//                putExtra(CalendarContract.Events.EVENT_LOCATION, "anywhere")
//                putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, "17:00")
//                putExtra(CalendarContract.EXTRA_EVENT_END_TIME, "21:00")
//            }
//            if (intent.resolveActivity(packageManager) != null) {
//                startActivity(intent)
//            }
//        }
        val phoneNumber: Long = 1234567890
        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }
            startActivity(intent)

        }
    }
}