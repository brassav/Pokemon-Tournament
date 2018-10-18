package exceptions;

import bo.Pokemon;

public class AlreadyRegisterException extends Exception{

	public AlreadyRegisterException(Pokemon pokemon)
	{
		System.out.println("Ce " + pokemon.getName() + " est deja inscrit au tournoi");
	}
}
