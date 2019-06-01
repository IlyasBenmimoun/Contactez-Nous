package Groupe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class Mail {

    @Autowired
    MailSender mailSender;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TemplateEngine templateEngine;

    protected boolean sendSimpleMail(Contactez contact) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(contact.getEmail());
        mailMessage.setSubject("new Message");
        mailMessage.setText(contact.getMessage());
        mailMessage.setTo("ilyas.benmimoun@gmail.com");

        try {
            mailSender.send(mailMessage);
            return true;
        } catch (MailException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean sendHtmlMail(Contactez contact) {

        Context context = new Context();
        context.setVariable("contact", contact);
        final String messageHtml = templateEngine.process("email/contact", context);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mailMessage = new MimeMessageHelper(mimeMessage);
        try {
            mailMessage.setTo("ilyas.benmimoun@gmail.com");
            mailMessage.setFrom(contact.getEmail());
            mailMessage.setSubject("New Message");
            mailMessage.setText(messageHtml, true);
            javaMailSender.send(mimeMessage);
            return true;
        } catch (MessagingException | MailException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}