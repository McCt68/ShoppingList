package eu.example.shoppinglist.data.repositories

import eu.example.shoppinglist.data.db.ShoppingDatabase
import eu.example.shoppinglist.data.db.entities.shoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun upsert(item: shoppingItem) = db.getShoppingDao().upsert(item)
    suspend fun delete(item: shoppingItem) = db.getShoppingDao().upsert(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}