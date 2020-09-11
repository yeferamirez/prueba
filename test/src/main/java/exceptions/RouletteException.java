package exceptions;

public class RouletteException extends Exception {

	private static final long serialVersionUID = 1L;
	 static String NOTFOUND="Valor no encontrado";	
	public RouletteException(String e) {		
		e=NOTFOUND;
	}
}
