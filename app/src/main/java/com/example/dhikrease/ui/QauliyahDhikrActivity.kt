package com.example.dhikrease.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dhikrease.adapter.DzikirDoaAdapter
import com.example.dhikrease.databinding.ActivityQauliyahDhikrBinding
import com.example.doadandzikirapp.model.DataDzikirDoaModel

class QauliyahDhikrActivity : AppCompatActivity() {

    lateinit var binding: ActivityQauliyahDhikrBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQauliyahDhikrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dhikr - Qauliyah"

        binding.apply {
            rvQauliyahShalat.layoutManager = LinearLayoutManager(this@QauliyahDhikrActivity)
            rvQauliyahShalat.adapter = DzikirDoaAdapter(DataDzikirDoaModel.listQauliyah)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}