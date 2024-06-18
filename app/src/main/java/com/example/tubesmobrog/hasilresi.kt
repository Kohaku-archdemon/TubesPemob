package com.example.tubesmobrog

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tubesmobrog.databinding.ActivityCekresiBinding
import com.example.tubesmobrog.databinding.ActivityHasilresiBinding

class hasilresi : AppCompatActivity() {
    lateinit var binding: ActivityHasilresiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityHasilresiBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.backbutton.setOnClickListener {
            startActivity(Intent(this@hasilresi, cekresi::class.java))
            finish()
        }
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}