package com.bytedance.labcv.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bytedance.labcv.demo.databinding.ActivityMainBinding
import com.bytedance.labcv.demo.live.AnchorActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewAnchor.setOnClickListener {
            startActivity(Intent(this, AnchorActivity::class.java))
        }

    }
}