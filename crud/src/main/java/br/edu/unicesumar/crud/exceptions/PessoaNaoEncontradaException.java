package br.edu.unicesumar.crud.exceptions;

public class PessoaNaoEncontradaException extends Exception{
	
	public PessoaNaoEncontradaException(){
		super("Não existe nenhuma pessoa com o id ");
	}
}
