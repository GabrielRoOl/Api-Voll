package br.com.med.voll.api.dto;

import br.com.med.voll.api.enums.Especialidade;
import br.com.med.voll.api.model.Medico;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosListagemMedico(String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getName(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
