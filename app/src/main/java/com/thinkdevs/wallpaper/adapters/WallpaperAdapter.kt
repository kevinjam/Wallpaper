package com.thinkdevs.wallpaper.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.thinkdevs.wallpaper.R
import com.thinkdevs.wallpaper.model.WallPaper

/**
 * Created by kevinjanvier on 05/05/2018.
 */
class WallpaperAdapter(var context:Context, var list:ArrayList<WallPaper>) : RecyclerView.Adapter<WallpaperAdapter.ViewHolder>() {
	
	
	override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
	val view =LayoutInflater.from(parent!!.context).inflate(R.layout.item_category, parent, false)
	return ViewHolder(view)
	}
	
	override fun getItemCount(): Int {
		return list.count()
	}
	
	override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
		holder!!.bindview(context,list[position])
		
	}
	
	class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
		
		val title:TextView = itemView!!.findViewById(R.id.category_name)
		val img:ImageView = itemView!!.findViewById(R.id.img_view)
		fun bindview(mcontext:Context, wallpaper: WallPaper) {
			
			title.text = wallpaper.title
			
			Glide
					.with(mcontext)
					.load(wallpaper.url)
					.into(img)
		
		}
		
		
	}
}