package Groupe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@RestController
public class Controlleur {
    @Autowired
    Mail mail;

    @RequestMapping("/")
    public String index(@ModelAttribute Contactez contactez) {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/")
    public String ProContactez(@Validated Contactez contact, RedirectAttributes model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "index";
        }
        if (mail.sendSimpleMail(contact)) {
            model.addFlashAttribute("classCss", "alert alert-warning");
            model.addFlashAttribute("message", "Erreur ^^' ");
        } else {
            model.addFlashAttribute("classCss", "alert alert-success");
            model.addFlashAttribute("message", "Votre message est Bien envoyer ^^!");
        }
        return "redirect:/";
    }
}