package med.voll.api.domain.paciente;

import med.voll.api.domain.direccion.Direccion;

public record DatosDetallePaciente(
        Long id,
        String nombre,
        String email,
        String telefono,
        String documento_identidad,
        Direccion direccion
) {
    public DatosDetallePaciente(Paciente paciente){
        this(
                paciente.getId(),
                paciente.getNombre(),
                paciente.getEmail(),
                paciente.getTelefono(),
                paciente.getDocumento_identidad(),
                paciente.getDireccion()
        );
    }
}
