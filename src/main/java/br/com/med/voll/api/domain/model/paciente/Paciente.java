package br.com.med.voll.api.domain.model;

import br.com.med.voll.api.domain.model.endereco.Endereco;
import br.com.med.voll.api.dto.DadosAtualizaPaciente;
import br.com.med.voll.api.dto.DadosCadastroPacienteDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;

@Entity
@Table(name = "tb_paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;

    @Embedded
    private Endereco endereco;

    @Column(nullable = false)
    private boolean ativo = true;

    public Paciente(){}

    public Paciente(boolean ativo, String cpf, Endereco endereco, Long id, String nome, String telefone) {
        this.ativo = ativo;
        this.cpf = cpf;
        this.endereco = endereco;
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Paciente(DadosCadastroPacienteDTO dados) {
        this.cpf = dados.cpf();
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void atualizaDadosPaciente(@Valid DadosAtualizaPaciente dados) {
        if(dados.nome() != null)
            this.nome = dados.nome();

        if(dados.telefone() != null)
            this.telefone = dados.telefone();

        if(dados.endereco() != null)
            this.endereco.atualizarInformacoes(dados.endereco());
    }

    public void excluir() {
        this.ativo = false;
    }

    public void ativa() {
        this.ativo = true;
    }
}
