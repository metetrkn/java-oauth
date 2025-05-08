package se.mete.javawebdemo.controllers;

import se.mete.javawebdemo.models.POPSingerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController extends BaseController {
    @Autowired
    POPSingerRepository popsingerRepository;
    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("singer", popsingerRepository.findAll());
        model.addAttribute("user", "Bithun");

        return "home";
    }
    @GetMapping("/profile")
    public String profile(Model model) {
        String user = getLoggedInEmail();
        model.addAttribute("user", user);
        return "profile";
    }
}