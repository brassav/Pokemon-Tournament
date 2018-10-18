package bo;

public class Attack {
	private String name;
	private int echecCritique;
	private int attack;
	
	public Attack(String name, int echecCritique, int attack)
	{
		this.name = name;
		this.echecCritique = echecCritique;
		this.attack = attack;
	}
	public String getName() {
		return name;
	}

	public int getEchecCritique() {
		return echecCritique;
	}
	public int getAttack() {
		return attack;
	}
	
	
}
