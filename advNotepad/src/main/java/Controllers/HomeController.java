package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.concurrent.ExecutionException;

@Controller
public class HomeController
{
    @GetMapping("/")
    public void loadHomePage(Model model) throws ExecutionException, InterruptedException {

    }
}
