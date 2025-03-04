package br.com.med.voll.api.dto;

import br.com.med.voll.api.enums.Especialidade;
import br.com.med.voll.api.domain.model.Endereco;
import br.com.med.voll.api.domain.model.Medico;

public record DadosDetalhamentoMedicoDTO(Long id, String name, String email, String telefone, String crm, Especialidade especialidade,
                                         Endereco endereco) {

    public DadosDetalhamentoMedicoDTO(Medico medico){
        this(medico.getId(), medico.getName(), medico.getEmail(), medico.getTelefone(), medico.getCrm(),
                medico.getEspecialidade(), medico.getEndereco());
    }
}
