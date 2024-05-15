package com.ihsanfrr.assessment

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {

    private lateinit var myListView: ListView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val foodNames = arrayOf("Sushi", "Poutine", "Pad Thai", "Pizza", "Pho")
        val countries = arrayOf("Japan", "Canada", "Thailand", "Italy", "vietnam")
        val images = intArrayOf(R.drawable.sushi, R.drawable.poutine, R.drawable.padthai, R.drawable.pizza, R.drawable.pho)

        myListView = findViewById(R.id.foodList)
        val customBaseAdapter = CustomBaseAdapter(this, foodNames, countries, images)
        myListView.adapter = customBaseAdapter
    }
}