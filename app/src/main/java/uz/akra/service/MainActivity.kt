package uz.akra.service

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import uz.akra.service.adapters.MyRvAdapter
import uz.akra.service.databinding.ActivityMainBinding
import uz.akra.service.db.AppDatabase
import uz.akra.service.models.MyWorkerModel
import uz.akra.service.service.MyWorkService
import java.text.SimpleDateFormat
import java.util.Date
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var myRvAdapter: MyRvAdapter
    lateinit var appDatabase: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        appDatabase = AppDatabase.getInstanse(this)


        binding.btn1.setOnClickListener {
            //minutiga 1 marta deb shart berilgan taqdirda ham
            // Servicelar tizim optimatsiyasini hisobga olib
            // minimal 15 minutta 1 marotaba ishlaydi

            val workRequest2 =
                PeriodicWorkRequestBuilder<MyWorkService>(1, TimeUnit.MINUTES).build()
            WorkManager.getInstance(this).enqueue(workRequest2)


        }

    }

    override fun onResume() {
        super.onResume()
        val list = appDatabase.myDao().getAllDates() as ArrayList
        myRvAdapter = MyRvAdapter(list)
        binding.recView.adapter = myRvAdapter

    }
}