package com.example.tubesmobrog

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tubesmobrog.databinding.ActivityLoginactivityBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Loginactivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginactivityBinding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginactivityBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.signupredirect.setOnClickListener {
            startActivity(Intent(this@Loginactivity, Signup::class.java))
            finish()
        }
        binding.loginbutton.setOnClickListener {
            val email = binding.loginemailInput.text.toString()

            val password = binding.loginpasswordInput.text.toString()

            //Validasi email
            if (email.isEmpty()){
                binding.loginemailInput.error = "Email Harus Diisi"
                binding.loginemailInput.requestFocus()
                return@setOnClickListener
            }

            //Validasi email tidak sesuai
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.loginpasswordInput.error = "Email Tidak Valid"
                binding.loginpasswordInput.requestFocus()
                return@setOnClickListener
            }

            //Validasi password
            if (password.isEmpty()){
                binding.loginpasswordInput.error = "Password Harus Diisi"
                binding.loginpasswordInput.requestFocus()
                return@setOnClickListener
            }

            LoginFirebase(email,password)
        }
    }
    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Selamat datang $email", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
