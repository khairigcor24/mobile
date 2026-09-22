package com.example.mars_farhanalkhairi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mars_farhanalkhairi.databinding.ActivityMainBinding
import com.example.mars_farhanalkhairi.pertemuan4.FourthActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("onCreate", "MainActivity dibuat pertama kali")
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnkirim.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)

            /*tambahkan bagian berikut*/
            intent.putExtra("name", "Farhan Al Khairi")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)

            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: MainActivity terlihat di layar")
    }

    override fun onResume() {
        super.onResume()
        Log.e("onResume", "onResume: MainActivity siap berinteraksi")
    }

    override fun onPause() {
        super.onPause()
        Log.e("onPause", "onPause: MainActivity dihentikan sementara")
    }

    override fun onStop() {
        super.onStop()
        Log.e("onStop", "onStop: MainActivity tidak terlihat")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "MainActivity dihapus dari stack")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("onRestart", "onRestart: MainActivity dibuka kembali")
    }
}
