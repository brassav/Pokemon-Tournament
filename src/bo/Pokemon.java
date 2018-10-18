package bo;

public abstract class Pokemon {
	private String name;
	private int vit;
	private int pv;
	private String shoutVictory;
	private String shoutLose;
	private Attack att;
	
	Pokemon(String name, int vit, int pv, String shoutVictory, String shoutLose)
	{
		this.name = name;
		this.vit = vit;
		this.pv = pv;
		this.shoutVictory = shoutVictory;
		this.shoutLose = shoutLose;
	}
	
	public String getName() {
		return name;
	}

	public int getVit() {
		return vit;
	}

	public int getPv() {
		return pv;
	}

	public String getShoutVictory() {
		return shoutVictory;
	}

	public String getShoutLose() {
		return shoutLose;
	}
	
	public Attack getAtt() {
		return att;
	}
	
	protected void setAtt(Attack att) {
		this.att = att;
	}

	@Override
	public String toString()
	{
		return (name + "/" + vit + "vit/" + pv + "pv");
	}
}
