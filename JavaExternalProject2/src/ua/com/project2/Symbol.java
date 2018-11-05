package ua.com.project2;

public enum Symbol {
	NUMBERSIGN('#'),
	DOLLAR('$'), 
	PERCENT('%'),
	AMPERSAND('&'),
	ASTERISK('*'), 
	PLUS('+'),
	MINUS('-'),
	SLASH('/'),
	LESSTHAN('<'), 
	EQUAL('='),
	GREATERTHAN('>'),
	LSQUAREBRACKETS('['),
	RSQUAREBRACKETS(']'),
	CARET('^'),
	UNDERSCORE('_'), 
	GRAVIS('`'), 
	LCURLYBRACKETS('{'),
	VERTICALBAR('|'),
	RCURLYBRACKETS('}'),
	TILDE('~'),
	DASH('‒'),
	MULTIPLICATION('×'),
	PER_MILLE('‰'),
	PER_TEN_THOUSAND('‱'),
	SINGLE_LEFT_POINTING_ANGLE_QUOTATION('‹'),
	SINGLE_RIGHT_POINTING_ANGLE_QUOTATION('›'),
	BACKSLASH('\\');
	
	private char symbol;
	private Symbol(char symbol) {
		this.symbol = symbol;
	}
	
	public char getSymbol() {
		return this.symbol;
	}
}
