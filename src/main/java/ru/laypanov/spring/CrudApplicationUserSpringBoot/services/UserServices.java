package ru.laypanov.spring.CrudApplicationUserSpringBoot.services;

import ru.laypanov.spring.CrudApplicationUserSpringBoot.model.User;

import java.util.List;

public interface UserServices {
    List<User> index();

    User show(int id);

    void save(User user);

    void update(User updateUser);

    void delete(int id);
}
