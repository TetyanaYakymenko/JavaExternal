package ua.com.project2;

public enum PunctuationMark {

	EXCLAMATION('!'),
	DOT('.'),
	QUESTION('?'),
	NEWLINE('\n'),
	CARRET('\r'),
	TWO_DOT('‥'),
	HORIZONTAL_ELLIPSIS('…'),
	INTERROBANG('\u2048'),
	DISAMBIGUATION('\u2047'),
	LBRACKETS('('),
	RBRACKETS(')'),
	COMMA(','),
	SPACE(' '), 
	COLON(':'),
	SEMICOLON(';'),
	GDASH('—'), 
	GIANTDASH('―'),
	QUOTATION('"'),
	LEFT_POINTING_DOUBLE_ANGLE_QUOTATION('«'),
	RIGHT_POINTING_DOUBLE_ANGLE_QUOTATION('»'), 
	LEFT_SINGLE_QUOTATION('‘'),
	RIGHT_SINGLE_QUOTATION('’'),
	SINGLE_LOW_9_QUOTATION_MARK('‚'),
	SINGLE_HIGH_REVERSED_9_QUOTATION('‛'),
	LEFT_DOUBLE_QUOTATION('“'),
	RIGHT_DOUBLE_QUOTATION('”'),
	DOUBLE_LOW_9_QUOTATION('„'),
	DOUBLE_HIGH_REVERSED_9_QUOTATION('‟');
	

	private char mark;

	private PunctuationMark(char mark) {
		this.mark = mark;
	}

	public char getMark() {
		return this.mark;
	}
}
