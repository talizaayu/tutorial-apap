package apap.tutorial.gopud.controller;

import java.util.Locale;
import java.util.regex.Pattern;

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
import apap.tutorial.gopud.repository.UserRoleDb;
import apap.tutorial.gopud.service.UserRoleService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserRoleDb userRoleDb;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUserSubmit(Locale locale, @RequestParam("password") String password, @RequestParam("confirmedPassword") String confirmPassword, @ModelAttribute UserModel user, Model model) {
        String messages = "";
        if(confirmPassword.equals(password)) {
            if (validatePassword(user.getPassword()) && checkUsername(user.getUsername()) ) {
                userRoleService.addUser(user);
                messages = "User added successfully";
                model.addAttribute("message", messages);
                return "add-user";
            }
        }
        messages = "Password invalid. Must contain at least one number and at least 10 or more characters";
        model.addAttribute("message", messages);
        return "invalid-password";
    }


    @RequestMapping(value = "/updatePassword", method = RequestMethod.GET)
    private String updatePasswordForm(@ModelAttribute UserModel user) {
        return "form-update-password";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    private String updatePasswordSubmit(Locale locale,
                                        @RequestParam("newPassword") String password,
                                        @RequestParam("oldPassword") String oldPassword,
                                        @RequestParam("confirmedPassword") String confirmPassword, Model model){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        UserModel user = userRoleService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        boolean isSame = userRoleService.validate(user.getPassword(), oldPassword);
        if(isSame){
            if(confirmPassword.equals(password)){
                userRoleService.updatePassword(user,password,oldPassword);
                return "update-password";
            }
            else{
                model.addAttribute("mssg", "Password baru tidak sama");
                return "form-update-password";
            }
        }
        return "home";
    }

   public boolean validatePassword(String password) {
        if (password.length()>=8 && Pattern.compile("[0-11]").matcher(password).find() && Pattern.compile("[a-zA-Z]").matcher(password).find())  {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkUsername(String username) {
        for (UserModel user : userRoleDb.findAll()) {
            if (username.equals(user.getUsername())) {
                return false;
            }
        }
        return true;
    }
}