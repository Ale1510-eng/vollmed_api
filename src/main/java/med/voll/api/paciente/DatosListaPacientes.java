package med.voll.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.direccion.DatosDireccion;
import med.voll.api.direccion.Direccion;

public record DatosListaPacientes(
        String nombre,
        String email,
        String documento
) {
    public DatosListaPacientes(Paciente paciente) {
        this(paciente.getNombre(),
        paciente.getEmail(),
        paciente.getDocumento_identidad());
    }
}
