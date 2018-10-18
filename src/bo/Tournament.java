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
	private boolean weatherProblem;
	
	public Tournament(int nbPokemonMax, boolean weatherProblem) throws NbPokemonException
	{
		if ( Long.bitCount(nbPokemonMax) != 1 || nbPokemonMax < 2)
			throw new NbPokemonException();
		else
		{
			this.nbPokemonMax = nbPokemonMax;
			this.weatherProblem = weatherProblem;
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
		else if (pokemon == null)
			throw new NullPointerException();
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

		if (secondPokemon.getVit() > firstPokemon.getVit())
		{
			Pokemon tmp = firstPokemon;
			firstPokemon = secondPokemon;
			secondPokemon = tmp;
		}
		System.out.println("Le combat opposant " + firstPokemon.toString() 
		+ " et " + secondPokemon.toString() + " va commencer");
		
		System.out.println(firstPokemon.getName() + " a " 
		+ firstPokemon.getVit() + " de vitesse, alors que " 
		+ secondPokemon.getName() + " a " + secondPokemon.getVit() 
		+ " de vitesse, il jouera donc en premier");
		
		int lifeFirstPokemon = firstPokemon.getPv();
		int lifeSecondPokemon = secondPokemon.getPv();

		while (lifeFirstPokemon > 0 && lifeSecondPokemon > 0)
		{
			if (random.nextInt(100) < firstPokemon.getAtt().getEchecCritique())
				System.out.println('\t' + firstPokemon.getName() + " a rate sa cible");
			else
			{
				lifeSecondPokemon -= firstPokemon.getAtt().getAttack();
				System.out.println('\t' + firstPokemon.getName() + " attaque " + firstPokemon.getAtt().getName()
				+ ", il inflige " + firstPokemon.getAtt().getAttack() + " degat(s) a " 
				+ secondPokemon.getName() + " a qui il ne reste plus que " 
				+ (lifeSecondPokemon < 0 ? 0 : lifeSecondPokemon) + " pv");
			}
			if (weatherProblem)
			{
				lifeSecondPokemon -= 5;
				lifeFirstPokemon -= 5;
				System.out.println('\t' + firstPokemon.getName() 
				+ " est frappé par la grele, il lui reste " 
				+ (lifeFirstPokemon < 0 ? 0 : lifeFirstPokemon) + " pv");
				
				System.out.println('\t' + secondPokemon.getName() 
				+ " est frappé par la grele, il lui reste " 
				+ (lifeSecondPokemon < 0 ? 0 : lifeSecondPokemon) + " pv");
			}
			if (lifeSecondPokemon > 0)
			{
				if (random.nextInt(100) < secondPokemon.getAtt().getEchecCritique())
					System.out.println('\t' + secondPokemon.getName() + " a rate sa cible");
				else
				{
					lifeFirstPokemon -= secondPokemon.getAtt().getAttack();
					System.out.println('\t' + secondPokemon.getName() + " attaque " + secondPokemon.getAtt().getName()
					+ ", il inflige " + secondPokemon.getAtt().getAttack() + " degat(s) a " 
					+ firstPokemon.getName() + " a qui il ne reste plus que " 
					+ (lifeFirstPokemon < 0 ? 0 : lifeFirstPokemon) + " pv");
				}
				if (weatherProblem)
				{
					lifeSecondPokemon -= 5;
					lifeFirstPokemon -= 5;
					System.out.println('\t' + firstPokemon.getName() 
					+ " est frappé par la grele, il lui reste " 
					+ (lifeFirstPokemon < 0 ? 0 : lifeFirstPokemon) + " pv");
					System.out.println('\t' + secondPokemon.getName() 
					+ " est frappé par la grele, il lui reste " 
					+ (lifeSecondPokemon < 0 ? 0 : lifeSecondPokemon) + " pv");
				}
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
	
	/*
	 * Possibilité pour l'utilisateur de lancer l'execution d'un round manuellement
	 * Utile dans le cas ou l utilisateur souhaiterai pouvoir afficher la liste des 
	 * pokemon restant a la fin d'un round
	 */
	public void round() throws MatchErrorException, NbPokemonException
	{
		if ( Long.bitCount(nbPokemonMax) != 1 || nbPokemonMax < 2 ||
				Long.bitCount(alPokemon.size()) != 1 || alPokemon.size() < 2 )

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
		if ( Long.bitCount(nbPokemonMax) != 1 || nbPokemonMax < 2 ||
				Long.bitCount(alPokemon.size()) != 1 || alPokemon.size() < 2 )
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
			System.out.println(pokemon.toString() + " est toujours dans le tournoi");
		}
	}
}
