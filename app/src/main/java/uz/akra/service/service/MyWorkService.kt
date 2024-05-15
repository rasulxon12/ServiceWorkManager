package uz.akra.service.service

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters
import uz.akra.service.db.AppDatabase
import uz.akra.service.models.MyWorkerModel
import java.text.SimpleDateFormat
import java.util.Date
import kotlin.math.log

private const val TAG = "MyWorkService"

class MyWorkService(var context:Context, workParams:WorkerParameters):Worker(context, workParams) {
    lateinit var appDatabase:AppDatabase
    override fun doWork(): Result {
        Log.d(TAG, "doWork: MyWorkService ishladi")
//        Toast.makeText(context, "MyWorkService ishladi", Toast.LENGTH_SHORT).show()

        appDatabase = AppDatabase.getInstanse(context)
        val myDate = MyWorkerModel(
            SimpleDateFormat("(yyyy/MM/dd)HH:mm:ss").format(Date())
        )
        appDatabase.myDao().addDate(myDate)
        Log.d(TAG, "doWork: Databasega qo'shildi")


        return Result.success()
    }



}