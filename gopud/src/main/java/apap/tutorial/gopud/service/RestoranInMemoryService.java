package apap.tutorial.gopud.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.RestoranService;
import org.springframework.stereotype.Service;



@Service 
public class RestoranInMemoryService implements RestoranService {
    private List<RestoranModel> listRestoran;

    public RestoranInMemoryService() {
        listRestoran = new ArrayList<>();
    }

    @Override
    public void addRestoran(RestoranModel restoran) {
        listRestoran.add(restoran);
    }

    @Override
    public List<RestoranModel> getRestoranList() {
        return listRestoran;
    }

//    @Override
//    public RestoranModel getRestoranByIdRestoran(String idRestoran) {
//        for (int i = 0; i < listRestoran.size(); i++) {
//            if (idRestoran.equals(listRestoran.get(i).getIdRestoran())) {
//                return listRestoran.get(i);
//            }
//        }
//        return null;
//    }

    @Override
    public void deleteRestoran(RestoranModel restoran) {
        listRestoran.remove(restoran);
    }

    @Override
    public RestoranModel changeRestoran(RestoranModel restoranModel) {
        return null;
    }

    @Override
    public Optional<RestoranModel> getRestoranByIdRestoran(Long idRestoran) {
        return null;
    }
}