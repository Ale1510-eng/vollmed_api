package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DatosActualizacionMedico;
import med.voll.api.medico.DatosListaMedico;
import med.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;

    @Transactional
    @PostMapping
    public void registrarPaciente(@RequestBody @Valid DatosRegistroPaciente datos){
        repository.save(new Paciente(datos));
    }

    @GetMapping
    public Page<DatosListaPacientes> listar(@PageableDefault(size=10, sort ={"nombre"} ) Pageable paginacion){
        return repository.findAllByActivoTrue(paginacion)
                .map(DatosListaPacientes::new);
    }

    @Transactional
    @PutMapping
    public void actualizar(@RequestBody @Valid DatosActualizacionPaciente datos){
        var medico = repository.getReferenceById(datos.id());
        medico.actualizarInformacion(datos);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.eliminar();
    }
}
