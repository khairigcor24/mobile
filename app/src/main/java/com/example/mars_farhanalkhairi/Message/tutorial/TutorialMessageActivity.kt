package com.example.mars_farhanalkhairi.Message.tutorial

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mars_farhanalkhairi.databinding.ActivityMessageTutorialBinding

class TutorialMessageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMessageTutorialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMessageTutorialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adapter = TutorialFragmentAdapter(this)
        binding.tutorialMessageviewPager.adapter = adapter

        binding.dotIndicator.attachTo(binding.tutorialMessageviewPager)

        binding.btnNext.setOnClickListener {
            val currentItem = binding.tutorialMessageviewPager.currentItem
            if (currentItem < 2) {
                binding.tutorialMessageviewPager.currentItem = currentItem + 1
            } else {
                finish()
            }
        }
    }
}
