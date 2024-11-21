package ru.fond.test_http.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.fond.test_http.model.User;

@Repository
public interface ExampleRepository extends CrudRepository<User, String> {
}
