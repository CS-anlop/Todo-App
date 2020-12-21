package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var items = arrayListOf<String>()

        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, items)

        val add = findViewById<Button>(R.id.add)
        val editText = findViewById<EditText>(R.id.editText)
        val listView = findViewById<ListView>(R.id.listView)

        add.setOnClickListener {
            items.add(editText.text.toString())
            listView.adapter = adapter
            adapter.notifyDataSetChanged()
            editText.text.clear()
        }


        val delete = findViewById<Button>(R.id.delete)

        delete.setOnClickListener {
            val position: SparseBooleanArray = listView.checkedItemPositions
            val count = listView.count
            var item = count - 1
            while (item >= 0) {
                if (position.get(item)) {
                    adapter.remove(items.get(item))
                }
                item--
            }
            position.clear()
            adapter.notifyDataSetChanged()

        }

        val clear = findViewById<Button>(R.id.clear)

        clear.setOnClickListener {

            items.clear()
            adapter.notifyDataSetChanged()

        }

    }
}