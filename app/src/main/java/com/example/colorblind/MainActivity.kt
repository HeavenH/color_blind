package com.example.colorblind

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.colorblind.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.startActivty1.setOnClickListener {
            val intent = Intent(this, TestColorBlindActivity::class.java)
            var param = Bundle()
            param.putInt("img", 1)
            intent.putExtras(param)
            startActivityForResult(intent, 1)
        }

        binding.startActivty2.setOnClickListener {
            var intent = Intent(this, TestColorBlindActivity::class.java)
            var param = Bundle()
            param.putInt("img", 2)
            intent.putExtras(param)
            startActivityForResult(intent, 2)
        }

        binding.startActivty3.setOnClickListener {
            var intent = Intent(this, TestColorBlindActivity::class.java)
            var param = Bundle()
            param.putInt("img", 3)
            intent.putExtras(param)
            startActivityForResult(intent, 3)
        }

        binding.verifyButton.setOnClickListener {
            if(binding.answer1.text == "2" && binding.answer2.text == "29" && binding.answer3.text == "74") {
                binding.resultTest.text = "visão normal!"
                binding.invalidateAll()
            } else {
                binding.resultTest.text = "Procure um médico"
                binding.invalidateAll()
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                binding.answer1.text = data?.extras?.getString("resposta")
                binding.invalidateAll()
            }
        }  else if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {
                binding.answer2.text = data?.extras?.getString("resposta")
                binding.invalidateAll()
            }
        } else if (requestCode == 3) {
            if (resultCode == Activity.RESULT_OK) {
                binding.answer3.text = data?.extras?.getString("resposta")
                binding.invalidateAll()
            }
            }
        }
}