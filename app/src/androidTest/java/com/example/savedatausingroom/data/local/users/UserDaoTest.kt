package com.example.savedatausingroom.data.local.users

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.androiddevs.shoppinglisttestingyt.getOrAwaitValue
import com.example.savedatausingroom.data.local.AppDatabase
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import com.google.common.truth.Truth.assertThat
import org.junit.Rule


/**
 * Created by Mostafa Anter on 11/8/20.
 */
// to tell junit that all test here need emulator to run as instrumntation test
@RunWith(AndroidJUnit4::class)
@SmallTest
class UserDaoTest {

    // inform to execute tests syncronous
    @get: Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: AppDatabase
    private lateinit var dao: UserDao

    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()

        dao = database.userDao()
    }

    @After
    fun tearDown(){
        database.close()
    }

    @Test
    fun insertUser() = runBlockingTest {
        val user = UserEntity(1, "Mostafa", "Anter")
        dao.insertAll(user)

        val allUsers = dao.getAll().getOrAwaitValue()

        assertThat(allUsers).contains(user)
    }
}