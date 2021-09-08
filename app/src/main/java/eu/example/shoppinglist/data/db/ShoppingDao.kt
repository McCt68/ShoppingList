package eu.example.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import eu.example.shoppinglist.data.db.entities.shoppingItem

// I think this is for declaring functions to interact with the objects in the DB


@Dao
interface ShoppingDao {

    // insert a new ID to the DB, or if it already exist update it
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: shoppingItem) // suspend = can be used asynchronously

    // for deleting items in the DB
    @Delete
    suspend fun delete(item: shoppingItem)


    // should this be suspend ??. ( I dont think so because this dont write or read from DB ?)
    @Query("Select * From shopping_items")
    fun getAllShoppingItems(): LiveData<List<shoppingItem>>
}