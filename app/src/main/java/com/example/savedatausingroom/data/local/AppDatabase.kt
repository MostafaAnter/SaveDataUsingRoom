package com.example.savedatausingroom.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.savedatausingroom.data.local.users.UserDao
import com.example.savedatausingroom.data.local.users.UserEntity

/**
 * Created by Mostafa Anter on 11/8/20.
 */

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao
}