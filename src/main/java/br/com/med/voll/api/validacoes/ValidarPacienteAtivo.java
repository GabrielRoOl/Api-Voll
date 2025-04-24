package br.com.med.voll.api.validacoes;

import br.com.med.voll.api.dto.DadosAgendamentoConsultaDTO;
import br.com.med.voll.api.exceptions.ValidacaoException;
import br.com.med.voll.api.repositories.PacienteRepository;

public class ValidarPacienteAtivo {

    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsultaDTO dados) {
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído");
        }
    }
}
