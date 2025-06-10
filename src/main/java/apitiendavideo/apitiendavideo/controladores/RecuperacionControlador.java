package apitiendavideo.apitiendavideo.controladores;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import apitiendavideo.apitiendavideo.modelos.Cliente;
import apitiendavideo.apitiendavideo.repositorios.ClienteRepositorio;
import apitiendavideo.apitiendavideo.servicios.EmailService;

@RestController
@RequestMapping("/recuperacion")
public class RecuperacionControlador {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar-clave")
    public ResponseEntity<?> enviarClave(@RequestBody Map<String, String> request) {
        String correo = request.get("correo");

        Optional<Cliente> clienteOpt = clienteRepositorio.findByCorreo(correo);
        if (clienteOpt.isEmpty()) {
            return ResponseEntity.status(404).body("Correo no encontrado.");
        }

        Cliente cliente = clienteOpt.get();
        String mensaje = "Hola " + cliente.getNombre() + ",\n\nTu contraseña actual es: " + cliente.getClave();

        emailService.enviarCorreo(correo, "Recuperación de contraseña 'Tienda Video'", mensaje);

        return ResponseEntity.ok("Correo enviado con éxito.");
    }
}

