package com.example.dhikrease.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dhikrease.adapter.DzikirDoaAdapter
import com.example.dhikrease.databinding.ActivityCommonDhikrBinding
import com.example.doadandzikirapp.model.DataDzikirDoaModel

class CommonDhikrActivity : AppCompatActivity() {

    lateinit var binding: ActivityCommonDhikrBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommonDhikrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dhikr - Common"


        binding.apply {
            rvCommonDhikr.layoutManager = LinearLayoutManager(this@CommonDhikrActivity)
            rvCommonDhikr.adapter = DzikirDoaAdapter(DataDzikirDoaModel.listDzikir)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}
