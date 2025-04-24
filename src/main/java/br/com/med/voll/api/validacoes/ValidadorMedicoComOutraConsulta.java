package br.com.med.voll.api.validacoes;

import br.com.med.voll.api.dto.DadosAgendamentoConsultaDTO;
import br.com.med.voll.api.exceptions.ValidacaoException;
import br.com.med.voll.api.repositories.ConsultaRepository;

public class ValidadorMedicoComOutraConsulta {

    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsultaDTO dados) {
        var medicoPossuiOutraConsulta = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsulta) {
            throw new ValidacaoException("Médico já possui consulta agendada nesse hórario");
        }
    }
}
