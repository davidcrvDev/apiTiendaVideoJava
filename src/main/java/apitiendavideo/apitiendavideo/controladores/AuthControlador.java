package apitiendavideo.apitiendavideo.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import apitiendavideo.apitiendavideo.modelos.Cliente;
import apitiendavideo.apitiendavideo.repositorios.ClienteRepositorio;

// DTOs para el login
class LoginRequest {
    public String correo;
    public String clave;
}

class LoginResponse {
    public String mensaje;
    public String rol;

    public LoginResponse(String mensaje, String rol) {
        this.mensaje = mensaje;
        this.rol = rol;
    }
}

@RestController
@RequestMapping("/auth")
public class AuthControlador {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

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

        return ResponseEntity.ok(new LoginResponse("Login exitoso", cliente.getRol()));
    }
}
