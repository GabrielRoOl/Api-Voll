package br.com.med.voll.api.dto;


import br.com.med.voll.api.enums.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsultaDTO(
        Long idMedico,
        @NotNull Long idPaciente,
        @NotNull @Future LocalDateTime data,
        Especialidade especialidade) {
}
