package apitiendavideo.apitiendavideo.controladores;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import apitiendavideo.apitiendavideo.dtos.MensajeDTO;
import apitiendavideo.apitiendavideo.modelos.Cliente;
import apitiendavideo.apitiendavideo.repositorios.ClienteRepositorio;
import apitiendavideo.apitiendavideo.servicios.EmailService;

// DTOs para el login
class LoginRequest {
    public String correo;
    public String clave;
}

class LoginResponse {
    public String mensaje;
    public ClienteDTO usuario;

    public LoginResponse(String mensaje, ClienteDTO usuario) {
        this.mensaje = mensaje;
        this.usuario = usuario;
    }
}

class ClienteDTO {
    public String correo;
    public String nombre;
    public String rol;

    public ClienteDTO(String correo, String nombre, String rol) {
        this.correo = correo;
        this.nombre = nombre;
        this.rol = rol;
    }
}

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthControlador {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private EmailService emailService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest login) {
        Optional<Cliente> clienteOpt = clienteRepositorio.findByCorreo(login.correo);

        if (clienteOpt.isEmpty()) {
            return ResponseEntity.status(401).body("Correo no encontrado");
        }

        Cliente cliente = clienteOpt.get();

        if (!cliente.getActivo()) {
            return ResponseEntity.status(403).body("Cuenta inactiva");
        }

        if (!cliente.getClave().equals(login.clave)) {
            return ResponseEntity.status(401).body("Correo &/O clave incorrecta");
        }

        ClienteDTO clienteDTO = new ClienteDTO(cliente.getCorreo(), cliente.getNombre(), cliente.getRol());

        return ResponseEntity.ok(new LoginResponse("Login exitoso", clienteDTO));
    }

    @PostMapping("/enviar-clave")
    public ResponseEntity<?> enviarClave(@RequestBody Map<String, String> body) {
        String correo = body.get("correo");

        Optional<Cliente> clienteOpt = clienteRepositorio.findByCorreo(correo);

        if (clienteOpt.isEmpty()) {
            return ResponseEntity.status(404).body(new MensajeDTO("Correo no encontrado"));
        }

        Cliente cliente = clienteOpt.get();
        String clave = cliente.getClave();

        try {
            // Intentar enviar el correo
            emailService.enviarCorreo(
                correo,
                "Recuperación de Clave",
                "Tu clave actual es: **" + clave + "**.\n\nTe recomendamos cambiarla si no fuiste tú quien la solicitó."
            );

            // Si se ejecuta sin lanzar error, asumimos éxito
            return ResponseEntity.ok(new MensajeDTO("La clave ha sido enviada al correo"));

        } catch (Exception e) {
            // Si hay error, se captura y se responde adecuadamente
            return ResponseEntity.status(500).body(new MensajeDTO("Error al enviar el correo: " + e.getMessage()));
        }
    }


}
