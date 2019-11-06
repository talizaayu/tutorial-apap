package apap.tutorial.gopud.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.gopud.model.UserModel;
import apap.tutorial.gopud.service.UserRoleService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUserSubmit(@ModelAttribute UserModel user) {
        userRoleService.addUser(user);
        return "home";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.GET)
    private String updatePasswordForm(@ModelAttribute UserModel user) {
        return "form-update-password";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    private String updatePasswordSubmit(Locale locale, @RequestParam("password") String password, @RequestParam("oldPassword") String oldPassword, @RequestParam("konfirmasiPassword") String konfirmasiPassword, Model model) {
       UserModel user = userRoleService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
       boolean isSame = userRoleService.validate(user.getPassword(), oldPassword);
       if(isSame) {
           if(konfirmasiPassword.equals(password)) {
               userRoleService.updatePassword(user, password, oldPassword);
               return "update-password";
           } else {
               model.addAttribute("alert", "New password is valid");
               return "form-update-password";
           }
       }
       return "home";
    }
}