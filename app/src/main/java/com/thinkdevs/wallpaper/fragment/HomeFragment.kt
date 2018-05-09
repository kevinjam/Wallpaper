package com.thinkdevs.wallpaper.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.*
import com.thinkdevs.wallpaper.R
import com.thinkdevs.wallpaper.adapters.CategoryAdapter
import com.thinkdevs.wallpaper.model.Category
import kotlinx.android.synthetic.main.home_fragment.*
import java.util.*

/**
 * Created by kevinjanvier on 23/04/2018.
 */
class HomeFragment : Fragment() {
	lateinit var dbCategory:DatabaseReference
	lateinit var categoryList: ArrayList<Category>
	lateinit var madater:CategoryAdapter
	
	
	
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.home_fragment, container, false)
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		progressBar.visibility = View.VISIBLE
		rectcler_view_home.setHasFixedSize(true)
		rectcler_view_home.layoutManager = GridLayoutManager(activity, 2)
		categoryList = ArrayList()
		
		
		madater = CategoryAdapter(activity!!, categoryList)
		rectcler_view_home.adapter = madater
		
		dbCategory = FirebaseDatabase.getInstance().getReference("categories")
		dbCategory.addListenerForSingleValueEvent(object :ValueEventListener{
			override fun onCancelled(p0: DatabaseError?) {
			}
			
			override fun onDataChange(dataSnapshot: DataSnapshot?) {
			if(dataSnapshot!!.exists()){
			
				progressBar.visibility = View.GONE
			
				for (ds in dataSnapshot.children) {
					val name =ds.key
					val desc = ds.child("desc").getValue(String::class.java)
					val thumbnails = ds.child("thumbnail").getValue(String::class.java)
					
					val c = Category(name, desc!!, thumbnails!!)
					categoryList.add(c)
				}
				madater.notifyDataSetChanged()
			}else{
				Log.d("TAG", "Value is:====")
			}
			
			}
			
		})
		
	}
}