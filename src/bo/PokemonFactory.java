package bo;

import java.util.ArrayList;
import java.util.Random;

public class PokemonFactory {

	public Pokemon getPokemon(String name)
	{
		int att;
		int pv;
		Random random = new Random();
		
		if (name == null)
			return (null);
		if (name.equalsIgnoreCase("pikachu"))
		{
			pv = 60 + random.nextInt(200 - 60);
			att = 35 + random.nextInt(100 - 35);
			return (new Pikachu(att, pv));
		}
		else if (name.equalsIgnoreCase("dracaufeu"))
		{
			pv = 100 + random.nextInt(250 - 100);
			att = 45 + random.nextInt(110 - 45);
			return (new Dracaufeu(att, pv));
		}
		else if (name.equalsIgnoreCase("mewtwo"))
		{
			pv = 90 + random.nextInt(225 - 90);
			att = 40 + random.nextInt(130 - 40);
			return (new Mewtwo(att, pv));
		}
		else if (name.equalsIgnoreCase("victini"))
		{
			pv = 70 + random.nextInt(200 - 70);
			att = 50 + random.nextInt(110 - 50);
			return (new Victini(att, pv));
		}
		else
			return null;
	}
	
	public ArrayList<Pokemon> getListPokemon(int nb)
	{
		ArrayList<Pokemon> list = new ArrayList<Pokemon>();
		Random random = new Random();
		for (int i = 0; i < nb; i++)
		{
			int nb_rand = random.nextInt(4);
			if (nb_rand == 0)
				list.add(getPokemon("pikachu"));
			else if (nb_rand == 1)
				list.add(getPokemon("dracaufeu"));
			else if (nb_rand == 2)
				list.add(getPokemon("mewtwo"));
			else if (nb_rand == 3)
				list.add(getPokemon("victini"));	
		}
		
		return list;
	}
}
