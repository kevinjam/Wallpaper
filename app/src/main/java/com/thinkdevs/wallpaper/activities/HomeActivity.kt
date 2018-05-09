package com.thinkdevs.wallpaper.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.thinkdevs.wallpaper.R
import com.thinkdevs.wallpaper.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() , BottomNavigationView.OnNavigationItemSelectedListener{
	
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_home)
		bottom_navigation.setOnNavigationItemSelectedListener(this)
		
		displayFragment(HomeFragment())
	
	}
	
	
	
	
	
	override fun onNavigationItemSelected(item: MenuItem): Boolean {
		
		var fragment =Fragment()
		
		when(item.itemId){
			R.id.nav_home ->{
				fragment = HomeFragment()
			
			}
			R.id.nav_favority->{
				fragment = HomeFragment()
			}
			R.id.nav_setting->{
				fragment = HomeFragment()
			}
		}
		displayFragment(fragment)
		return true
	}
	
	private fun displayFragment(fragment: Fragment) {
	supportFragmentManager.beginTransaction().replace(R.id.content_area, fragment).commit()
	
	}
}
