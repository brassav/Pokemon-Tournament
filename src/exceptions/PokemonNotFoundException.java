package exceptions;

import bo.Pokemon;

public class PokemonNotFoundException extends Exception{

	public PokemonNotFoundException(Pokemon pokemon)
	{
		System.out.println("Ce " + pokemon.getName() + "n est pas inscrit au tournoi");
	}
}
