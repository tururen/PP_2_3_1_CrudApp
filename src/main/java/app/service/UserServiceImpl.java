package app.service;

import app.dao.UserDao;
import app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public List<User> getAll() {
        return dao.getAllUsers();
    }

    @Override
    public void save(User user) {
        dao.addUser(user);
    }

    @Override
    public void remove(Long id) {
        dao.deleteUser(id);
    }

    @Override
    public User getById(Long id) {
        return dao.getUserById(id);
    }

    @Override
    public User update(User user) {
        return dao.updateUser(user);
    }
}
