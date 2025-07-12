package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosReservaConsulta;

public class ValidadorMedicoConOtraConsultaEnElMismoDia {

    private ConsultaRepository repository;

    public void validar(DatosReservaConsulta datos){
        var medicoTieneOtraConsultaElMismoDia = repository.existsByMedicoIdAndFecha(datos.idMedico(), datos.fecha());
        if(medicoTieneOtraConsultaElMismoDia){
            throw new ValidacionException("Medico ya tiene otra consulta en esa misma fecha y hora");
        }
    }
}
