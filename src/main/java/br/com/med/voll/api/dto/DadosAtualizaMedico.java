package br.com.med.voll.api.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaMedico(
        @NotNull Long id,
        String name,
        String telefone,
        DadosEndereco endereco) {
}
