package com.example.examplereminderlevel4

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "reminderTable")
data class Reminder(
    @ColumnInfo(name = "reminder")
    val reminderText: String,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")  // Optional as Room can derive it from variable 'id'
    var id: Long? = null
) : Parcelable
