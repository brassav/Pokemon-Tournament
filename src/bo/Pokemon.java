package bo;

public abstract class Pokemon {
	private String name;
	private int att;
	private int pv;
	private String shoutVictory;
	private String shoutLose;
	
	Pokemon(String name, int att, int pv, String shoutVictory, String shoutLose)
	{
		this.name = name;
		this.att = att;
		this.pv = pv;
		this.shoutVictory = shoutVictory;
		this.shoutLose = shoutLose;
	}
	
	public String getName() {
		return name;
	}

	public int getAtt() {
		return att;
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

	@Override
	public String toString()
	{
		return (name + "/" + att + "att/" + pv + "pv");
	}
}
