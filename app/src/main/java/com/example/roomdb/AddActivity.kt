package com.example.roomdb

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.roomdb.Database.CatDB
import com.example.roomdb.Entity.Cat
import kotlinx.android.synthetic.main.activity_add.*

//MainActivity에서 Room db와 RecyclerView를 성공적으로 연결하더라도, 아직 추가한 데이터가 없으므로
//RecyclerView에는 아무 정보도 표시되지 않는다. AddActivity를 만들어 데이터 추가가 가능하도록 해주자
class AddActivity : AppCompatActivity() {

    private var catDb : CatDB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        catDb = CatDB.getInstance(this)

        /* 새로운 cat 객체를 생성, id 이외의 값을 지정 후 DB에 추가 */
        val addRunnable = Runnable {
            val newCat = Cat()
            newCat.catName = addName.text.toString()
            newCat.lifeSpan = addLifeSpan.text.toString().toInt()
            newCat.origin = addOrigin.text.toString()
            catDb?.catDao()?.insert(newCat)
        }

        addBtn.setOnClickListener {
            val addThread = Thread(addRunnable)
            addThread.start()

            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }

    override fun onDestroy() {
        CatDB.destroyInstance()
        super.onDestroy()
    }
}