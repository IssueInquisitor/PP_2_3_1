package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;


@Controller
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userDao.getAllUsers());
        return "all-users";
    }

    @GetMapping("/user-create")
    public String createUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userDao.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/user-delete/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userDao.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/user-update/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = userDao.getUserById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(long id, User user) {
        userDao.editUser(id,user);
        return "redirect:/";
    }
}
