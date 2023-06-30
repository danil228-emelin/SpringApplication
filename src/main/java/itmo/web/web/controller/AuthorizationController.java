package itmo.web.web.controller;

import itmo.web.web.service.LoginProcessor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class AuthorizationController {
    private LoginProcessor login;

    @GetMapping
    public String getPage() {
        return "logPage.xml";
    }

    @GetMapping("/main")
    public String getMain(Model model) {
        model.addAttribute("username", login.getUserName());
        return "main.html";
    }

    @PostMapping
    public String logIn(@RequestParam String username, @RequestParam String password, Model model) {
        login.setPassword(password);
        login.setUserName(username);
        var result = login.verifyBoolean();
        if (result) {
            return "redirect:/main";
        }
        model.addAttribute("message", "Logging failed");
        return "logPage.xml";
    }
}
