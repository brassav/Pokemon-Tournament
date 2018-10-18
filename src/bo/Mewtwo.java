package bo;

import java.util.Random;

public class Mewtwo extends Pokemon{

	public Mewtwo(int vit, int pv) {
		super("Mewtwo", vit, pv, "Mewwwwwtwoooo", "mewtwo...");
		
		Random rand = new Random();
		
		Attack attack;
		if (rand.nextInt(100) < 5)
			attack = new Attack("Rafale-Psy", 5, 80);
		else
			attack = new Attack("Psyko", 15, 65);
		super.setAtt(attack);
	}

}
