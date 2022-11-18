package br.com.colletor.garbage.acme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSchedule: Button = findViewById(R.id.buttonSchedule)
        val buttonColletor: Button = findViewById(R.id.buttonColletor)

        btnSchedule.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,ScheduleActivity::class.java)
            startActivity(intent)
        })

        buttonColletor.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,ColletorActivity::class.java)
            startActivity(intent)
        })

    }
}