package med.voll.api.domain.medico;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByActivoTrue(Pageable paginacion);

    @Query("""
            SELECT m FROM Medico m
            WHERE
            m.activo = true
            AND
            m.especialidad = :especialidad
            AND m.id NOT IN(
                SELECT c.medico.id FROM Consulta c
                WHERE
                c.fecha = :fecha
            AND
                c.motivoCancelamiento is null
            )
            ORDER BY RAND()
            limit 1
            """)
    Medico elegirMedicoAleatorioDisponibleEnLaFecha(Especialidad especialidad, @NotNull @Future LocalDateTime fecha);

    @Query("""
            select m.activo
            from Medico m
            where
            m.id = :idMedico
            """)
    Boolean findActivoById(Long idMedico);
}
