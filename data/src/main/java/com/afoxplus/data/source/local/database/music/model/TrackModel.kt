package com.afoxplus.data.source.local.database.music.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.afoxplus.domain.entities.music.Track
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "tracks")
data class TrackModel(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("wrapperType") val wrapperType: String,
    @SerializedName("kind") val kind: String,
    @SerializedName("censoredName") val censoredName: String,
    @SerializedName("viewUrl") val viewUrl: String,
    @SerializedName("artworkUrl30") val artworkUrl30: String,
    @SerializedName("artworkUrl60") val artworkUrl60: String,
    @SerializedName("artworkUrl100") val artworkUrl100: String,
    @SerializedName("price") val price: Double,
    //@SerializedName("releaseDate") val releaseDate: Date,
    @SerializedName("count") val count: Int,
    @SerializedName("number") val number: Int,
    @SerializedName("timeMillis") val timeMillis: Int,
    @SerializedName("primaryGenreName") val primaryGenreName: String,
    var indexInResponse: Int = -1
) {
    fun toTrack(): Track = Track(
        id = id,
        name = name,
        wrapperType = wrapperType,
        kind = kind,
        censoredName = censoredName,
        viewUrl = viewUrl,
        artworkUrl30 = artworkUrl30,
        artworkUrl60 = artworkUrl60,
        artworkUrl100 = artworkUrl100,
        price = price,
        releaseDate = Calendar.getInstance().time,
        count = count,
        number = number,
        timeMillis = timeMillis,
        primaryGenreName = primaryGenreName
    )

    companion object {
        private fun toTrackModel(track: Track): TrackModel = TrackModel(
            id = track.id,
            name = track.name,
            wrapperType = track.wrapperType,
            kind = track.kind,
            censoredName = track.censoredName,
            viewUrl = track.viewUrl,
            artworkUrl30 = track.artworkUrl30,
            artworkUrl60 = track.artworkUrl60,
            artworkUrl100 = track.artworkUrl100,
            price = track.price,
            //releaseDate = Calendar.getInstance().time,
            count = track.count,
            number = track.number,
            timeMillis = track.timeMillis,
            primaryGenreName = track.primaryGenreName
        )

        fun toTrackList(tracks: List<TrackModel>) = tracks.map { item -> item.toTrack() }
        fun toTrackModelList(tracks: List<Track>) = tracks.map { item -> toTrackModel(item) }
    }
}
