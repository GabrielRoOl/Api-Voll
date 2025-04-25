package br.com.med.voll.api.validacoes;

import br.com.med.voll.api.dto.DadosAgendamentoConsultaDTO;

public interface ValidadorAgendamentoConsulta {
    void validar(DadosAgendamentoConsultaDTO dados);
}
