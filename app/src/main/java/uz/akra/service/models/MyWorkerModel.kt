package uz.akra.service.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat

@Entity
class MyWorkerModel {

    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
    var date:String? = null

    constructor(date: String) {
        this.date = date
    }

    override fun toString(): String {
        return "MyWorkerModel(id=$id, date='$date')"
    }
}