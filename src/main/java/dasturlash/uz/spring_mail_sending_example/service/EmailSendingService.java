package dasturlash.uz.spring_mail_sending_example.service;

import dasturlash.uz.spring_mail_sending_example.dto.MessageDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSendingService {
    @Value("${spring.mail.username}")
    private String fromAccount;
    @Autowired
    private JavaMailSender javaMailSender;

    public String sendSimpleMessage(MessageDTO dto) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(fromAccount);
        msg.setTo(dto.getToAccount());
        msg.setSubject(dto.getSubject());
        msg.setText(dto.getText());
        javaMailSender.send(msg);

        return "Mail was send";
    }

    public String sendMimeMessage(MessageDTO dto) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("<h1 style=\"text-align:center\"> Html-lar orqali jo'natilgan xat. </h1>");
            sb.append("<p> <b>MimeMessage</b>-lar orqali biz chiroyli ko'rinishdagi xabarlarni jo'natsak bo'ladi.</p>");
            sb.append("<p> Uni <code>HTML</code> orqali xarxil ko'rinishga olib kelish mumkin. Mazgi</p>");
            sb.append("<p style=\"background-color: grey; padding:10px\">").append(dto.getText()).append("</p>");
            sb.append("<p>Yaxshi qoling</p>");

            MimeMessage msg = javaMailSender.createMimeMessage();
            msg.setFrom(fromAccount);

            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setTo(dto.getToAccount());
            helper.setSubject(dto.getSubject());
            helper.setText(sb.toString(), true);
            javaMailSender.send(msg);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return "Mail was send";
    }
}
