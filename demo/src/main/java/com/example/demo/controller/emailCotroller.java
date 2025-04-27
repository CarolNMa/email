package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.emailService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class emailCotroller {

    @Autowired
    private emailService emailService;
    @GetMapping("/basicEmail")
    public String sendBasicEmail(){
        emailService.basicMail();
        return "mail sent successfully";
    }

   @GetMapping("/advancedEmail/{email}")
    public String advancedEmail(@PathVariable String email) {
        emailService.advancedEmail(email);
        return "mail sent successfully";
    }

    @GetMapping("/nueva-cuenta/{email}")
    public String sendNewAccountEmail(@RequestParam String email) {
        emailService.sendNewAccountEmail(email);
        return "Correo de bienvenida enviado.";
    }

    @GetMapping("/olvide-contrasena/{email}")
    public String sendForgotPasswordEmail(@RequestParam String email, @RequestParam String resetLink) throws MessagingException {
        emailService.sendForgotPasswordEmail(email, resetLink);
        return "Correo de recuperación de contraseña enviado.";
    }

    @GetMapping("/activacion/{email}")
    public String sendActivationEmail(@RequestParam String email, @RequestParam String code) throws MessagingException {
        emailService.sendActivationEmail(email, code);
        return "Correo de activación enviado.";
    }

    @GetMapping("/contrasena-cambiada/{email}")
    public String sendPasswordChangedNotification(@RequestParam String email) throws MessagingException {
        emailService.sendPasswordChangedNotification(email);
        return "Correo de notificación de cambio de contraseña enviado.";
    }

    @GetMapping("/low-stock/{email}")
    public String sendLowStockNotification(@RequestParam String email, @RequestParam String product, @RequestParam int stock) throws MessagingException {
        emailService.sendLowStockNotification(email, product, stock);
        return "Correo de notificación de bajo stock enviado.";
    }

    @GetMapping("/compra/{email}")
    public String sendPurchaseNotification(@RequestParam String email, @RequestBody List<String> productos) throws MessagingException {
        emailService.sendPurchaseNotification(email, productos);
        return "Correo de confirmación de compra enviado.";
    }
}
