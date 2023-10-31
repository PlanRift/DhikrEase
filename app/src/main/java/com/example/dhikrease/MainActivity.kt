package com.example.dhikrease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dhikrease.adapter.SectionPagerAdapter
import com.example.dhikrease.databinding.ActivityMainBinding
import com.example.dhikrease.model.ArticleModel
import com.example.dhikrease.ui.CommonDhikrActivity
import com.example.dhikrease.ui.DailyDhikrActivity
import com.example.dhikrease.ui.detail.DzikirEveningActivity
import com.example.dhikrease.ui.detail.DzikirMorningActivity
import com.example.dhikrease.ui.QauliyahDhikrActivity

class MainActivity : AppCompatActivity(), View.OnClickListener  {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPagerAdapter = SectionPagerAdapter(this)
        val viewPager2 = binding.vpArticle


        setView()
    }

    private fun  setView() {
        //setup view artikel
        binding.apply {
            cardMorning.setOnClickListener(this@MainActivity)
            cardEvening.setOnClickListener(this@MainActivity)
            cardQauliyah.setOnClickListener(this@MainActivity)
            cardCommonDhikr.setOnClickListener(this@MainActivity)
            cardDailyDhikr.setOnClickListener(this@MainActivity)
        }
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