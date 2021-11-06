package com.example.codingchallenge2_2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listOfTextViews = listOf<TextView>(textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10)

        var resultLauncher = this.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val text =  data?.getStringExtra("FOOD").toString()
                var ok = false
                for (i in 0..listOfTextViews.size-1){
                    if(listOfTextViews[i].text.equals(text)) {
                        ok = true
                        Toast.makeText(this, "This product has already been added to the shopping list", Toast.LENGTH_SHORT).show()
                        break
                    }
                    if(listOfTextViews[i].text.equals("-")){
                        listOfTextViews[i].setText(text)
                        ok = true
                        break
                    }
                }
                if(!ok){
                    Toast.makeText(this, "Sorry, but shopping list is already full", Toast.LENGTH_SHORT).show()
                }
            }
        }

        button_add.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    fun findLocation(view: View) {
        val uri_loc = Uri.parse("geo:0,0?q=" + editText_shop_name.text.toString())
        val new_intent = Intent(Intent.ACTION_VIEW, uri_loc)

        if (new_intent.resolveActivity(packageManager) != null) {
            startActivity(new_intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }
}