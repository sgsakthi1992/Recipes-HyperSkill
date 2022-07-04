package recipes.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recipes.domain.User;
import recipes.service.RegisterService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/register")
@Validated
public class RegisterController {
    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    public void register(@Valid @RequestBody User user) {
        registerService.register(user);
    }
}
