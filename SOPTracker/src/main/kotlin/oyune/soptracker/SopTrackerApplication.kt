package oyune.soptracker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SopTrackerApplication

fun main(args: Array<String>) {
    runApplication<SopTrackerApplication>(*args)
}
