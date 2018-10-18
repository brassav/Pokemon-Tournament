package exceptions;

public class EmptyTournamentException extends Exception{

	public EmptyTournamentException()
	{
		System.out.println("Le tournoi est vide, impossible de supprimer un pokemon");
	}
}
