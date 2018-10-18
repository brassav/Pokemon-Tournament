package exceptions;

public class MatchErrorException extends Exception{
	
	public MatchErrorException()
	{
		System.out.println("Impossible de lancer ce match");
	}
}
