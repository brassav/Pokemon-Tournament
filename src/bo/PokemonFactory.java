package bo;

import java.util.ArrayList;
import java.util.Random;

public class PokemonFactory {

	public Pokemon getPokemon(String name)
	{
		int vit;
		int pv;
		Random random = new Random();
		
		if (name == null)
			return (null);
		if (name.equalsIgnoreCase("pikachu"))
		{
			pv = 60 + random.nextInt(250 - 60);
			vit = 75 + random.nextInt(200 - 75);
			return (new Pikachu(vit, pv));
		}
		else if (name.equalsIgnoreCase("dracaufeu"))
		{
			pv = 100 + random.nextInt(300 - 100);
			vit = 45 + random.nextInt(160 - 45);
			return (new Dracaufeu(vit, pv));
		}
		else if (name.equalsIgnoreCase("mewtwo"))
		{
			pv = 90 + random.nextInt(275 - 90);
			vit = 40 + random.nextInt(240 - 40);
			return (new Mewtwo(vit, pv));
		}
		else if (name.equalsIgnoreCase("victini"))
		{
			pv = 70 + random.nextInt(250 - 70);
			vit = 65 + random.nextInt(220 - 65);
			return (new Victini(vit, pv));
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
