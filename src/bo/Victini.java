package bo;

import java.util.Random;

public class Victini extends Pokemon{

	public Victini(int vit, int pv) {
		super("Victini", vit, pv, "Viiiiiictini", "vi..");
		
		Random rand = new Random();
		
		Attack attack;
		if (rand.nextInt(100) < 5)
			attack = new Attack("Surchauffe", 5, 120);
		else
			attack = new Attack("Vive-Attaque", 15, 65);
		super.setAtt(attack);
	}

}
