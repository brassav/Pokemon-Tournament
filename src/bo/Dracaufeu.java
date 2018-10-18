package bo;

import java.util.Random;

public class Dracaufeu extends Pokemon{

	public Dracaufeu(int vit, int pv) {
		super("Dracaufeu", vit, pv, "Dracaufeuuuuu", "dra...");
		
		Random rand = new Random();
		
		Attack attack;
		if (rand.nextInt(100) < 5)
			attack = new Attack("Lance-Flamme", 5, 100);
		else
			attack = new Attack("Flameche", 15, 75);
		super.setAtt(attack);
		
	}

}
