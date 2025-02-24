package br.com.med.voll.api.dto;

import br.com.med.voll.api.model.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaMedico(
        @NotNull Long id,
        String name,
        String telefone,
        DadosEndereco endereco) {
}
