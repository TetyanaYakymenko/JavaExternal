package exceptions;

public class IncorrectInputException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public IncorrectInputException(String string) {
		super(string);
	}

}
