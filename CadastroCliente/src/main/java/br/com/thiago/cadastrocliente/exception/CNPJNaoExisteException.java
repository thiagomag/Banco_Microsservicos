package br.com.thiago.cadastrocliente.exception;

public class CNPJNaoExisteException extends RuntimeException {
    public CNPJNaoExisteException() {
        super("CNPJ buscado não existe.");
    }
}
