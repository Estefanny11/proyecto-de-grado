package com.example.novasentinel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.novasentinel.ui.theme.NovasentinelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.entrada)


        val btn: Button = findViewById(R.id.btnregistrar)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, RegistrarActivity::class.java)
            startActivity(intent)
        }



        @Composable
        fun Greeting(name: String, modifier: Modifier = Modifier) {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
        }

        @Preview(showBackground = true)
        @Composable
        fun GreetingPreview() {
            NovasentinelTheme {
                Greeting("Android")
            }
        }
    }
}