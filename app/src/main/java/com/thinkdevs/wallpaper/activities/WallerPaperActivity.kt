package com.thinkdevs.wallpaper.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.google.firebase.database.*

import com.thinkdevs.wallpaper.R
import com.thinkdevs.wallpaper.adapters.WallpaperAdapter
import com.thinkdevs.wallpaper.model.WallPaper
import com.thinkdevs.wallpaper.utility.CATEGORY_NAME
import kotlinx.android.synthetic.main.activity_waller_paper.*
import java.util.ArrayList

class WallerPaperActivity : AppCompatActivity() {
	lateinit var dbWallerPaper: DatabaseReference
	lateinit var wallpaperList: ArrayList<WallPaper>
	lateinit var madater: WallpaperAdapter
	
	
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_waller_paper)
		
		wallpaperList = ArrayList()
		recycler_view_home.setHasFixedSize(true)
		recycler_view_home.layoutManager= LinearLayoutManager(this)
		
		madater = WallpaperAdapter(this, wallpaperList)
		recycler_view_home.adapter = madater
		
		val intent = intent
		val category = intent.getStringExtra(CATEGORY_NAME)
		toolbar.title =category
		
		dbWallerPaper = FirebaseDatabase.getInstance().getReference("images")
				.child(category)
		
		progressBar.visibility = View.VISIBLE
		dbWallerPaper.addListenerForSingleValueEvent(object :ValueEventListener{
			override fun onCancelled(p0: DatabaseError?) {
			
			}
			
			override fun onDataChange(p0: DataSnapshot?) {
				progressBar.visibility = View.GONE
				
				if (p0!!.exists()){
					for (ds in p0.children) {
						val w = p0.getValue(WallPaper::class.java)
						wallpaperList.add(w!!)
						println("000 " +w)
						println("LIST $wallpaperList")
					
					}
					madater.notifyDataSetChanged()
				
				}else{
					println("problem displaying " +p0.children)
				}
			}
			
		})
		
		
	}
}
