package com.example.imad_supp_exam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Link up views from the XML layout
        var totalItemsTextView = findViewById(R.id.tvTotalItems)
        val addItemButton: Button = findViewById(R.id.btnAddItem)
        val viewListButton: Button = findViewById(R.id.btnViewList)

        // Show the total number of items to buy when the screen first loads
        updateTotalItemsDisplay()


        // Navigate to the Detailed View screen (list of all items)
        viewListButton.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.isData)
            startActivity(intent)
        }
    }

    //Refresh the total item count every time we return to this screen.
    override fun onResume() {
        super.onResume()
        updateTotalItemsDisplay()
    }

    //Uses GroceryData's loop-based calculation to update the on-screen total.
    private fun updateTotalItemsDisplay() {
        val total = GroceryData.getTotalItemCount()
        val totalItemsTextView = null
        totalItemsTextView.text = getString(R.string.total_items_format, total)
    }

}