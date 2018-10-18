package exceptions;

public class FullTournamentException extends Exception{
	
	public FullTournamentException()
	{
		System.out.println("Le tournoi est complet, inscrivez au prochain tournoi");
	}
}
