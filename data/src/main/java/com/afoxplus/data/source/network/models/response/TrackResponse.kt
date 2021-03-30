package com.afoxplus.data.source.network.models.response

import com.afoxplus.domain.entities.music.Artist
import com.afoxplus.domain.entities.music.Collection
import com.afoxplus.domain.entities.music.Track
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*

data class TrackResponse(
    @SerializedName("artistId") val artistId: Int? = null,
    @SerializedName("artistName") val artistName: String? = null,
    @SerializedName("artistViewUrl") val artistViewUrl: String? = null,
    @SerializedName("artworkUrl100") val artworkUrl100: String? = null,
    @SerializedName("artworkUrl30") val artworkUrl30: String? = null,
    @SerializedName("artworkUrl60") val artworkUrl60: String? = null,
    @SerializedName("collectionCensoredName") val collectionCensoredName: String? = null,
    @SerializedName("collectionExplicitness") val collectionExplicitness: String? = null,
    @SerializedName("collectionId") val collectionId: Int? = null,
    @SerializedName("collectionName") val collectionName: String? = null,
    @SerializedName("collectionPrice") val collectionPrice: Double? = null,
    @SerializedName("collectionViewUrl") val collectionViewUrl: String? = null,
    @SerializedName("contentAdvisoryRating") val contentAdvisoryRating: String? = null,
    @SerializedName("country") val country: String? = null,
    @SerializedName("currency") val currency: String? = null,
    @SerializedName("discCount") val discCount: Int? = null,
    @SerializedName("discNumber") val discNumber: Int? = null,
    @SerializedName("kind") val kind: String? = null,
    @SerializedName("previewUrl") val previewUrl: String? = null,
    @SerializedName("primaryGenreName") val primaryGenreName: String? = null,
    @SerializedName("releaseDate") val releaseDate: String? = null,
    @SerializedName("trackCensoredName") val trackCensoredName: String? = null,
    @SerializedName("trackCount") val trackCount: Int? = null,
    @SerializedName("trackExplicitness") val trackExplicitness: String? = null,
    @SerializedName("trackId") val trackId: Int? = null,
    @SerializedName("trackName") val trackName: String? = null,
    @SerializedName("trackNumber") val trackNumber: Int? = null,
    @SerializedName("trackPrice") val trackPrice: Double? = null,
    @SerializedName("trackTimeMillis") val trackTimeMillis: Int? = null,
    @SerializedName("trackViewUrl") val trackViewUrl: String? = null,
    @SerializedName("wrapperType") val wrapperType: String? = null
) {
    private val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    private fun toArtist(): Artist = Artist(
        id = artistId ?: 0,
        name = artistName ?: "",
        viewUrl = artistViewUrl ?: ""
    )

    private fun toCollection(): Collection = Collection(
        id = collectionId ?: 0,
        name = collectionName ?: "",
        censoredName = collectionCensoredName ?: "",
        viewUrl = collectionViewUrl ?: "",
        price = collectionPrice ?: 0.0,
        explicitness = collectionExplicitness ?: "",
        artist = toArtist()
    )

    fun toTrack(): Track = Track(
        id = trackId ?: 0,
        name = trackName ?: "",
        wrapperType = wrapperType ?: "",
        kind = kind ?: "",
        censoredName = trackCensoredName ?: "",
        viewUrl = trackViewUrl ?: "",
        artworkUrl30 = artworkUrl30 ?: "",
        artworkUrl60 = artworkUrl60 ?: "",
        artworkUrl100 = artworkUrl100 ?: "",
        price = trackPrice ?: 0.0,
        releaseDate = releaseDate?.let { date -> format.parse(date) }
            ?: Calendar.getInstance().time,
        count = trackCount ?: 0,
        number = trackNumber ?: 0,
        timeMillis = trackTimeMillis ?: 0,
        primaryGenreName = primaryGenreName ?: "",
        artist = toArtist(),
        collection = toCollection()
    )

    companion object {
        fun toTrackList(response: List<TrackResponse>): List<Track> =
            response.map { item -> item.toTrack() }
    }

}