package com.web.advNotepad.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.concurrent.ExecutionException;

@Controller
public class HomeController
{
    @GetMapping("/")
    public String loadHomePage(Model model) {

        return "index";
    }
}
