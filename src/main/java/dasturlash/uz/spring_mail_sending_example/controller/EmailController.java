package dasturlash.uz.spring_mail_sending_example.controller;

import dasturlash.uz.spring_mail_sending_example.dto.MessageDTO;
import dasturlash.uz.spring_mail_sending_example.service.EmailSendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail-send")
public class EmailController {

    @Autowired
    private EmailSendingService emailSendingService;

    @PostMapping("/simple")
    public String sendEmail(@RequestBody MessageDTO dto) {
        return emailSendingService.sendSimpleMessage(dto);
    }

    @PostMapping("/mime")
    public String sendMime(@RequestBody MessageDTO dto) {
        return emailSendingService.sendMimeMessage(dto);
    }

}
