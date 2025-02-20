package br.com.med.voll.api.dto;

import br.com.med.voll.api.enums.Especialidade;
import br.com.med.voll.api.model.Medico;

public record DadosListagemMedico(String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getName(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
