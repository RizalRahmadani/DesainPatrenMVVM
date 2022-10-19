package com.example.desainpatrenmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desainpatrenmvvm.databinding.ActivityMainBinding
import com.example.desainpatrenmvvm.view.AdapterCar
import com.example.desainpatrenmvvm.viewmodel.ViewModelCar

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : ViewModelCar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showDataCar()


    }
    fun showDataCar(){
        viewModel = ViewModelProvider(this).get(ViewModelCar::class.java)
        viewModel.getLiveDataCa().observe(this, {
            if (it != null){
                binding.rvCar.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvCar.adapter = AdapterCar(it)
                val adapter = AdapterCar(it)
                adapter.notifyDataSetChanged()
            }
        })
        viewModel.callApiCar()
    }
}