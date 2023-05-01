package ru.stroich.springsecurity6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.stroich.springsecurity6.model.Role;
import ru.stroich.springsecurity6.repository.RoleRepo;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepo roleRepo;

    @Autowired
    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    @Transactional (readOnly = true)
    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }
}
