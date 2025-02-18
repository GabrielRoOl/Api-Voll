package br.com.med.voll.api.dto;


import br.com.med.voll.api.enums.Especialidade;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record DadosCadastroMedico(
        @NotBlank String nome,
        @NotBlank @Email @Column(unique = true) String email,
        @NotBlank @Pattern(regexp = "\\d{4,6}") String crm,
        @NotNull @Enumerated Especialidade especialidade,
        @NotNull @Valid DadosEndereco endereco
) {
}
