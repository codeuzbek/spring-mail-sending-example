package dasturlash.uz.spring_mail_sending_example.condif;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class SpringConfig {
  /*  @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.username}")
    private String fromAccount;
    @Value("${spring.mail.password}")
    private String password;
    @Value("${spring.mail.port}")
    private Integer port;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(fromAccount);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp"); //  property-dan olib set qilsak bo'ladi
        props.put("mail.smtp.auth", "true"); //  property-dan olib set qilsak bo'ladi
        props.put("mail.smtp.starttls.enable", "true"); //  property-dan olib set qilsak bo'ladi
        props.put("mail.debug", "true"); //  property-dan olib set qilsak bo'ladi
        return mailSender;
    }*/
}
