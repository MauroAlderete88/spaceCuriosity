package com.example.space_curiosity.components.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.space_curiosity.R
import com.example.space_curiosity.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    val vm : MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm.getInfoNasa()

        vm.responseInfo.observe(this,{
            binding.tvTitulo.setText(it.title)
            binding.tvFecha.setText(it.date)
            binding.tvCopy.setText(it.copyright)
            Picasso.get().load(it.hdurl).into(binding.imageView2)
            binding.tvExplained.setText(it.explanation)
        })

    }


}