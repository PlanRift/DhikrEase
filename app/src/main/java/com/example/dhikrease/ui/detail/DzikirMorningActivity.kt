package com.example.dhikrease.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dhikrease.adapter.DzikirDoaAdapter
import com.example.dhikrease.databinding.ActivityDzikirMorningBinding
import com.example.doadandzikirapp.model.DataDzikirDoaModel


class DzikirMorningActivity : AppCompatActivity() {

    lateinit var binding:ActivityDzikirMorningBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirMorningBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dhikr - Morning"

        binding.apply {
            rvDzikirPagi.layoutManager = LinearLayoutManager(this@DzikirMorningActivity)
            rvDzikirPagi.adapter = DzikirDoaAdapter(DataDzikirDoaModel.listDzikirPagi)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}