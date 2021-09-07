package com.example.cleanarchcryptocurrencies.data.remote.dto

import com.example.cleanarchcryptocurrencies.domain.model.CoinDetail
import com.google.gson.annotations.SerializedName

data class CointDetailDto(
    @SerializedName("description")
    val description: String = "",
    @SerializedName("development_status")
    val developmentStatus: String? = null,
    @SerializedName("first_data_at")
    val firstDataAt: String? = null,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean? = null,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean? = null,
    @SerializedName("last_data_at")
    val lastDataAt: String? = null,
    @SerializedName("links")
    val links: Links? = null,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended?>? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("open_source")
    val openSource: Boolean? = null,
    @SerializedName("org_structure")
    val orgStructure: String? = null,
    @SerializedName("proof_type")
    val proofType: String? = null,
    @SerializedName("rank")
    val rank: Int? = null,
    @SerializedName("started_at")
    val startedAt: String? = null,
    @SerializedName("symbol")
    val symbol: String? = null,
    @SerializedName("tags")
    val tags: List<Tag>,
    @SerializedName("team")
    val team: List<TeamMember>,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("whitepaper")
    val whitepaper: Whitepaper? = null
)

fun CointDetailDto.toCoinDetail(): CoinDetail =
    CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )

data class Links(
    @SerializedName("explorer")
    val explorer: List<String?>? = null,
    @SerializedName("facebook")
    val facebook: List<String?>? = null,
    @SerializedName("reddit")
    val reddit: List<String?>? = null,
    @SerializedName("source_code")
    val sourceCode: List<String?>? = null,
    @SerializedName("website")
    val website: List<String?>? = null,
    @SerializedName("youtube")
    val youtube: List<String?>? = null
)


data class LinksExtended(
    @SerializedName("stats")
    val stats: Stats? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("url")
    val url: String? = null
) {

    data class Stats(
        @SerializedName("contributors")
        val contributors: Int? = null,
        @SerializedName("followers")
        val followers: Int? = null,
        @SerializedName("stars")
        val stars: Int? = null,
        @SerializedName("subscribers")
        val subscribers: Int? = null
    )
}


data class Tag(
    @SerializedName("coin_counter")
    val coinCounter: Int? = null,
    @SerializedName("ico_counter")
    val icoCounter: Int? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String
)


data class TeamMember(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("position")
    val position: String = ""
)


data class Whitepaper(
    @SerializedName("link")
    val link: String? = null,
    @SerializedName("thumbnail")
    val thumbnail: String? = null
)