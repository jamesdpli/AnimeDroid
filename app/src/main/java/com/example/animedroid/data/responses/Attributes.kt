package com.example.animedroid.data.responses

data class Attributes(
    val abbreviatedTitles: List<String>,
    val ageRating: String,
    val ageRatingGuide: String,
    val averageRating: String,
    val canonicalTitle: String,
    val coverImage: CoverImage,
    val coverImageTopOffset: Int,
    val createdAt: String,
    val description: String,
    val endDate: String,
    val episodeCount: Int,
    val episodeLength: Int,
    val favoritesCount: Int,
    val nextRelease: Any,
    val nsfw: Boolean,
    val popularityRank: Int,
    val posterImage: PosterImage,
    val ratingFrequencies: RatingFrequencies,
    val ratingRank: Int,
    val showType: String,
    val slug: String,
    val startDate: String,
    val status: String,
    val subtype: String,
    val synopsis: String,
    val tba: String,
    val titles: Titles,
    val totalLength: Int,
    val updatedAt: String,
    val userCount: Int,
    val youtubeVideoId: String
)
