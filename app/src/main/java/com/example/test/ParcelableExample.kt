package com.example.test

import android.os.Parcel
import android.os.Parcelable
import kotlin.properties.Delegates

class ParcelableExample() : Parcelable {

    var id : Int = 0
    lateinit var name : String
    var age by Delegates.notNull<Int>()


    constructor(parcel: Parcel) : this() {
        this.id = parcel.readInt()
        this.name = parcel.readString().toString()
        this.age  = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ParcelableExample> {
        override fun createFromParcel(parcel: Parcel): ParcelableExample {
            return ParcelableExample(parcel)
        }

        override fun newArray(size: Int): Array<ParcelableExample?> {
            return arrayOfNulls(size)
        }
    }
}