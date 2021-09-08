package eu.example.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import eu.example.shoppinglist.data.db.entities.shoppingItem

@Database(
    entities = [shoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase : RoomDatabase(){

    abstract fun getShoppingDao(): ShoppingDao

    companion object {
        @Volatile
        private var instance: ShoppingDatabase? = null
        private val LOCK = Any()

        // invoke function will be executed when we create a Shoppingdatabase object
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
            ShoppingDatabase::class.java, "shoppingDB.db").build()
    }
}