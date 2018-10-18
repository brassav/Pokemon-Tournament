package exceptions;

public class NbPokemonException extends Exception{
	public NbPokemonException()
	{
		System.out.println("Pour le bon déroulement du tournoi,"
				+ " le nombre de Pokemon doit etre une puissance de 2"
				+ " (2, 4, 8, 16,...)");
	}
}
