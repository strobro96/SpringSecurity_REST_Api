package ru.stroich.springsecurity6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.stroich.springsecurity6.model.User;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("Select u from User u left join fetch u.roles where u.username=:username")
    Optional<User> findByUsername(String username);
}
