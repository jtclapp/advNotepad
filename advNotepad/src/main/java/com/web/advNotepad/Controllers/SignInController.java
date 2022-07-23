package com.web.advNotepad.Controllers;

import com.web.advNotepad.models.Credentials;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController
{
    @GetMapping("/signIn")
    public String loadLoginPage(Model model) {
        Authentication user_authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = user_authentication.getName();
        if (!currentUserName.equals("") && !currentUserName.equals("anonymousUser")) {
            model.addAttribute("currentUser", currentUserName);
        }
        model.addAttribute("credentials", new Credentials());
        return "signIn";
    }
}
