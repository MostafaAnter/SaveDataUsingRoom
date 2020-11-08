package com.example.savedatausingroom.data.local.users

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Mostafa Anter on 11/8/20.
 */

@Entity
data class UserEntity(
    @PrimaryKey val uid: Int,
    val firstName: String,
    val lastName: String
)