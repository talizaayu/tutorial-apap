package apap.tutorial.gopud.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.repository.RestoranDB;
import apap.tutorial.gopud.rest.RestoranDetail;
import apap.tutorial.gopud.rest.Setting;

@Service
@Transactional
public class RecipeRestServiceImpl implements RecipeRestService {
    private final WebClient webClient;
    private final static String apiKey = "0887aa2dc3e54f5c9a54cbeda842e651";

    public RecipeRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.recipeUrl).build();
    }

    @Override
    public Mono<String> postStatus(String namaBahan) {
        MultiValueMap<String, String> data = new LinkedMultiValueMap<String, String>();
        data.add("excludeIngredients", namaBahan);
        data.add("cuisine", "german");
        data.add("apiKey", apiKey);
        return this.webClient.get().uri(uriBuilder -> uriBuilder.path("/recipes/search").queryParams(data).build()).retrieve().bodyToMono(String.class);
    }
}

