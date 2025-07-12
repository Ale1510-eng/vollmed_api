package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.DatosReservaConsulta;

import java.time.DayOfWeek;

public class ValidadorFueraHorarioConsultas {

    public void validarReservaConsulta(DatosReservaConsulta datos){
        var fechaConsulta = datos.fecha();
        var domingo = fechaConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var horarioAntesAperturaClinica = fechaConsulta.getHour() < 7;
        var horarioDespuesAperturaClinica = fechaConsulta.getHour() > 18;
        if(domingo || horarioAntesAperturaClinica || horarioDespuesAperturaClinica){
            throw new ValidacionException("Horario seleccionado fuera del horario de atendimiento de la clínica");
        }
    }
}
