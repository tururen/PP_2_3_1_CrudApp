package app.controller;

import app.entity.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = {"/", "/list"})
    public String showAllUsers(Model model) {

        List<User> userList = service.getAll();
        model.addAttribute("userList", userList);

        return "allUsers";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute ("user") User user) {
        service.save(user);
        return "redirect:/list";
    }
    @GetMapping("/updateUserInfo")
    public String updateUserInfo(@RequestParam("userId") Long id, Model model) {
        User user = service.getById(id);
        model.addAttribute("user", user);
        return "addUser";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") Long id) {
        service.remove(id);
        return "redirect:/list";
    }
}