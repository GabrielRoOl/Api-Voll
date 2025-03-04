package br.com.med.voll.api.dto;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPacienteDTO(
        @NotBlank String nome,
        @NotBlank @Column(unique = true, nullable = false) String cpf,
        @NotBlank String telefone,
        @NotNull @Valid DadosEndereco endereco
        ) {
}
