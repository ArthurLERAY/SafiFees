
package com.example.safifeesv0

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.safifeesv0.MainActivity.HashUtils.sha1
import java.security.MessageDigest
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity() {

    object HashUtils {
        public fun sha512(input: String) = hashString("SHA-512", input)

        public fun sha256(input: String) = hashString("SHA-256", input)

        public fun sha1(input: String) = hashString("SHA-1", input)

        /**
         * Supported algorithms on Android:
         *
         * Algorithm	Supported API Levels
         * MD5          1+
         * SHA-1	    1+
         * SHA-224	    1-8,22+
         * SHA-256	    1+
         * SHA-384	    1+
         * SHA-512	    1+
         */
        private fun hashString(type: String, input: String): String {
            val HEX_CHARS = "0123456789ABCDEF"
            val bytes = MessageDigest
                .getInstance(type)
                .digest(input.toByteArray())
            val result = StringBuilder(bytes.size * 2)

            bytes.forEach {
                val i = it.toInt()
                result.append(HEX_CHARS[i shr 4 and 0x0f])
                result.append(HEX_CHARS[i and 0x0f])
            }

            return result.toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         //get reference to button
        val btnLogin = findViewById<Button>(R.id.btn_logIn)
        val loginInput = findViewById<EditText>(R.id.inputText_userName)
        val passwordInput = findViewById<EditText>(R.id.inputText_password)
        val loginValue = loginInput.text.toString()
        val passwordValue = passwordInput.text.toString()
        val text = "$loginValue - $passwordValue"
        // set on-click listener
        btnLogin.setOnClickListener {
            val loginValue = loginInput.text.toString()
            val passwordValue = sha1((passwordInput.text.toString()))
            val gameActivity = Intent(this@MainActivity, DashboardActivity::class.java)
            startActivity(gameActivity)
        }

    }






}
