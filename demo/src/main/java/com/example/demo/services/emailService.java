package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class emailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void basicMail() {
        try {
            // destinatario
            String addressMail = "****@gmail.com";
            // Asunto
            String subject = "Este es un correo de prueba";
            // Cuerpo Correo
            String bodyMail = "Correo prueba";
            emailSender(addressMail, subject, bodyMail);
        } catch (Exception e) {

        }
    }

    public void advancedEmail(String addressMail) {
        try {
            // destinatario
            // String addressMail = "cjcs.cadenasarasty8@gmail.com";
            // Asunto
            String subject = "Este es un correo de prueba";
            // Cuerpo Correo
            String bodyMail = ""
    + "<!DOCTYPE html>\n"
    + "<html lang=\"es\">\n"
    + "<head>\n"
    + "    <meta charset=\"UTF-8\">\n"
    + "    <title>Correo de Prueba</title>\n"
    + "    <style>\n"
    + "        body {\n"
    + "            font-family: Arial, sans-serif;\n"
    + "            background-color: #f4f4f4;\n"
    + "            margin: 0;\n"
    + "            padding: 0;\n"
    + "        }\n"
    + "        .correo-container {\n"
    + "            background-color: #ffffff;\n"
    + "            max-width: 600px;\n"
    + "            margin: 40px auto;\n"
    + "            padding: 30px;\n"
    + "            border-radius: 8px;\n"
    + "            box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);\n"
    + "        }\n"
    + "        h2 {\n"
    + "            color: #333333;\n"
    + "        }\n"
    + "        p {\n"
    + "            font-size: 16px;\n"
    + "            color: #555555;\n"
    + "        }\n"
    + "        .btn {\n"
    + "            display: inline-block;\n"
    + "            margin-top: 20px;\n"
    + "            padding: 12px 20px;\n"
    + "            background-color: #007BFF;\n"
    + "            color: white;\n"
    + "            text-decoration: none;\n"
    + "            border-radius: 5px;\n"
    + "        }\n"
    + "        .footer {\n"
    + "            margin-top: 30px;\n"
    + "            font-size: 12px;\n"
    + "            color: #aaaaaa;\n"
    + "            text-align: center;\n"
    + "        }\n"
    + "    </style>\n"
    + "</head>\n"
    + "<body>\n"
    + "    <div class=\"correo-container\">\n"
    + "        <h2>¡Hola, Juan!</h2>\n"
    + "        <p>Este es un correo de prueba enviado desde nuestra aplicación de Spring Boot.</p>\n"
    + "        <p>Haz clic en el botón a continuación para visitar nuestro sitio:</p>\n"
    + "        <a href=\"https://www.ejemplo.com\" class=\"btn\">Ir al sitio</a>\n"
    + "        <div class=\"footer\">\n"
    + "            © 2025 Tu Empresa. Todos los derechos reservados.\n"
    + "        </div>\n"
    + "    </div>\n"
    + "</body>\n"
    + "</html>";

            emailSender(addressMail, subject, bodyMail);
        } catch (Exception e) {

        }
    }

    public boolean emailSender(String addressMail, String subject, String bodyMail) throws MessagingException {
        try {
            // creación del correo
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(addressMail);
            helper.setSubject(subject);
            helper.setText(bodyMail,true);
            javaMailSender.send(message);
            ;
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void sendNewAccountEmail(String email) {
        try {
            String subject = "¡Bienvenido a nuestro sistema!";
            String body = "<html>" +
                "<body style='font-family: Arial, sans-serif; background-color: #fee9e1; padding: 20px;'>" +
                "<div style='background-color: #ffffff; border: 1px solid #b09e99; padding: 20px; border-radius: 10px; text-align: center;'>" +
                "<h1 style='color: #fad4c0;'>¡Bienvenido, Juan!</h1>" +
                "<p style='color: #333;'>Tu cuenta ha sido creada exitosamente. Haz clic abajo para iniciar sesión:</p>" +
                "<a href='https://example.com/login' style='display: inline-block; background-color: #fad4c0; color: #ffffff; padding: 10px 20px; text-decoration: none; border-radius: 5px; font-size: 16px;'>Iniciar Sesión</a>" +
                "</div>" +
                "</body>" +
                "</html>";
            emailSender(email, subject, body);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void sendForgotPasswordEmail(String email, String resetLink) throws MessagingException {
        String subject = "Recuperación de contraseña";
        String body = "<html>" +
            "<body style='font-family: Arial, sans-serif; background-color: #fee9e1; padding: 20px;'>" +
            "<div style='background-color: #ffffff; border: 1px solid #b09e99; padding: 20px; border-radius: 10px; text-align: center;'>" +
            "<h1 style='color: #fad4c0;'>Restablecimiento de contraseña</h1>" +
            "<p style='color: #333;'>Haz clic en el siguiente enlace para restablecer tu contraseña:</p>" +
            "<a href='" + resetLink + "' style='display: inline-block; background-color: #ff7b8c; color: #ffffff; padding: 10px 20px; text-decoration: none; border-radius: 5px; font-size: 16px;'>Restablecer Contraseña</a>" +
            "</div>" +
            "</body>" +
            "</html>";
        emailSender(email, subject, body);
    }
    
    public void sendActivationEmail(String email, String code) throws MessagingException {
        String subject = "Activación de cuenta";
        String body = "<html>" +
            "<body style='font-family: Arial, sans-serif; background-color: #fee9e1; padding: 20px;'>" +
            "<div style='background-color: #ffffff; border: 1px solid #b09e99; padding: 20px; border-radius: 10px; text-align: center;'>" +
            "<h1 style='color: #fad4c0;'>Código de Activación</h1>" +
            "<p style='color: #333;'>Tu código de activación es: <strong>" + code + "</strong></p>" +
            "<p style='color: #333;'>Ingresa este código en la página de activación para activar tu cuenta.</p>" +
            "</div>" +
            "</body>" +
            "</html>";
        emailSender(email, subject, body);
    }
    
    public void sendPasswordChangedNotification(String email) throws MessagingException {
        String subject = "Contraseña actualizada";
        String body = "<html>" +
            "<body style='font-family: Arial, sans-serif; background-color: #fee9e1; padding: 20px;'>" +
            "<div style='background-color: #ffffff; border: 1px solid #b09e99; padding: 20px; border-radius: 10px; text-align: center;'>" +
            "<h1 style='color: #fad4c0;'>Contraseña actualizada</h1>" +
            "<p style='color: #333;'>Te notificamos que tu contraseña ha sido cambiada correctamente.</p>" +
            "<p style='color: #333;'>Si no realizaste este cambio, comunícate con nosotros inmediatamente.</p>" +
            "</div>" +
            "</body>" +
            "</html>";
        emailSender(email, subject, body);
    }
    
    public void sendLowStockNotification(String email, String product, int stock) throws MessagingException {
        String subject = "Notificación de bajo stock";
        String body = "<html>" +
            "<body style='font-family: Arial, sans-serif; background-color: #fee9e1; padding: 20px;'>" +
            "<div style='background-color: #ffffff; border: 1px solid #b09e99; padding: 20px; border-radius: 10px; text-align: center;'>" +
            "<h1 style='color: #ff7b8c;'>¡Atención: Stock Bajo!</h1>" +
            "<p style='color: #333;'>El producto <strong>" + product + "</strong> tiene un stock bajo.</p>" +
            "<p style='color: #333;'>Cantidad disponible: " + stock + " unidades.</p>" +
            "<p style='color: #333;'>Por favor toma las acciones necesarias.</p>" +
            "</div>" +
            "</body>" +
            "</html>";
        emailSender(email, subject, body);
    }
    
    public void sendPurchaseNotification(String email, List<String> productos) throws MessagingException {
        String subject = "Confirmación de compra";
        StringBuilder productList = new StringBuilder();
        for (String producto : productos) {
            productList.append("<li>").append(producto).append("</li>");
        }
        String body = "<html>" +
            "<body style='font-family: Arial, sans-serif; background-color: #fee9e1; padding: 20px;'>" +
            "<div style='background-color: #ffffff; border: 1px solid #b09e99; padding: 20px; border-radius: 10px; text-align: center;'>" +
            "<h1 style='color: #fad4c0;'>¡Gracias por tu compra!</h1>" +
            "<p style='color: #333;'>Tu pedido ha sido procesado con éxito. Has adquirido los siguientes productos:</p>" +
            "<ul>" + productList.toString() + "</ul>" +
            "<p style='color: #333;'>Esperamos verte pronto.</p>" +
            "</div>" +
            "</body>" +
            "</html>";
        emailSender(email, subject, body);
    }
    
          
}