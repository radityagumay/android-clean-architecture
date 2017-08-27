package net.radityalabs.alquran.domain.model

import android.os.Parcel
import android.os.Parcelable

data class Surah(
        val number: Int,
        val name: String,
        val englishName: String,
        val numberOfAyahs: Int,
        val englishNameTranslation: String,
        val revelationType: String
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readInt(),
            source.readString(),
            source.readString(),
            source.readInt(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(number)
        writeString(name)
        writeString(englishName)
        writeInt(numberOfAyahs)
        writeString(englishNameTranslation)
        writeString(revelationType)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Surah> = object : Parcelable.Creator<Surah> {
            override fun createFromParcel(source: Parcel): Surah = Surah(source)
            override fun newArray(size: Int): Array<Surah?> = arrayOfNulls(size)
        }
    }
}