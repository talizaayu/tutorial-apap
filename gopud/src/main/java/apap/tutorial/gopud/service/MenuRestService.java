package apap.tutorial.gopud.service;

import java.util.List;

import apap.tutorial.gopud.model.MenuModel;
// import apap.tutorial.gopud.rest.MenuDetail;
import reactor.core.publisher.Mono;

public interface MenuRestService {
    MenuModel createMenu(MenuModel menu);
    List<MenuModel> retrieveListMenu();
    MenuModel getMenuByIdMenu(Long id);
    MenuModel changeMenu(Long id, MenuModel menuUpdate);
    void deleteMenu(Long id);
    // Mono<String> getStatus(Long idRestoran);
    // Mono<RestoranDetail> postStatus();
}