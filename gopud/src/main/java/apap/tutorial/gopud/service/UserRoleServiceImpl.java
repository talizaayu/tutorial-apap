package apap.tutorial.gopud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import apap.tutorial.gopud.model.UserModel;
import apap.tutorial.gopud.repository.UserRoleDb;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDb userRoleDb;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userRoleDb.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public UserModel findByUsername(String username) {
        return userRoleDb.findByUsername(username);
    }

    @Override
    public UserModel updatePassword(UserModel user, String password, String oldPassword) {
        String encryptPass = encrypt(password);
        user.setPassword(encryptPass);
        return userRoleDb.save(user);
    }

    @Override
    public Boolean validate(String passwordExisted, String inputPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(inputPassword, passwordExisted);
    }
}