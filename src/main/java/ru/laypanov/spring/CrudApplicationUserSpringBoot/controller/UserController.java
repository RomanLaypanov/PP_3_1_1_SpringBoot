package ru.laypanov.spring.CrudApplicationUserSpringBoot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.laypanov.spring.CrudApplicationUserSpringBoot.model.User;
import ru.laypanov.spring.CrudApplicationUserSpringBoot.services.UserServices;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserServices userServise;

    @Autowired
    public UserController(UserServices userServise) {
        this.userServise = userServise;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("usersList", userServise.index());

        return "users/index";
    }

    @GetMapping("/show")
    public String show(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userServise.show(id));

        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());

        return "users/new";
    }

    @PostMapping("create")
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/new";
        }

        userServise.save(user);

        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userServise.show(id));

        return "users/edit";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") int id, @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }

        user.setId(id);
        userServise.update(user);

        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        userServise.delete(id);

        return "redirect:/users";
    }
}