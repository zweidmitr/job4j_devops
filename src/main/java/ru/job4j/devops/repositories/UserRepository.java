package ru.job4j.devops.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.devops.models.User;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
}
