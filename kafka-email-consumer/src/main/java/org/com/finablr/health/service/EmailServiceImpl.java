package org.com.finablr.health.service;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.com.finablr.health.entity.Mail;
import org.com.finablr.health.entity.dto.UserDto;
import org.com.finablr.health.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    public MailRepository mailRepository;
    
    

    @Override
    public void sendSimpleMessage(UserDto input) {
        try {

            Mail newMail = new Mail();
            newMail.setUserName(input.getUsername());
            newMail.setToken(input.getToken());
           // newMail.setText(input.getText());

           /* SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("simbu0206@gmail.com");
            message.setTo("eceshiva87@gmail.com");
            message.setSubject(input.getSubject());
            message.setText(input.getText());

            mailRepository.save(newMail);*/
            
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setTo(input.getUsername());
            helper.setText("Appointment");
            helper.setSubject("Dear User : Your have booked the appointment");
            emailSender.send(message);

           // emailSender.send(message);
           
        } catch (MailException | MessagingException exception) {
            exception.printStackTrace();
        }

    }
}
