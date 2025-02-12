package br.com.med.voll.api.dto;


import br.com.med.voll.api.enums.Especialidade;


public record DadosCadastroMedico(String nome, String email, Especialidade especialidade, DadosEndereco endereco) {
}

