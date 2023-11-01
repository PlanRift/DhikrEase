package com.example.dhikrease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.example.dhikrease.adapter.ArticleAdapter
import com.example.dhikrease.databinding.ActivityMainBinding
import com.example.dhikrease.model.ArticleModel
import com.example.dhikrease.ui.CommonDhikrActivity
import com.example.dhikrease.ui.DailyDhikrActivity
import com.example.dhikrease.ui.detail.DzikirEveningActivity
import com.example.dhikrease.ui.detail.DzikirMorningActivity
import com.example.dhikrease.ui.QauliyahDhikrActivity

class MainActivity : AppCompatActivity(), View.OnClickListener  {

    private lateinit var binding: ActivityMainBinding
    private lateinit var slideIndicator : Array<ImageView?>
    private val  listArticle: ArrayList<ArticleModel> = arrayListOf()

    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (i in 0 until listArticle.size) {
                slideIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.dot_inactive)
                )
            }


            slideIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.dot_active)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        setDataArtikel()
        setView()
        setUpViewPagerArtikel()
    }

    private fun  setView() {
        //setup view artikel
        binding.apply {
            vpArticle.adapter = ArticleAdapter(listArticle)
            vpArticle.registerOnPageChangeCallback(slidingCallback)

            cardMorning.setOnClickListener(this@MainActivity)
            cardEvening.setOnClickListener(this@MainActivity)
            cardQauliyah.setOnClickListener(this@MainActivity)
            cardCommonDhikr.setOnClickListener(this@MainActivity)
            cardDailyDhikr.setOnClickListener(this@MainActivity)
        }
    }


    private  fun setDataArtikel() {
        // bagian artikel
        val titleArtikel = resources.getStringArray(R.array.arr_title_artikel)
        val descArtikel = resources.getStringArray(R.array.arr_desc_artikel)
        val imgArtikel = resources.obtainTypedArray(R.array.arr_img_artikel)


        for (data in titleArtikel.indices) {
            val artikel = ArticleModel(
                imgArtikel.getResourceId(data, 0),
                titleArtikel[data],
                descArtikel[data]
            )
            listArticle.add(artikel)
        }
        imgArtikel.recycle()


    }

    private fun setUpViewPagerArtikel() {
        val llSliderDots = binding.llSliderDots

        slideIndicator = arrayOfNulls(listArticle.size)

        for (i in 0 until listArticle.size) {
            slideIndicator[i] = ImageView(this)
            slideIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext, R.drawable.dot_inactive
                )
            )


            // menentukan lebar dan tinggi indicator
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            // mengatur jarak antar indicator
            params.setMargins(9, 0, 8, 0)
            // mengatur posisi indicator
            params.gravity = Gravity.CENTER_VERTICAL
            // menerapkan params sebagai aturan bagaimana indicator ditampilkan
            llSliderDots.addView(slideIndicator[i], params)
        }

        slideIndicator[0]?.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext, R.drawable.dot_inactive
            )
        )
    }



    override fun onClick(v: View?) {
        when(v?.id){
            R.id.card_morning -> {
                val intentDOS = Intent(this@MainActivity, DzikirMorningActivity::class.java)
                startActivity(intentDOS)
            }
            R.id.card_evening -> {
                val intentDOS = Intent(this@MainActivity, DzikirEveningActivity::class.java)
                startActivity(intentDOS)
            }
            R.id.card_qauliyah -> {
                val intentDOS = Intent(this@MainActivity, QauliyahDhikrActivity::class.java)
                startActivity(intentDOS)
            }
            R.id.card_common_dhikr -> {
                val intentDOS = Intent(this@MainActivity, CommonDhikrActivity::class.java)
                startActivity(intentDOS)
            }
            R.id.card_daily_dhikr -> {
                val intentDOS = Intent(this@MainActivity, DailyDhikrActivity::class.java)
                startActivity(intentDOS)
            }
        }
    }
}