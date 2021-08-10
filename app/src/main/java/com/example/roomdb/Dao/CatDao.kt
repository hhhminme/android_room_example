package com.example.roomdb.Dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.roomdb.Entity.Cat

//DB에 접근해 질의를 수행할 DAO. Query를 메소드로 작성해주어야 한다.
@Dao
interface CatDao {
    @Query("SELECT * FROM cat")
    fun getAll(): List<Cat>

    /* import android.arch.persistence.room.OnConflictStrategy.REPLACE */
    @Insert(onConflict = REPLACE)
    fun insert(cat: Cat)

    @Query("DELETE from cat")
    fun deleteAll()
}