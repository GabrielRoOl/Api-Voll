package br.com.med.voll.api.domain.model.endereco;

import br.com.med.voll.api.dto.DadosEndereco;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Embeddable
@Getter
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String cep;
    private String bairro;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco() {
    }

    public Endereco(DadosEndereco endereco) {
        this.bairro = endereco.bairro();
        this.logradouro = endereco.logradouro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
//        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }

    public void atualizarInformacoes(DadosEndereco endereco) {
        if (endereco.bairro() != null)
            this.bairro = endereco.bairro();
        if (endereco.logradouro() != null)
            this.logradouro = endereco.logradouro();
        if (endereco.cep() != null)
            this.cep = endereco.cep();
        if (endereco.numero() != null)
            this.numero = endereco.numero();
        if (endereco.complemento() != null)
            this.complemento = endereco.complemento();
//        if (endereco.cidade() != null)
//            this.cidade = endereco.cidade();
        if (endereco.uf() != null)
            this.uf = endereco.uf();
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
