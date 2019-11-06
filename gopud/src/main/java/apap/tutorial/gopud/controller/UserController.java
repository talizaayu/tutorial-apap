package apap.tutorial.gopud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}