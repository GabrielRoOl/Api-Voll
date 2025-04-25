package br.com.med.voll.api.infra.exceptions;

public class ValidacaoException extends RuntimeException {

    public ValidacaoException(String msg) {
        super(msg);
    }
}