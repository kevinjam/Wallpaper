package com.thinkdevs.wallpaper.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.thinkdevs.wallpaper.R
import com.thinkdevs.wallpaper.activities.WallerPaperActivity
import com.thinkdevs.wallpaper.model.Category
import com.thinkdevs.wallpaper.utility.CATEGORY_NAME

/**
 * Created by kevinjanvier on 05/05/2018.
 */
class CategoryAdapter(var context:Context, var catlist:ArrayList<Category>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
	
	
	override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
	val view =LayoutInflater.from(parent!!.context).inflate(R.layout.item_category, parent, false)
	return ViewHolder(view)
	}
	
	override fun getItemCount(): Int {
		return catlist.count()
	}
	
	override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
		holder!!.bindview(context,catlist[position])
		
	}
	
	class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
		
		val title:TextView = itemView!!.findViewById(R.id.category_name)
		val img:ImageView = itemView!!.findViewById(R.id.img_view)
		val relativ:RelativeLayout = itemView!!.findViewById(R.id.relativ)
		fun bindview(mcontext:Context,category: Category) {
			
			title.text = category.name
			
			Glide
					.with(mcontext)
					.load(category.thumb)
					.into(img)
			
			
			relativ.setOnClickListener {
				val intent = Intent(mcontext, WallerPaperActivity::class.java )
				intent.putExtra(CATEGORY_NAME, category.name)
				mcontext.startActivity(intent)
			}
		
		}
		
		
	}
}