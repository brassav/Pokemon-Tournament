package go;

import java.util.ArrayList;

import bo.Dracaufeu;
import bo.Mewtwo;
import bo.Pikachu;
import bo.Pokemon;
import bo.PokemonFactory;
import bo.Tournament;
import bo.Victini;
import exceptions.AlreadyRegisterException;
import exceptions.FullTournamentException;
import exceptions.MatchErrorException;
import exceptions.NbPokemonException;

public class Main {

	public static void main(String[] args) {
		Tournament tournoi = null;
		PokemonFactory factory = new PokemonFactory();
		
		ArrayList<Pokemon> listPokemon = new ArrayList<Pokemon>();
		try {
			/*
			 * Si true, 5 points de degats sont infligés a chaque tour
			 * a cause de la grele
			 */
			 tournoi = new Tournament(16, false);
		} catch (NbPokemonException e) {
			System.exit(1);
		}
		
		Dracaufeu dracaufeu = new Dracaufeu(100, 150);
		Victini victini = new Victini(75, 125);
		Pikachu pikachu = new Pikachu(60, 125);
		
		listPokemon.add(dracaufeu);
		listPokemon.add(victini);
		listPokemon.add(pikachu);
		listPokemon.add(factory.getPokemon("mewtwo"));
		listPokemon.addAll(factory.getListPokemon(12));
		for (Pokemon pokemon : listPokemon)
		{
			try {
				tournoi.add(pokemon);
			} catch (FullTournamentException | AlreadyRegisterException | NullPointerException e) {}
		}
		
		try {
			tournoi.allRound();
		} catch (NbPokemonException e) {}
		
/*		System.out.println();
		try {
			tournoi.round();
			System.out.println();
			tournoi.round();
			
			System.out.println();
			tournoi.round();
		} catch (MatchErrorException | NbPokemonException e) {}
		*/

		
		System.out.println();
		tournoi.listTournament();
						
	}

}
