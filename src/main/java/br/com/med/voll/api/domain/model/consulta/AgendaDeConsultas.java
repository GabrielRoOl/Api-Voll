package br.com.med.voll.api.domain.model.consulta;

import br.com.med.voll.api.domain.model.medico.Medico;
import br.com.med.voll.api.dto.DadosAgendamentoConsultaDTO;
import br.com.med.voll.api.infra.exceptions.ValidacaoException;
import br.com.med.voll.api.repositories.ConsultaRepository;
import br.com.med.voll.api.repositories.MedicoRepository;
import br.com.med.voll.api.repositories.PacienteRepository;
import br.com.med.voll.api.validacoes.ValidadorAgendamentoConsulta;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultas {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private List<ValidadorAgendamentoConsulta> validadores;

    @Transactional
    public void agendar(DadosAgendamentoConsultaDTO dados) {
        if (!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Id do paciente informado não existe");
        }
        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Id do médico informado não existe");
        }

        validadores.forEach(v -> v.validar(dados));

        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);
        var consulta = new Consulta(null, medico, paciente, dados.data());

        consultaRepository.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsultaDTO dados) {
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }
        if (dados.especialidade() == null) {
            throw new ValidacaoException("Especialidade é obrigatória, caso médico não for escolhido");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }

}
