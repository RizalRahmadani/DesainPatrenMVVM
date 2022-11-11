@file:Suppress("unused", "unused")

package com.example.desainpatrenmvvm.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desainpatrenmvvm.databinding.ActivityMainBinding
import com.example.desainpatrenmvvm.viewmodel.ViewModelCar

@Suppress("unused", "unused")
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : ViewModelCar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        showDataCar()


    }
    @SuppressLint("NotifyDataSetChanged")
    fun showDataCar(){
        viewModel = ViewModelProvider(this)[ViewModelCar::class.java]
        viewModel.getLiveDataCa().observe(this) {
            if (it != null) {
                binding.rvCar.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvCar.adapter = AdapterCar(it)
                val adapter = AdapterCar(it)
                adapter.notifyDataSetChanged()
            }
        }
        viewModel.callApiCar()
    }
}