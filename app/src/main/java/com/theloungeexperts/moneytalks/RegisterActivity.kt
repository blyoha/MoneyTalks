package com.theloungeexperts.moneytalks

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.theloungeexperts.moneytalks.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            loginLink.setOnClickListener {
                startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
            }

            registerButton.setOnClickListener {
                when {
                    TextUtils.isEmpty(emailInput.text.toString().trim { it <= ' ' }) -> {
                        Toast.makeText(
                            this@RegisterActivity,
                            "Please, enter login.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    TextUtils.isEmpty(
                        passwordInput.text.toString().trim { it <= ' ' }) -> {
                        Toast.makeText(
                            this@RegisterActivity,
                            "Please, enter password.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    else -> {
                        val email = passwordInput.text.toString().trim { it <= ' ' }
                        val password = passwordInput.text.toString().trim { it <= ' ' }
                        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val firebaseUser: FirebaseUser = task.result!!.user!!

                                    Toast.makeText(
                                        this@RegisterActivity,
                                        "Registered successfully.",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    val intent = Intent(
                                        this@RegisterActivity,
                                        HomeActivity::class.java
                                    )

                                    intent.flags =
                                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    intent.putExtra("user_id", firebaseUser.uid)
                                    intent.putExtra("email_id", email)
                                    startActivity(intent)
                                    finish()
                                } else {
                                    Toast.makeText(
                                        this@RegisterActivity,
                                        task.exception!!.message.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                    }
                }
            }
        }
    }

}