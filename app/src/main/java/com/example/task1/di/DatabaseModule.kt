package com.example.task1.di

import com.example.task1.data.MongoRepository
import com.example.task1.data.MongoRepositoryImpl
import com.example.task1.model.Address
//import com.example1.task1.model.Address
import com.example.task1.model.Person
import com.example.task1.model.Pet
//import com.example.task1.model.Pet
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import javax.inject.Singleton
import kotlin.text.Typography.dagger

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideRealm(): Realm {
        val config = RealmConfiguration.Builder(
            schema = setOf(
                Person::class, Address::class, Pet::class
            )
        )
            .compactOnLaunch()
//            .initialData()
            .build()
        return Realm.open(config)
    }

    @Singleton
    @Provides
    fun provideMongoRepository(realm: Realm): MongoRepository {
        return MongoRepositoryImpl(realm = realm)
    }

}