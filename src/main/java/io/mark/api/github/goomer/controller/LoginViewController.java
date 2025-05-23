package io.mark.api.github.goomer.controller;

import io.mark.api.github.goomer.security.CustomAuthentication;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginViewController {

    @GetMapping("/")
    @ResponseBody
    public String paginaHome(Authentication authentication){
        if(authentication instanceof CustomAuthentication customAuth){
            System.out.println(customAuth.getUsuarios());
        }
        return "Olá " + authentication.getName();
    }

    @GetMapping("/authorized")
    @ResponseBody
    public String getAuthorizationCode(@RequestParam("code") String code){
        return "Seu authorization code: " + code;
    }
}
