package apap.tutorial.gopud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.tutorial.gopud.repository.RoleDb;
import apap.tutorial.gopud.model.RoleModel;


@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDb roleDb;

    @Override
    public List<RoleModel> findAll() {
        return roleDb.findAll();
    }

}