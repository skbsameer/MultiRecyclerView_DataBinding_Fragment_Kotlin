package com.example.sample1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sample1.databinding.RecyclerViewItemAnotherBinding
import com.example.sample1.databinding.RecyclerViewItemBinding

import java.lang.Exception

class RecyclerViewAdapter(
    private val data: Array<String?>,
    private val wu: Array<String?>,
//    private val imBitmap: Array<Bitmap?>,
    private val im: Array<String?>,
    var mainActivity: MainActivity,
) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.recycler_view_item, parent, false)

        if (viewType == 1) {
            var binding: RecyclerViewItemBinding
            binding = DataBindingUtil.inflate(
                inflater,
                R.layout.recycler_view_item, parent, false
            )
            return ViewHolder(binding)
        } else {
            var binding: RecyclerViewItemAnotherBinding
            binding = DataBindingUtil.inflate(
                inflater,
                R.layout.recycler_view_item_another, parent, false
            )
            return ViewHolder(binding)
        }

    }

    override fun getItemViewType(position: Int): Int {
        if (position % 2 == 0) {
            return 0
        }
        return 1
    }


    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(
        binding.root
    )

//    class ViewHolderOne(val binding1: RecyclerViewItemBinding) : RecyclerView.ViewHolder(
//        binding1.root
//    )
//
//    class ViewHolderTwo(val binding2: RecyclerViewItemAnotherBinding) : RecyclerView.ViewHolder(
//        binding2.root
//    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val txt = data[position]
        if (position % 2 != 0) {
            val binding: RecyclerViewItemBinding = holder.binding as RecyclerViewItemBinding
            binding.textView.text = txt
            Glide.with(mainActivity)
                .load(im[position]) // image url
                .placeholder(R.drawable.ic_launcher_background) // any placeholder to load at start
                .error(R.drawable.ic_launcher_background)  // any image in case of error
                .override(200, 200) // resizing
                .centerCrop()
                .into(binding.imageView);  // imageview object

            binding.linearLayout.setOnClickListener({
                val bundle = Bundle()
                bundle.putString("abcde", wu[position])

                val fragmentTransaction =
                    mainActivity.getSupportFragmentManager().beginTransaction()
                var blankFragment2 = BlankFragment2()
                blankFragment2.arguments = bundle
                fragmentTransaction.replace(R.id.frag1, blankFragment2).addToBackStack(null)
                    .commit()
            })
        } else {
            val binding: RecyclerViewItemAnotherBinding =
                holder.binding as RecyclerViewItemAnotherBinding

            Glide.with(mainActivity)
                .load(im[position]) // image url
                .placeholder(R.drawable.ic_launcher_background) // any placeholder to load at start
                .error(R.drawable.ic_launcher_background)  // any image in case of error
                .override(200, 200) // resizing
                .centerCrop()
                .into(binding.imageView);  // imageview object

            binding.linearLayout.setOnClickListener({
                val bundle = Bundle()
                bundle.putString("abcde", wu[position])

                val fragmentTransaction =
                    mainActivity.getSupportFragmentManager().beginTransaction()
                var blankFragment2 = BlankFragment2()
                blankFragment2.arguments = bundle
                fragmentTransaction.replace(R.id.frag1, blankFragment2).addToBackStack(null)
                    .commit()

            })
        }


    }

//    inner class ViewHolder(itemView: RecyclerViewItemBinding) : RecyclerView.ViewHolder() {
//        var txtView: TextView
//        private val binding: RecyclerViewItemBinding? = null
//        init {
////            txtView = itemView.findViewById(R.id.textView)
//            txtView = binding?.textView!!
//        }
//    }
}