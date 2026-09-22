package com.example.mars_farhanalkhairi.pertemuan4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mars_farhanalkhairi.MainActivity
import com.example.mars_farhanalkhairi.R
import com.example.mars_farhanalkhairi.databinding.ActivityFourthBinding

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("onCreate", "FourthActivity dibuat pertama kali")
        enableEdgeToEdge()
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = intent.getStringExtra("name")
        val from = intent.getStringExtra("from")
        val age = intent.getIntExtra("age", 0)
        Log.e("Data Intent", "Nama: $name , Usia: $age, Asal: $from")

        binding.btnKembali.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: FourthActivity terlihat di layar")
    }

    override fun onResume() {
        super.onResume()
        Log.e("onResume", "onResume: FourthActivity siap berinteraksi")
    }

    override fun onPause() {
        super.onPause()
        Log.e("onPause", "onPause: FourthActivity dihentikan sementara")
    }

    override fun onStop() {
        super.onStop()
        Log.e("onStop", "onStop: FourthActivity tidak terlihat")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "FourthActivity dihapus dari stack")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("onRestart", "onRestart: FourthActivity dibuka kembali")
    }
}
