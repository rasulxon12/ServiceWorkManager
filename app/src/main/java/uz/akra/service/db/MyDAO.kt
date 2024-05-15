package uz.akra.service.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.akra.service.models.MyWorkerModel

@Dao
interface MyDAO {

  @Insert
  fun addDate(myWorkerModel: MyWorkerModel)

  @Query("select * from MyWorkerModel")
  fun getAllDates():List<MyWorkerModel>

}