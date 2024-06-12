package com.example.hw5_1

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hw5_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {

    private val presenter = Presenter(this)

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter.attachView(this)

        with(binding) {
            btnDec.setOnClickListener {
                presenter.onDecrementBtnClicked()
            }
            btnInc.setOnClickListener {
                presenter.onIncrementBtnClicked()
            }
        }
    }

    override fun updateCount(count: Int) {
        binding.tvResult.text = count.toString()
    }

    override fun changeTextColor(color: Int) {
        binding.tvResult.setTextColor(color)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
