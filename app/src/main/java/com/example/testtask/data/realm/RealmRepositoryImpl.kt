package com.example.testtask.data.realm


import com.example.testtask.domain.realm.Data
import com.example.testtask.domain.realm.RealmRepository
import io.realm.Realm
import io.realm.RealmResults
import java.util.UUID

class RealmRepositoryImpl(private val realm: Realm) : RealmRepository {

    override fun saveUser(name: String, favorite: Boolean) {
        realm.executeTransaction { realm ->
            val user = realm.createObject(Data::class.java, UUID.randomUUID().toString())
            user.name = name
            user.favorite = favorite
        }
    }

    override fun getUser(_id: String): Data? {
        return realm.where(Data::class.java).equalTo("_id", _id).findFirst()
    }

    override fun getAllUsers(): List<Data> {
        val results: RealmResults<Data> = realm.where(Data::class.java).findAll()
        return realm.copyFromRealm(results)
    }

    override fun deleteUser(_id: String) {
        realm.executeTransaction { realm ->
            val user = realm.where(Data::class.java).equalTo("_id", _id).findFirst()
            user?.deleteFromRealm()
        }
    }
}
