package no.solidsquare.adventure.game

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.Exception

@RestController
class GameController(private val service: GameService) {

    @GetMapping("/")
    fun start(): Rom {
        return service.map[0]
    }

    @GetMapping("/{svar}")
    fun getSvar(@PathVariable svar: Svar): Rom {
        if (!service.tillattTrekk(svar))
            throw Exception("feil trekk")

        return service.getPosisjon()
    }

    @PostMapping("/lagre")
    fun lagre(spiller: Spiller): Boolean = true


    @GetMapping("/gjenopprett")
    fun gjennopprett(id: String): Spiller {
        return service.gjennopprett()
    }
}