package br.com.med.voll.api.dto;

import br.com.med.voll.api.domain.model.consulta.Consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsultaDTO(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
    public DadosDetalhamentoConsultaDTO(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }
}
