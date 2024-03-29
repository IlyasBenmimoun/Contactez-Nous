package Groupe;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;


@Configuration
public class MailConfig {

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.default-encoding}")
    private String encoding;

    @Value("${spring.mail.properties.mail.debug}")
    private String debug;


    @Value("${spring.mail.username}")
    private String username;
    //@Value("${spring.mail.password}")
    //private String password;
    @Value("${spring.mail.properties.mail.smtp.auth}")
    private String auth;
    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private String starttls;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setDefaultEncoding(encoding);
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        //mailSender.setPassword(password);
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", auth);
        properties.put("mail.smtp.starttls.enable", starttls);
        properties.put("mail.debug", debug);
        mailSender.setJavaMailProperties(properties);

        return mailSender;
    }

}