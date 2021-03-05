package no.solidsquare.adventure.game

data class Rom(
        val opp: Int,
        val hoyre: Int,
        val ned: Int,
        val venstre: Int,
        override val navn: String,
        override val beskrivelse: String
) : GameObject(navn, beskrivelse)