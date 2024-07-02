package com.pavel.m_banking.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.pavel.m_banking.db.AccountDao
import com.pavel.m_banking.db.AccountEntity
import com.pavel.m_banking.db.AppDataBase
import com.pavel.m_banking.db.InfoTransactionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDB(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, "dataBase")
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    CoroutineScope(Dispatchers.IO).launch {
                        provideDB(context).getAccountDao().addItem(
                            AccountEntity(
                                id = 0,
                                accountNumber = "123456789",
                                accountName = "My first account",
                                cardNumber = "**** 12345"
                            )
                        )
                        provideDB(context).getAccountDao().addItem(
                            AccountEntity(
                                id = 0,
                                accountNumber = "987654321",
                                accountName = "For traveling",
                                cardNumber = "**** 56789"
                            )
                        )
                        provideDB(context).getAccountDao().addItem(
                            AccountEntity(
                                id = 0,
                                accountNumber = "741852963",
                                accountName = "Saving account",
                                cardNumber = "**** 65489"
                            )
                        )
                    }
                }
            })
            .build()
    }

    @Singleton
    @Provides
    fun provideCityDao(appDataBase: AppDataBase): AccountDao {
        return appDataBase.getAccountDao()
    }


    @Singleton
    @Provides
    fun provideInfoTransactionDao(appDataBase: AppDataBase): InfoTransactionDao {
        return appDataBase.getInfoTransactionDao()
    }
}