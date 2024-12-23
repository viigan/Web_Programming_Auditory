package mk.ukim.finki.wp2024.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp2024.model.User;
import mk.ukim.finki.wp2024.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.wp2024.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@Controller
//@RequestMapping("/login")
//public class LoginController{
//    private final AuthService authService;
//
//    public LoginController(AuthService authService ){
//        this.authService = authService;
//
//    }
//
//@GetMapping
//public String getLoginPage(){
//        return "login";
//    }
//
//    @PostMapping
//    public  String login(HttpServletRequest request,Model model){
//    User user =null;
//
//    try {
//        user = this.authService.login(request.getParameter("username"),request.getParameter("password"));
//        request.getSession().setAttribute("user",user);
////        String username = request.getParameter("username");
////        String password = request.getParameter("password");
//
//        return "redirect:/home";
//
//    }catch (InvalidUserCredentialsException exception){
//        model.addAttribute("hassError",true);
//        model.addAttribute("error",exception.getMessage());
//        return "login";
//    }
//
//    }


////@RestController
@Controller
@RequestMapping("/login")
public class LoginController {
    private final AuthService authService;
    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    //@RequestMapping(method = RequestMethod.GET, value = "/login")
    @GetMapping
    public String getLoginPage() {
        // Return the name of the Thymeleaf template that will be used to render the login page
        return "login";
    }
    @PostMapping
    public String login(HttpServletRequest request, Model model) {
        User user = null;

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            user = authService.login(username, password);
            request.getSession().setAttribute("user", user);
            // Redirect to the home page
            return "redirect:/home";
        } catch (RuntimeException ex) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", ex.getMessage());
            return "login";
        }
    }
}
