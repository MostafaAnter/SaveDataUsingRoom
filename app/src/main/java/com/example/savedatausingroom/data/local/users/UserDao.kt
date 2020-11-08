package com.example.savedatausingroom.data.local.users

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
 * Created by Mostafa Anter on 11/8/20.
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM UserEntity")
    fun getAll(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM USERENTITY WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): LiveData<List<UserEntity>>

    @Query("SELECT * FROM UserEntity WHERE firstName LIKE :first AND " +
            "lastName LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): LiveData<UserEntity>

    @Insert
    suspend fun insertAll(vararg users: UserEntity)

    @Delete
    suspend fun delete(user: UserEntity)
}