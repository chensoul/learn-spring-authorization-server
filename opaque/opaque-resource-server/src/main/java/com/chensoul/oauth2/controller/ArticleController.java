package com.chensoul.oauth2.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ArticleController {

    @GetMapping("/resource/article")
    public Map<String, Object> foo(@AuthenticationPrincipal OAuth2AuthenticatedPrincipal principal) {
        Map<String, Object> result = new HashMap<>();
        result.put("sub", principal.getAttribute("sub"));
        result.put("articles", Arrays.asList("Effective Java", "Spring In Action"));

        return result;
    }
}
