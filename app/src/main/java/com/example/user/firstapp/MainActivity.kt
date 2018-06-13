package com.example.user.firstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

import java.util.*

class MainActivity : AppCompatActivity() {

    private var foodList = mutableListOf("Hamburger", "Mexican", "Vietnamese", "Chinese")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAddFood.setOnClickListener {

            if (txtNewFood.text.isNotBlank()) {
                foodList.add(txtNewFood.text.toString())
                txtNewFood.text.clear()
            }
        }

        btnDecide.setOnClickListener {

            var nextItem: String
            do { nextItem = randomItem() }
                while (nextItem == txtFood.text)

            txtFood.text = nextItem
        }
    }

    fun randomItem() : String {
        val rnd = Random().nextInt(foodList.size)
        return foodList[rnd]
    }

}
