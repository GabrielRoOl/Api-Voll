package br.com.med.voll.api.dto;

import br.com.med.voll.api.domain.model.endereco.Endereco;
import br.com.med.voll.api.domain.model.paciente.Paciente;

public record DadosDetalhamentoPacienteDTO(Long id, String nome, String cpf, String telefone, Endereco endereco) {
    public DadosDetalhamentoPacienteDTO(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }
}
