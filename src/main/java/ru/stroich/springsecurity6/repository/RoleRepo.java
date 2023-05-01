package ru.stroich.springsecurity6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stroich.springsecurity6.model.Role;

@Repository
public interface RoleRepo extends JpaRepository <Role, Long> {
}
