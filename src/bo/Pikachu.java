package bo;

import java.util.Random;

public class Pikachu extends Pokemon{

	public Pikachu(int vit, int pv) {
		super("Pikachu", vit, pv, "Piiiiikaaaaaaaaachuuuuuuuuuu", "pika...");
		
		Random rand = new Random();
		
		Attack attack;
		if (rand.nextInt(100) < 5)
			attack = new Attack("Tonnere", 5, 110);
		else
			attack = new Attack("Eclair", 20, 70);
		super.setAtt(attack);
	}

}
