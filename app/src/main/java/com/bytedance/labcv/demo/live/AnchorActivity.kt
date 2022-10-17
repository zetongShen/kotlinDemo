package com.bytedance.labcv.demo.live

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bytedance.labcv.demo.R
import com.bytedance.labcv.demo.databinding.ActivityAnchorBinding
import com.bytedance.labcv.demo.viewmodels.AnchorFunViewModel


class AnchorActivity : AppCompatActivity() {
    private lateinit var bind: ActivityAnchorBinding
    val anchorFunViewModel by lazy {
        ViewModelProvider(this)[AnchorFunViewModel::class.java]
    }

    private val PERMISSION_REQ_ID = 22

    private val REQUESTED_PERMISSIONS = arrayOf<String>(
        Manifest.permission.RECORD_AUDIO,
        Manifest.permission.CAMERA
    )

    private fun checkSelfPermission(permission: String, requestCode: Int): Boolean {
        if (ContextCompat.checkSelfPermission(this, permission) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, REQUESTED_PERMISSIONS, requestCode)
            return false
        }
        return true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_anchor)
        supportFragmentManager.beginTransaction()
            .replace(R.id.anchor_function_view, AnchorFunctionFragment()).commit()
        anchorFunViewModel.isCloseLive.observe(this) {
            Log.e("AnchorActivity", "监听导致了")
        }
    }
}