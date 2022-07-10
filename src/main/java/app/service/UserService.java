package app.service;

import app.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    void save(User user);

    void remove(Long id);

    User getById(Long id);

    User update(User user);

}
