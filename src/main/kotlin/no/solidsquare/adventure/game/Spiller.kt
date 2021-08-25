package no.solidsquare.adventure.game

data class Spiller (
        val kart: Kart,
        var rom: Rom,
        var advarsel: String? = "",
        var sekk: List<String>? = emptyList(),
)