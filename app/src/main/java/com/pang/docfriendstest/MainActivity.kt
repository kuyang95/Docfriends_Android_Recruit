package com.pang.docfriendstest

import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toolbar
import androidx.core.graphics.createBitmap
import com.pang.docfriendstest.databinding.ActivityMainBinding

private lateinit var binding : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        // 바인딩하여 view 에 접근해야한다
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 액션바 속성 정의
        setSupportActionBar(binding.toolbar)

        supportActionBar!!.setDisplayShowCustomEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true) // 왼쪽 버튼, 기본값 뒤로가기 버튼
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_search_w) // 왼쪽 버튼 아이콘 변경

        val bitmap = createRoundBitmapIcon(R.drawable.user_profile, this)
        val cropedProfile = BitmapDrawable(resources, bitmap)
        binding.userProfileImage.setImageDrawable(cropedProfile)


    }

    // 툴바 오른쪽 버튼 생성을 위한 오버라이드
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom, menu)
        return true
    }
}