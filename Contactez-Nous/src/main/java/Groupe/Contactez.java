package Groupe;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Contactez {
    @NotBlank
    @Pattern(regexp = "[\\{L} '-]+" , message = "ce champ ne doit contenir que des lettres")
    private String nom;
    @NotBlank
    @Pattern(regexp = "[\\{L} '-]+" , message = "ce champ ne doit contenir que des lettres")
    private String prenom;
    @NotBlank
    @Pattern(regexp = "^[_A-Za-z0-9-]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$" , message = "ce format n'est pas valide")
    private String email;
    @NotBlank
    private String message;

    public Contactez(){}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
