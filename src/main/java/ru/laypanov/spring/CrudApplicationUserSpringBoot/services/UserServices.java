package ru.laypanov.spring.CrudApplicationUserSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.laypanov.spring.CrudApplicationUserSpringBoot.dao.UserDao;
import ru.laypanov.spring.CrudApplicationUserSpringBoot.model.User;

import java.util.List;

@Component
@Transactional(readOnly = true)
public class UserServices {
    private final UserDao userDao;

    @Autowired
    public UserServices(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> index() {
        return userDao.index();
    }

    public User show(int id) {
        return userDao.show(id);
    }

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    public void update(User updateUser) {
        userDao.update(updateUser);
    }

    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }
}
