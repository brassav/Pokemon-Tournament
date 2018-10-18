package bo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import exceptions.AlreadyRegisterException;
import exceptions.EmptyTournamentException;
import exceptions.FullTournamentException;
import exceptions.MatchErrorException;
import exceptions.NbPokemonException;

public class Tournament {
	private int nbPokemonMax;
	private ArrayList<Pokemon> alPokemon;
	
	public Tournament(int nbPokemonMax) throws NbPokemonException
	{
		if ( Long.bitCount(nbPokemonMax) != 1 || nbPokemonMax < 2)
			throw new NbPokemonException();
		else
		{
			this.nbPokemonMax = nbPokemonMax;
			alPokemon = new ArrayList<Pokemon>();
		}
	}

	public int getNbPokemonMax() {
		return nbPokemonMax;
	}

	public ArrayList<Pokemon> getAlPokemon() {
		return alPokemon;
	}
	
	public void add(Pokemon pokemon) throws FullTournamentException, AlreadyRegisterException
	{
		if (alPokemon.size() >= nbPokemonMax)
			throw new FullTournamentException();
		else if (alPokemon.contains(pokemon))
			throw new AlreadyRegisterException(pokemon);
		else
		{
			alPokemon.add(pokemon);
			System.out.println(pokemon.getName() + " a bien ete inscrit au tournoi");
		}
	}

	public void remove(Pokemon pokemon) throws EmptyTournamentException
	{
		if (alPokemon.isEmpty())
			throw new EmptyTournamentException();
		else
		{
			alPokemon.remove(pokemon);
			System.out.println(pokemon.getName() + " a bien ete desinscrit du tournoi");
		}
	}
	
	/*
	 * In private because i don't want the user can launch a random fight
	 * It will broke the tournament tree
	 */
	private void fight(Pokemon firstPokemon, Pokemon secondPokemon)
	{
		Random random = new Random();
		boolean turn = random.nextBoolean();

		if (turn)
		{
			Pokemon tmp = firstPokemon;
			firstPokemon = secondPokemon;
			secondPokemon = tmp;
		}
		
		int lifeFirstPokemon = firstPokemon.getPv();
		int lifeSecondPokemon = secondPokemon.getPv();
		
		System.out.println("Le combat opposant " + firstPokemon.toString() 
		+ " et " + secondPokemon.toString() + " va commencer");

		while (lifeFirstPokemon > 0 && lifeSecondPokemon > 0)
		{
			lifeSecondPokemon -= firstPokemon.getAtt();
			System.out.println('\t' + firstPokemon.getName() 
			+ " a inflige " + firstPokemon.getAtt() + " degat(s) a " 
			+ secondPokemon.getName() + " a qui il ne reste plus que " 
			+ (lifeSecondPokemon < 0 ? 0 : lifeSecondPokemon) + " pv");
			
			if (lifeSecondPokemon > 0)
			{
				lifeFirstPokemon -= secondPokemon.getAtt();
				System.out.println('\t' + secondPokemon.getName() 
				+ " a inflige " + secondPokemon.getAtt() + " degat(s) a " 
				+ firstPokemon.getName() + " a qui il ne reste plus que " 
				+ (lifeFirstPokemon < 0 ? 0 : lifeFirstPokemon) + " pv");
			}
		}
		if (lifeFirstPokemon <= 0)
		{
			System.out.println('\t' + firstPokemon.getShoutLose());
			System.out.println('\t' + secondPokemon.getShoutVictory());
			System.out.println(firstPokemon.getName() 
			+ " est hors combat " + secondPokemon.getName() + " remporte le match");
			alPokemon.remove(firstPokemon);
			/*try {
				remove(firstPokemon);
			} catch (EmptyTournamentException e) {}*/
		}
		else
		{
			System.out.println('\t' + secondPokemon.getShoutLose());
			System.out.println('\t' + firstPokemon.getShoutVictory());
			System.out.println(secondPokemon.getName() 
			+ " est hors combat " + firstPokemon.getName() + " remporte le match");
			alPokemon.remove(secondPokemon);
			/*try {
			remove(secondPokemon);
		} catch (EmptyTournamentException e) {}*/
		}
	}
	
	public void round() throws MatchErrorException, NbPokemonException
	{
		if ( Long.bitCount(nbPokemonMax) != 1 || nbPokemonMax < 2)
			throw new NbPokemonException();
		else
		{
			if (alPokemon.size() < 2)
				throw new MatchErrorException();
			for (int i = 0; i < alPokemon.size(); i++)
			{
				Pokemon firstPokemon = alPokemon.get(i);
				Pokemon secondPokemon = alPokemon.get(i + 1);
				fight(firstPokemon, secondPokemon);
			}
			if (alPokemon.size() == 1)
			{
				System.out.println(alPokemon.get(0).getName() + " est declaré vainqueur de ce tournoi!");
				System.out.println(alPokemon.get(0).getShoutVictory());
				alPokemon.remove(0);
			}
		/*Iterator<Pokemon> it = alPokemon.iterator();
		while (it.hasNext())
		{
			Pokemon firstPokemon = it.next();
			Pokemon secondPokemon = it.next();
			fight(firstPokemon, secondPokemon);
		}*/
		}
	}
	
	public void allRound() throws NbPokemonException
	{
		if ( Long.bitCount(nbPokemonMax) != 1 || nbPokemonMax < 2)
			throw new NbPokemonException();
		else
		{
			while (!alPokemon.isEmpty())
			{
				try {
					round();
				} catch (MatchErrorException e) {
				}
			}
		}
	}
	
	public void listTournament()
	{
		for (Pokemon pokemon : alPokemon)
		{
			System.out.println(pokemon.getName() + " est toujours dans le tournoi");
		}
	}
}
