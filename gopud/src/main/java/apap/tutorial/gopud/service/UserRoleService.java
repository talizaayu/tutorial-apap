package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.UserModel;

public interface UserRoleService {
    UserModel addUser(UserModel user);
    public String encrypt(String password);
    UserModel updatePassword(UserModel user, String password, String oldPassword);
    UserModel findByUsername(String username);
    public Boolean validate(String passwordExisted, String inputPassword);
}