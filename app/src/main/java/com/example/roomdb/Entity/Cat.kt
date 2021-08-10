package com.example.roomdb.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


//database 안에 있는 테이블을 java나 kotlin 클래스로 나타낸 것이다. 데이터 모델 클래스 라고 볼 수 있다.
//Entity를 import해서 Entity로 선언된 클래스를 만들 수 있다. 데이터 모델인 '고양이'에 무엇이 들어갈지 정의
//각각의 entity는 고유 식별자인 기본키가 필요. 큰 의미가 없다면 autoGenerate를 이용해 자동으로 생성되게 하는 것도 가능

//@Entity
//class cat(@PrimaryKey(autoGenerate = true) var id: Long?,
//...
//)

@Entity(tableName = "cat")
class Cat(@PrimaryKey var id: Long?,
          @ColumnInfo(name = "catname") var catName: String?,
          @ColumnInfo(name = "lifespan") var lifeSpan: Int,
          @ColumnInfo(name = "origin") var origin: String
){
    constructor(): this(null,"", 0,"")
}