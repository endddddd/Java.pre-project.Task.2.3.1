package web.controller;

import web.model.User;
import web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "table", method = RequestMethod.GET)
    public String getTable(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "table";
    }

    @RequestMapping(value = "table", method = RequestMethod.POST)
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/table";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String removeUser(User user) {
        userService.removeUser(user.getId());
        return "redirect:/table";
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String getUpdate(Model model, User user) {
        model.addAttribute("users", userService.getUserById(user.getId()));
        return "update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updateUser(Model model, User user) {
        userService.updateUser(user.getName(), user.getPassword(), user.getId());
        return getUpdate(model, user);
    }

}