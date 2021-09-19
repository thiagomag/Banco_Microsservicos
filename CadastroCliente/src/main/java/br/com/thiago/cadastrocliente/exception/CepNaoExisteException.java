package br.com.thiago.cadastrocliente.exception;

public class CepNaoExisteException extends RuntimeException {
    public CepNaoExisteException() {
        super("O cep pesquisado não existe");
    }
}
