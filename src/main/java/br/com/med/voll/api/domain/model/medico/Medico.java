package br.com.med.voll.api.domain.model;

import br.com.med.voll.api.domain.model.endereco.Endereco;
import br.com.med.voll.api.dto.DadosAtualizaMedico;
import br.com.med.voll.api.dto.DadosCadastroMedico;
import br.com.med.voll.api.enums.Especialidade;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Medico")
@Table(name = "tb_medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String telefone;

    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Medico(){}

    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.name = dados.nome();
        this.crm = dados.crm();
        this.email = dados.email();
        this.especialidade = dados.especialidade();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void atualizarInformacoes(@Valid DadosAtualizaMedico dados) {
        if(dados.name() != null)
            this.name = dados.name();

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
