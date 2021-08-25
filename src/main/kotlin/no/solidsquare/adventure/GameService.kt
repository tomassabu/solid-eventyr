package no.solidsquare.adventure

import no.solidsquare.adventure.game.Kart
import no.solidsquare.adventure.game.Rom
import no.solidsquare.adventure.game.Spiller
import org.springframework.stereotype.Service

@Service
class GameService {

    final val map = Kart(listOf(Rom(-1, 1, 2, -1,"Start", "her starter du"),
            Rom(-1, -1, -1, 0,"hule", "Nå er du i hulen"),
            Rom(0, 3, -1, -1,"skog", "Nå er du i skogen"),
            Rom(-1, -1, -1, 2,"fjell", "Nå er du på fjellet")))

    val bevegelser = listOf("opp", "ned", "venstre", "høyre")

    var spillerObjekt = Spiller(map, map.rom[0], "", emptyList())

    fun getSpiller(): Spiller {
        return spillerObjekt
    }

    fun tillattTrekk(svar: String): Boolean {
        if (bevegelser.contains(svar)) {
            spillerObjekt.advarsel = ""
            beveg(svar)
            return true
        }
        spillerObjekt.advarsel = "ikke tillatt trekk"
        return false
    }

    fun beveg(svar: String) {
        when(svar) {
            "opp" -> kanBevege(spillerObjekt.rom.opp) //if (romPosisjon.opp >= 0) romPosisjon = map[romPosisjon.opp]
            "venstre" -> kanBevege(spillerObjekt.rom.venstre)// if (romPosisjon.venstre >= 0) romPosisjon = map[romPosisjon.venstre]
            "ned" -> kanBevege(spillerObjekt.rom.ned)//if (romPosisjon.ned >= 0) romPosisjon = map[romPosisjon.ned]
            "høyre" -> kanBevege(spillerObjekt.rom.hoyre)//if (romPosisjon.hoyre >= 0) romPosisjon = map[romPosisjon.hoyre]
        }
    }

    fun kanBevege(pos: Int) {
        if (pos < 0) return //TODO denne skal også si " ikke tillatt trekk
        spillerObjekt.rom = map.rom[pos]
    }

    fun gjennopprett(id: String): Spiller {
        return Spiller(map, spillerObjekt.rom)
    }
}