package home.tur.CrudApp.service;

import home.tur.CrudApp.dao.UserRepository;
import home.tur.CrudApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getById(Long id) {
        if (userRepository.findById(id).isEmpty()){
            throw new RuntimeException();
        }
        return userRepository.findById(id).get();
    }

}
