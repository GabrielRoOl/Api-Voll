package br.com.med.voll.api.dto;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosPacienteDTO(
        @NotBlank String nome,
        @NotBlank String cpf,
        @NotBlank String telefone,
        @NotNull @Valid DadosEndereco endereco
        ) {
}
