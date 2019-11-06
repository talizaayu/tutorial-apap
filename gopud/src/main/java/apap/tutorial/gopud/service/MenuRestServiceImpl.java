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

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.repository.MenuDB;
import apap.tutorial.gopud.repository.RestoranDB;
// import apap.tutorial.gopud.rest.RestoranDetail;
import apap.tutorial.gopud.rest.Setting;

@Service
@Transactional
public class MenuRestServiceImpl implements MenuRestService {
    // private final WebClient webClient;

    @Autowired
    private MenuDB menuDB;

    @Override
    public MenuModel createMenu(MenuModel menu) {
        return menuDB.save(menu);
    }

    @Override
    public List<MenuModel> retrieveListMenu(){
        return menuDB.findAll();
    }

    @Override
    public MenuModel getMenuByIdMenu(Long id) {
        Optional<MenuModel> menu = menuDB.findById(id);
        if(menu.isPresent()){
            return menu.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public MenuModel changeMenu(Long id, MenuModel menuUpdate) {
        MenuModel menu = getMenuByIdMenu(id);
        menu.setNama(menuUpdate.getNama());
        menu.setDeskripsi(menuUpdate.getDeskripsi());
        menu.setDurasiMasak(menuUpdate.getDurasiMasak());
        menu.setHarga(menuUpdate.getHarga());
        return menuDB.save(menu);
    }

    @Override
    public void deleteMenu(Long id) {
        MenuModel menu = getMenuByIdMenu(id);
        menuDB.delete(menu);
    }

    //Consumer Service
    // public RestoranRestServiceImpl(WebClient.Builder webClientBuilder) {
    //     this.webClient = webClientBuilder.baseUrl(Setting.restoranUrl).build();
    // }

    // @Override
    // public Mono<String> getStatus(Long idRestoran) {
    //     return this.webClient.get().uri("/rest/restoran/"+idRestoran+"/status/").retrieve().bodyToMono(String.class);
    // }

    // @Override
    // public Mono<RestoranDetail> postStatus() {
    //     MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
    //     data.add("alamat", "Jalan Akses UI No 2");
    //     data.add("nomorTelepon", "028102810");
    //     return this.webClient.post().uri("/rest/restoran/full").syncBody(data).retrieve().bodyToMono(RestoranDetail.class);
    // }
}

