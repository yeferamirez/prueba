package exceptions;

public class RouletteException extends Exception {

	private static final long serialVersionUID = 1L;
	 static String NOTFOUND="La ruleta no fue encontrada";	
	public RouletteException(String error) {		
		super(NOTFOUND);
	}
}
