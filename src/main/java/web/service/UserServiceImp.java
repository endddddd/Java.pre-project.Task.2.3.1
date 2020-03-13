package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao dao;

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Transactional
    @Override
    public boolean addUser(User user) {
        if (user.getName().trim().length() == 0 || user.getPassword().trim().length() == 0 || dao.isNotReg(user.getName())) {
            return false;
        } else {
            dao.addUser(user);
            return true;
        }

    }

    @Transactional
    @Override
    public void removeUser(long id) {
         dao.removeUser(id);
    }

    @Transactional
    @Override
    public boolean updateUser(String name, String password, Long id) {
        if (name.trim().length() == 0 || password.trim().length() == 0) {
            return false;
        } else {
            dao.updateUser(name, password, id);
            return true;
        }

    }

    @Transactional
    @Override
    public List<User> getUserById(long id) {
        return dao.getUserById(id);
    }
}
