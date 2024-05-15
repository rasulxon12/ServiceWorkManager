package uz.akra.service.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.akra.service.models.MyWorkerModel

@Database(entities = [MyWorkerModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun myDao(): MyDAO

    companion object {
        private var instanse: AppDatabase? = null

        @Synchronized
        fun getInstanse(context: Context): AppDatabase {

            if (instanse == null) {
                instanse = Room.databaseBuilder(context, AppDatabase::class.java, "my_room_db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }


            return this.instanse!!
        }
    }
}