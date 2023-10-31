package com.example.dhikrease.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dhikrease.adapter.DzikirDoaAdapter
import com.example.dhikrease.databinding.ActivityDzikirEveningBinding
import com.example.doadandzikirapp.model.DataDzikirDoaModel

class DzikirEveningActivity : AppCompatActivity() {

    lateinit var binding: ActivityDzikirEveningBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirEveningBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dhikr - Evening"

        binding.apply {
            rvDzikirPetang.layoutManager = LinearLayoutManager(this@DzikirEveningActivity)
            rvDzikirPetang.adapter = DzikirDoaAdapter(DataDzikirDoaModel.listDzikirPetang)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}