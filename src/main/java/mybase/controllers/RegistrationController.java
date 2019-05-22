package mybase.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import mybase.entities.User;
import mybase.services.UserService;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    // Отобразить страницу регистрации
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    // Добавить нового пользователя
    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model)
    {
        if (!userService.addUser(user))
        {
            model.put("message", "User exists!");
            return "registration";
        }
        return "redirect:/login";
    }
}
