package apitiendavideo.apitiendavideo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarCorreo(String destinatario, String asunto, String contenido) {
        try {
            SimpleMailMessage mensaje = new SimpleMailMessage();
            mensaje.setTo(destinatario);
            mensaje.setSubject(asunto);
            mensaje.setText(contenido);
            mensaje.setFrom("juan02031@gmail.com");

            mailSender.send(mensaje);

        } catch (Exception e) {
            // Puedes registrar el error para fines de auditoría o depuración
            System.err.println("Error al enviar correo: " + e.getMessage());

            // Re-lanzar la excepción para que el controlador la maneje
            throw new RuntimeException("Fallo al enviar correo", e);
        }
    }

}
