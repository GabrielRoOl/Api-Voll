package br.com.med.voll.api.dto;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DadosPacienteDTO(
        @NotBlank String nome,
        @NotBlank @Column(unique = true) String cpf,
        @NotBlank String telefone,
        @NotNull @Valid DadosEndereco endereco
        ) {
}
