package apap.tutorial.gopud.service;

import java.util.List;

import apap.tutorial.gopud.model.RestoranModel;

public interface RestoranRestService {
    RestoranModel createRestoran(RestoranModel restoran);
    List<RestoranModel> retrieveListRestoran();
    RestoranModel getRestoranByIdRestoran(Long idRestoran);
    RestoranModel changeRestoran(Long idRestoran, RestoranModel restoranUpdate);
    void deleteRestoran(Long idRestoran);
}