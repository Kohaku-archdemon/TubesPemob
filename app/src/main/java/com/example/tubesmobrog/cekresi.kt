package com.example.tubesmobrog

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tubesmobrog.databinding.ActivityCekresiBinding
import com.example.tubesmobrog.databinding.ActivityMainBinding

class cekresi : AppCompatActivity() {
    lateinit var binding: ActivityCekresiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCekresiBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        binding.cariresibutton.setOnClickListener {
            startActivity(Intent(this@cekresi, hasilresi::class.java))
            finish()
        }
        binding.backbutton.setOnClickListener {
            startActivity(Intent(this@cekresi, MainActivity::class.java))
            finish()
        }
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}