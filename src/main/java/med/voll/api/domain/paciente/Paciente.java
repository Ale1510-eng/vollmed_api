package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.direccion.Direccion;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private boolean activo;
    private String nombre;
    private String email;
    private String telefono;
    private String documento_identidad;
    @Embedded
    private Direccion direccion;

    public Paciente(DatosRegistroPaciente datos) {
        this.activo = true;
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.telefono = datos.telefono();
        this.documento_identidad = datos.documento_identidad();
        this.direccion = new Direccion(datos.direccion());
    }

    public void actualizarInformacion(@Valid DatosActualizacionPaciente datos) {
        if(datos.nombre() != null){
            this.nombre = datos.nombre();
        }
        if(datos.telefono() != null){
            this.telefono = datos.telefono();
        }
        if(datos.direccion() != null){
            this.direccion.actualizarDireccion(datos.direccion());
        }
    }

    public void eliminar() {
        this.activo = false;
    }
}
