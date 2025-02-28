package br.com.med.voll.api.dto;

import br.com.med.voll.api.model.Endereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaPaciente(
        @NotNull Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
