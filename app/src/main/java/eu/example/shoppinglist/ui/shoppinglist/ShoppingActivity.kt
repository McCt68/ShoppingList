package eu.example.shoppinglist.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import eu.example.shoppinglist.R
import eu.example.shoppinglist.data.db.ShoppingDatabase
import eu.example.shoppinglist.data.repositories.ShoppingRepository

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)


        //val viewModel = ViewModelProvider(this).get(ShoppingViewModel::class.java)
        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)
    }
}