package apap.tutorial.gopud.service;

import reactor.core.publisher.Mono;

public interface RecipeRestService {
    Mono<String> postStatus(String namaBahan);
    Mono<String> getChef(String chefName);
}