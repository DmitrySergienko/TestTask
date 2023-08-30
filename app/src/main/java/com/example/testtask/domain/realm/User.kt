package com.example.testtask.domain.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.UUID

open class Data : RealmObject() {
    @PrimaryKey
    var _id: String = UUID.randomUUID().toString()
    var name: String = ""
    var favorite: Boolean = false
}