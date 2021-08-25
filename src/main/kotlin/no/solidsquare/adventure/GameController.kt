package no.solidsquare.adventure

import no.solidsquare.adventure.game.Spiller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GameController(private val service: GameService) {

    @GetMapping("/start")
    fun start(): Spiller = service.getSpiller()

    @GetMapping("svar/{svar}")
    fun getSvar(@PathVariable svar: String): Spiller {
        if (!service.tillattTrekk(svar))
            return service.getSpiller().copy(advarsel = "Ikke tillatt trekk")

        return service.getSpiller()
    }

    @PostMapping("/lagre")
    fun lagre(spiller: Spiller): Boolean = true


    @GetMapping("/gjenopprett/{id}")
    fun gjennopprett(@PathVariable id: String): Spiller {
        return service.gjennopprett(id)
    }
}