package com.theloungeexperts.moneytalks

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.theloungeexperts.moneytalks.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            registerLink.setOnClickListener {
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            }

            loginButton.setOnClickListener {
                when {
                    android.text.TextUtils.isEmpty(
                        emailInput.text.toString().trim { it <= ' ' }) -> {
                        android.widget.Toast.makeText(
                            this@LoginActivity,
                            "Please, enter email.",
                            android.widget.Toast.LENGTH_SHORT
                        ).show()
                    }

                    android.text.TextUtils.isEmpty(
                        passwordInput.text.toString().trim { it <= ' ' }) -> {
                        android.widget.Toast.makeText(
                            this@LoginActivity,
                            "Please, enter password.",
                            android.widget.Toast.LENGTH_SHORT
                        ).show()
                    }
                    else -> {
                        val email = passwordInput.text.toString().trim { it <= ' ' }
                        val password = passwordInput.text.toString().trim { it <= ' ' }
                        com.google.firebase.auth.FirebaseAuth.getInstance()
                            .signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    android.widget.Toast.makeText(
                                        this@LoginActivity,
                                        "Logged in successfully.",
                                        android.widget.Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                    }
                }
            }
        }
    }
}