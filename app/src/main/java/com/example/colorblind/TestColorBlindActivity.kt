package com.example.colorblind

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.colorblind.databinding.TesteColorBlindBinding

class TestColorBlindActivity : AppCompatActivity() {

    lateinit var binding: TesteColorBlindBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teste_color_blind)

        binding = DataBindingUtil.setContentView(this, R.layout.teste_color_blind)

        var param = intent.extras?.getInt("img")

        binding.apply {
            if(param == 1) {
                imageView.setImageResource(R.drawable.ish_2)
            } else if (param == 2) {
                imageView.setImageResource(R.drawable.ish_3)
            } else {
                imageView.setImageResource(R.drawable.ish_1)
            }
        }

        binding.SubmitAnswer.setOnClickListener {
            var intent = Intent()
            intent.putExtra("resposta", binding.submitText.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        binding.buttonCancel.setOnClickListener {
            var intent = Intent()
            intent.putExtra("cancelou", "cancelado")
            setResult(Activity.RESULT_CANCELED, intent)
            finish()
        }
    }

}