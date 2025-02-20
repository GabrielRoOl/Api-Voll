package br.com.med.voll.api.dto;

import br.com.med.voll.api.model.Endereco;
import jakarta.validation.constraints.NotBlank;

public record DadosPacienteDTO(
        @NotBlank String nome,
        @NotBlank String cpf,
        @NotBlank String telefone,
        @NotBlank Endereco endereco
        ) {
}
