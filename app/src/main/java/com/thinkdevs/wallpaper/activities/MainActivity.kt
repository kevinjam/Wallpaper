package com.thinkdevs.wallpaper.activities


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
	
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		
		startActivity(Intent(this, HomeActivity::class.java))
		finish()
	
	}
	
	
	
}
