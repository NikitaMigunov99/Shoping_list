package com.example.shoppinglist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = [(Product::class)],version = 1,exportSchema = false)
abstract class AppDataBase: RoomDatabase() {

    companion object {

        private var sInstance: AppDataBase? = null

        @Synchronized
        fun getInstance(context: Context): AppDataBase {
            if (sInstance == null) {
                sInstance = Room
                    .databaseBuilder(context.applicationContext, AppDataBase::class.java, "example")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return sInstance!!
        }
    }


    abstract fun productDao(): Dao
}