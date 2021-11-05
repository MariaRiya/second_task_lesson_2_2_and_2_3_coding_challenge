package com.example.codingchallenge2_2

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {

    val foods = listOf(
        "milk",
        "bread",
        "meat",
        "fish",
        "chocolate",
        "tomato",
        "banana",
        "carrot",
        "apple",
        "pineapple",
        "juice",
        "orange",
        "potato",
        "eggs",
        "cucumber",
        "beer",
        "wine",
        "popcorn",
        "squid",
        "peach",
        "lime"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, foods
        )

        listView_foods.adapter = adapter

        listView_foods.onItemClickListener = OnItemClickListener { parent, v, position, id ->
            val selectedItem: String = foods[position]

            val replyIntent = Intent()
            replyIntent.putExtra("FOOD", selectedItem)
            setResult(RESULT_OK,replyIntent)
            finish()

        }


    }
}