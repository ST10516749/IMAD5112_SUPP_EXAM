package com.example.imad_supp_exam

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val listView: ListView = findViewById(R.id.lvItems)
        val backButton: Button = findViewById(R.id.btnBack)

        // parallel arrays in GroceryData. Each entry lines up by index.
        val displayItems = mutableListOf<String>()
        for (i in GroceryData.itemNames.indices) {
            val name = GroceryData.itemNames[i]
            val category = GroceryData.categories[i]
            val quantity = GroceryData.quantities[i]
            val comment = GroceryData.comments[i]

            val entry = getString(
                R.string.item_detail_format,
                name, category, quantity, comment
            )
            displayItems.add(entry)
        }


        // row layout
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            displayItems
        )
        listView.adapter = adapter

        // Back to main activity
        backButton.setOnClickListener {
            finish()
        }

    }
}