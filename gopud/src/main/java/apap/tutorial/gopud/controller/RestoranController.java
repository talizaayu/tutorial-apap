package apap.tutorial.gopud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.RestoranService;

@Controller
public class RestoranController {
    @Autowired
    private RestoranService restoranService;

    @RequestMapping("/restoran/add")
    public String add(
        @RequestParam(value = "idRestoran", required = true) String idRestoran,
        @RequestParam(value = "nama", required = true) String nama,
        @RequestParam(value = "alamat", required = true) String alamat,
        @RequestParam(value = "nomorTelepon", required = true) Integer nomorTelepon,
        Model model
    ) {
        RestoranModel restoran = new RestoranModel(idRestoran, nama, alamat, nomorTelepon);

        restoranService.addRestoran(restoran);

        model.addAttribute("namaResto", nama);

        return "add-restoran";
    }

    @RequestMapping("/restoran/view")
    public String view(
        // Request Parameter untuk dipass
        @RequestParam(value = "idRestoran") String idRestoran, Model model 
        ) {
        
        // Mengambil objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);

        if (restoran == null) {
            return "not-found-restoran";
        }

        model.addAttribute("resto", restoran);

        // Return view template
        return "view-restoran";
    }

    // URL mapping viewAll
    @RequestMapping("/restoran/viewall")
    public String viewall(Model model) {
        
        // Mengambil semua objek RestoranModel yang ada
        List<RestoranModel> listRestoran = restoranService.getRestoranList();

        // Add model restoran ke "resto" untuk dirender
        model.addAttribute("restoList", listRestoran);

        // Return view template
        return "viewall-restoran"; 
    }

    @GetMapping("/restoran/view/id-restoran/{idRestoran}")
    public String viewPath(
        // Request Parameter untuk dipass
        @PathVariable(value = "idRestoran") String idRestoran, Model model 
        ) {
        
        // Mengambil objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);

        if (restoran == null) {
            return "not-found-restoran";
        }

        model.addAttribute("resto", restoran);

        // Return view template
        return "view-restoran";
    }

    @GetMapping("/restoran/update/id-restoran/{idRestoran}/nomor-telepon/{nomorTelepon}")
    public String update(
        // Request Parameter untuk dipass
        @PathVariable(value = "idRestoran", required = true) String idRestoran, 
        @PathVariable(value = "nomorTelepon", required = true) Integer nomorTelepon, Model model 
        ) {
        
        // Mengambil objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);

        if (restoran == null) {
            return "not-found-restoran";
        }
        restoran.setNomorTelepon(nomorTelepon);
        model.addAttribute("namaResto", restoran.getNama());

        // Return view template
        return "update-restoran";
    }

    @GetMapping("/restoran/delete/id/{idRestoran}")
    public String delete(
        // Request Parameter untuk dipass
        @PathVariable(value = "idRestoran", required = true) String idRestoran, Model model 
        ) {
        
        // Mengambil objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);

        // Add model restoran ke "resto" untuk dirender
        if (restoran == null) {
            return "not-found-restoran";
        }
        model.addAttribute("namaResto", restoran.getNama());
        restoranService.deleteRestoran(restoran);

        // Return view template
        return "delete-restoran";
    }
}