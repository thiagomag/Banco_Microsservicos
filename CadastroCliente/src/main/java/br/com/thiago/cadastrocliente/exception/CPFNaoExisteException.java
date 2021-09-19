package br.com.thiago.cadastrocliente.exception;

public class CPFNaoExisteException extends RuntimeException {
    public CPFNaoExisteException() {
        super("CPF buscado não existe.");
    }
}
