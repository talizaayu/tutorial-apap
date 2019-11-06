package apap.tutorial.gopud.restcontroller;

import apap.tutorial.gopud.service.RecipeRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/recipe")
public class RecipeRestController {
    @Autowired
    private RecipeRestService recipeRestService;

    @GetMapping(value="/excludeIngredient={namaBahan}")
    private Mono<String> postStatus(@PathVariable String namaBahan) {
        return recipeRestService.postStatus(namaBahan);
    }
}
