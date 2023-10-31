package com.example.dhikrease.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dhikrease.R
import com.example.dhikrease.adapter.DzikirDoaAdapter
import com.example.dhikrease.databinding.ActivityDailyDhikrBinding
import com.example.doadandzikirapp.model.DzikirDoaModel

class DailyDhikrActivity : AppCompatActivity() {

    lateinit var binding: ActivityDailyDhikrBinding
    private val DailyDuaList: ArrayList<DzikirDoaModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyDhikrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setDuaData()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dhikr - Daily"

        binding.apply {
            rvDailyDhikr.layoutManager = LinearLayoutManager(this@DailyDhikrActivity)
            rvDailyDhikr.adapter = DzikirDoaAdapter(DailyDuaList)
        }
    }

    private fun setDuaData() {
        val desc = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val lafaz = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val terjemah = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)


        val minLength = minOf(desc.size, lafaz.size, terjemah.size)

        for (data in 0 until minLength) {
            val doa = DzikirDoaModel(
                desc[data],
                lafaz[data],
                terjemah[data]
            )
            DailyDuaList.add(doa)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}