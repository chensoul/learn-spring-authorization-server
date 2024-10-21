package com.chensoul.oauth2.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    private static Map<String, List<String>> articles = new HashMap<>();

    static {
        articles.put("ROLE_OPERATION", Arrays.asList("Java"));
        articles.put("ROLE_SYSTEM", Arrays.asList("Java", "Python", "C++"));
    }

    @GetMapping("/home")
    public String home(Authentication authentication, Model model) {
        String authority = authentication.getAuthorities().iterator().next().getAuthority();
        model.addAttribute("articles", articles.get(authority));
        return "home";
    }
}
