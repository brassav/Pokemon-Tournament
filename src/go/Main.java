package go;

import java.util.ArrayList;

import bo.Dracaufeu;
import bo.Mewtwo;
import bo.Pikachu;
import bo.Pokemon;
import bo.Tournament;
import bo.Victini;
import exceptions.AlreadyRegisterException;
import exceptions.FullTournamentException;
import exceptions.MatchErrorException;
import exceptions.NbPokemonException;

public class Main {

	public static void main(String[] args) {
		Tournament tournoi = null;
		
		//utile pour la suite
		ArrayList<Pokemon> listPokemon = new ArrayList<Pokemon>();
		try {
			 tournoi = new Tournament(4);
		} catch (NbPokemonException e) {
			System.exit(1);
		}
		
		Dracaufeu dracaufeu = new Dracaufeu(100, 150);
		Victini victini = new Victini(75, 125);
		Pikachu pikachu = new Pikachu(60, 125);
		Mewtwo mewtwo = new Mewtwo(100, 100);
		Pikachu pikachu2 = new Pikachu(55, 130);
		
		listPokemon.add(dracaufeu);
		listPokemon.add(victini);
		listPokemon.add(pikachu);
		listPokemon.add(mewtwo);
	//	listPokemon.add(pikachu2);
		
		for (Pokemon pokemon : listPokemon)
		{
			try {
				tournoi.add(pokemon);
			} catch (FullTournamentException | AlreadyRegisterException e) {}
		}
		
		try {
			tournoi.allRound();
		} catch (NbPokemonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
