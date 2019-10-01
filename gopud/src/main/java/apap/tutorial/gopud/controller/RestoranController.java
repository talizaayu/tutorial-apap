package apap.tutorial.gopud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.MenuService;
import apap.tutorial.gopud.service.RestoranService;
import apap.tutorial.gopud.model.MenuModel;

@Controller
public class RestoranController {
    @Qualifier("restoranServiceImpl")
    @Autowired
    private RestoranService restoranService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/restoran/add", method = RequestMethod.GET)
    public String addRestoranFormPage(Model model) {
        RestoranModel newRestoran = new RestoranModel();
        model.addAttribute("restoran", newRestoran);
        return "form-add-restoran";
    }

    @RequestMapping(value = "/restoran/add", method = RequestMethod.POST)
    public String addRestoranSubmit(@ModelAttribute RestoranModel restoran, Model model) {
        restoranService.addRestoran(restoran);
        model.addAttribute("namaResto", restoran.getNama());
        return "add-restoran";
    }


    @RequestMapping(path = "/restoran/view", method = RequestMethod.GET)
    public String view(
        // Request Parameter untuk dipass
        @RequestParam(value = "idRestoran") Long idRestoran, Model model 
        ) {
        
        // Mengambil objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();

        model.addAttribute("resto", restoran);

        List<MenuModel> menuList = menuService.findAllMenuByIdRestoran(restoran.getIdRestoran());
        model.addAttribute("menuList", menuList);

        return "view-restoran";
    }

    @RequestMapping(value="restoran/change/{idRestoran}", method = RequestMethod.GET)
    public String changeRestoranFormPage(@PathVariable Long idRestoran, Model model) {
        RestoranModel existingRestoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        model.addAttribute("restoran", existingRestoran);
        return "form-change-restoran";
    }

    @RequestMapping(value="restoran/change/{idRestoran}", method = RequestMethod.POST)
    public String changeRestoranFormSubmit(@PathVariable Long idRestoran, @ModelAttribute RestoranModel restoran, Model model) {
        RestoranModel newRestoranData = restoranService.changeRestoran(restoran);
        model.addAttribute("restoran", newRestoranData);
        return "change-restoran";
    }

    // URL mapping viewAll
    @RequestMapping("/restoran/view-all")
    public String viewall(Model model) {
        
        // Mengambil semua objek RestoranModel yang ada
        List<RestoranModel> listRestoran = restoranService.getRestoranList();

        // Add model restoran ke "resto" untuk dirender
        model.addAttribute("restoList", listRestoran);

        // Return view template
        return "viewall-restoran"; 
    }

    // @GetMapping("/restoran/view/id-restoran/{idRestoran}")
    // public String viewPath(
    //     // Request Parameter untuk dipass
    //     @PathVariable(value = "idRestoran") String idRestoran, Model model 
    //     ) {
        
    //     // Mengambil objek RestoranModel yang dituju
    //     RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);

    //     if (restoran == null) {
    //         return "error";
    //     }

    //     model.addAttribute("resto", restoran);

    //     // Return view template
    //     return "view-restoran";
    // }

    // @GetMapping("/restoran/update/id-restoran/{idRestoran}/nomor-telepon/{nomorTelepon}")
    // public String update(
    //     // Request Parameter untuk dipass
    //     @PathVariable(value = "idRestoran", required = true) String idRestoran, 
    //     @PathVariable(value = "nomorTelepon", required = true) Integer nomorTelepon, Model model 
    //     ) {
        
    //     // Mengambil objek RestoranModel yang dituju
    //     RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);

    //     if (restoran == null) {
    //         return "error";
    //     }
    //     restoran.setNomorTelepon(nomorTelepon);
    //     model.addAttribute("namaResto", restoran.getNama());

    //     // Return view template
    //     return "update-restoran";
    // }

    @RequestMapping(path="/restoran/delete/{idRestoran}")
    public String delete(
        // Request Parameter untuk dipass
        @PathVariable(value = "idRestoran", required = true) Long idRestoran, Model model 
        ) {
        // Mengambil objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        // model.addAttribute("resto", restoran);
        List<MenuModel> menuList = menuService.findAllMenuByIdRestoran(restoran.getIdRestoran());
        model.addAttribute("namaResto", restoran.getNama());
        if(menuList.isEmpty()){
            return "error";
        }
        else {
            restoranService.deleteRestoran(restoran);
            return "delete-restoran";
        }
    }
}