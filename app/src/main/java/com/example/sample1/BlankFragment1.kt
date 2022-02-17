package com.example.sample1

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sample1.databinding.FragmentBlank1Binding
import retrofit2.Call
import retrofit2.Response
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import com.bumptech.glide.load.engine.DiskCacheStrategy

import com.bumptech.glide.request.RequestOptions

import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import java.text.SimpleDateFormat
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var tv: TextView
    lateinit var s: Array<String?>
    lateinit var im: Array<String?>
    lateinit var imBitmap: Array<Bitmap?>
    lateinit var wu: Array<String?>
    var binding: FragmentBlank1Binding? = null
    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(com.example.sample1.R.layout.fragment_blank1, container, false)
        binding = DataBindingUtil.setContentView(activity as MainActivity, R.layout.fragment_blank1)

// recyclerView=view.findViewById(com.example.etdemo.R.id.recycler_view)
        binding?.recyclerView?.setLayoutManager(LinearLayoutManager(activity))
//        binding?.text1?.text="abcde"

        val sdf = SimpleDateFormat("dd-MM-yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        var titleModel = TitleModel("TITLE", currentDate)
//        titleModel.title ="pqrs"
//        titleModel.date = "2022-02-08"
        binding?.titleModel = titleModel

// recyclerView?.setLayoutManager(LinearLayoutManager(activity))


        try {
            getNews()
        } catch (e: Exception) {
            Log.d("123456", "Exception : " + e)
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun getNews() {
        Log.d("Sameer", "11")
        val news = Pn.newsInstance.getNews()
        Log.d("Sameer", "22")
        news.enqueue(object : retrofit2.Callback<NewsApp> {
            override fun onResponse(call: Call<NewsApp>?, response: Response<NewsApp>?) {
                Log.d("Sameer", "33")
                val news = response?.body()
                if (news != null) {
                    var total = news.item?.get(0)?.newsItem!!.size
                    Log.d("Sameer", "total size: " + total)
                    s = arrayOfNulls(total)
                    wu = arrayOfNulls(total)
                    im = arrayOfNulls(total)
                    imBitmap = arrayOfNulls(total)
                    total -= 1
                    var j: Int = 0
                    var emptyCount: Int = 0
                    var remaining: Int = 0
                    for (i in 0..total) {
                        Log.d(
                            "Sameer",
                            i.toString() + "hl :" + news.item?.get(0)?.newsItem?.get(i)?.hl.toString()
                        )
                        Log.d(
                            "Sameer",
                            i.toString() + "im :" + news.item?.get(0)?.newsItem?.get(i)?.im.toString()
                        )
                    }
                    for (i in 0..total) {
//                        Log.d("Sameer", i.toString()+" hl: "+news.item?.get(0)?.newsItem?.get(i)?.hl.toString())
//                        Log.d("Sameer", i.toString()+" im:"+news.item?.get(0)?.newsItem?.get(i)?.im.toString())
                        if (news.item?.get(0)?.newsItem?.get(i)?.hl == null || news.item?.get(0)?.newsItem?.get(
                                i
                            )?.im == null
                            || news.item?.get(0)?.newsItem?.get(i)?.hl.toString() == "null" || news.item?.get(
                                0
                            )?.newsItem?.get(i)?.im.toString() == "null"
                        ) {
                            Log.d("Sameer", i.toString() + "------------------------****** ")
//                            if (j > 0)
//                                j -= 1
//                            else j = 0
                            emptyCount += 1
                        } else {
                            s[j] = news.item?.get(0)?.newsItem?.get(i)?.hl.toString()
                            wu[j] = news.item?.get(0)?.newsItem?.get(i)?.wu.toString()
                            im[j] = news.item?.get(0)?.newsItem?.get(i)?.im.toString()
                            Log.d("Sameer", i.toString()+"* "+s[j].toString())
//                            try {
//                                val thread = Thread {
//                                    try {
//// Log.d("123456", im[]!!)
//                                        val url = URL(im[j]!!)
//                                        val connection: HttpURLConnection =
//                                            url.openConnection() as HttpURLConnection
//                                        connection.setDoInput(true)
//                                        connection.connect()
//                                        Log.d("123456", "000111111")
//                                        val input: InputStream = connection.getInputStream()
//                                        imBitmap[j] = BitmapFactory.decodeStream(input)
//                                        Log.d("123456", imBitmap[j].toString())
//                                    } catch (e: Exception) {
//                                        Log.d("1234560", e.toString())
//                                    }
//                                }
//                                thread.start()
//                                thread.join()
//
//                            } catch (e: Exception) {
//                                Log.d("123456", e.toString())
//                            }
                            j += 1
                        }
                    }
                    remaining=total-emptyCount+1
//                    Log.d("Sameer", total.toString())
                    Log.d("Sameer", "empty count" + emptyCount.toString())
//                    Log.d("Sameer", remaining.toString())
                    remaining-=1
                    s=s.sliceArray(0..remaining)
                    wu=wu.sliceArray(0..remaining)
                    imBitmap=imBitmap.sliceArray(0..remaining)

                    Log.d("Sameer", s.size.toString())
//                    for (i in 0..total) {
//                        Log.d("Sameer", i.toString() + "hl :" + s[i])
//                        Log.d("Sameer", i.toString() + "im :" + im[i])
//                    }
//                    binding?.recyclerView?.setAdapter(RecyclerViewAdapter(s,wu,imBitmap,activity as MainActivity))
                    binding?.recyclerView?.setAdapter(
                        RecyclerViewAdapter(
                            s,
                            wu,
                            im,
                            activity as MainActivity
                        )
                    )
                    Log.d("Sameer", "success")
                }
            }

            override fun onFailure(call: Call<NewsApp>?, t: Throwable?) {
                Log.d("Sameer", "error", t)
            }

        })
    }
}