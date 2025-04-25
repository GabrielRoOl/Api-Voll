package br.com.med.voll.api.validacoes;

import br.com.med.voll.api.dto.DadosAgendamentoConsultaDTO;
import br.com.med.voll.api.infra.exceptions.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;

@Component
public class ValidadorHorarioAnt implements ValidadorAgendamentoConsulta {
    public void validar(DadosAgendamentoConsultaDTO dados) {
        var dataConsulta = dados.data();
        var agora = LocalDate.now();
        var diferencaMin = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaMin < 30) {
            throw new ValidacaoException("Consulta dever ser agendada com mais de 30 min.");
        }
    }
}

