package eu.example.shoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Class for holding data. I think this is basicly my database
// It can hold info about item name and amount


// Kinda mark the class as usable for SQL DB, with @Entity
@Entity(tableName = "shopping_items")
class shoppingItem (
    @ColumnInfo(name = "item_name")
    var name: String,
    @ColumnInfo(name = "item_amount")
    var amount: Int
        ){
    // sets a unique id for every item in the DB
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

}