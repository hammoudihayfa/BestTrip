package tn.esprit.besttripback.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/routes")
public class RouteController {
    @GetMapping
    public ResponseEntity<List<String>> getRoutes() {
        List<String> routes = Arrays.asList("Berlin-Londres", "New York-Paris", "Madrid-Rome");

        return new ResponseEntity<>(routes, HttpStatus.OK);
    }
    @GetMapping("/departure-routes")
    public ResponseEntity<List<String>> getDepartureRoutes(@RequestParam String city) {
        if (city == null || city.trim().isEmpty()) {
            return new ResponseEntity<>(Arrays.asList("Erreur: La ville ne peut pas être vide."), HttpStatus.BAD_REQUEST);
        }
        List<String> routes;
        switch (city.toLowerCase()) {
            case "berlin":
                routes = Arrays.asList("Berlin-Londres", "Berlin-Paris");
                break;
            case "new york":
                routes = Arrays.asList("New York-Paris", "New York-Londres");
                break;
            case "madrid":
                routes = Arrays.asList("Madrid-Rome", "Madrid-Barcelone");
                break;
            default:
                routes = Arrays.asList("Aucune route disponible pour cette ville.");
                break;
        }

        return new ResponseEntity<>(routes, HttpStatus.OK);
    }
    @GetMapping("/arrival-routes")
    public ResponseEntity<List<String>> getArrivalRoutes(@RequestParam String city) {
        if (city == null || city.trim().isEmpty()) {
            return new ResponseEntity<>(Arrays.asList("Erreur: La ville ne peut pas être vide."), HttpStatus.BAD_REQUEST);
        }
        List<String> routes;
        switch (city.toLowerCase()) {
            case "londres":
                routes = Arrays.asList("Paris-Londres", "Berlin-Londres");
                break;
            case "new york":
                routes = Arrays.asList("New York-Paris", "New York-Londres");
                break;
            // Ajoutez d'autres cas selon vos besoins
            default:
                routes = Arrays.asList("Aucune route disponible pour cette ville.");
                break;
        }

        return new ResponseEntity<>(routes, HttpStatus.OK);
    }


}
