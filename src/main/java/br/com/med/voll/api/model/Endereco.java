package br.com.med.voll.api.model;

import br.com.med.voll.api.dto.DadosEndereco;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private String logradouro;
    private String cep;
    private String bairro;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(){}

    public Endereco(DadosEndereco endereco) {
        this.bairro = endereco.bairro();
        this.logradouro = endereco.logradouro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }

    public void atualizarInformacoes(DadosEndereco endereco) {
        if(endereco.bairro() != null)
            this.bairro = endereco.bairro();
        if(endereco.logradouro() != null)
            this.logradouro = endereco.logradouro();
        if(endereco.cep() != null)
            this.cep = endereco.cep();
        if(endereco.numero() != null)
            this.numero = endereco.numero();
        if(endereco.complemento() != null)
            this.complemento = endereco.complemento();
        if(endereco.cidade() != null)
            this.cidade = endereco.cidade();
        if(endereco.uf() != null)
            this.uf = endereco.uf();
    }
}
