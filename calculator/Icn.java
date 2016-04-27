package calculator;

public enum Icn{
	D0				(0),
	D1				(1),
	D2				(2),
	D3				(3),
	D4				(4),
	D5				(5),
	D6				(6),
	D7				(7),
	D8				(8),
	D9				(9),
	CLEAR			(10),
	PLUSMINUS 		(11),
	PERCENT			(12),
	DIVISION		(13),
	MULTIPLICATION	(14),
	MINUS			(15),
	PLUS			(16),
	EQUAL			(17),
	COMMA			(18),
	LEFTPAR			(19),
	RIGHTPAR		(20),
	MC				(21),
	MPLUS			(22),
	MMINUS			(23),
	MRECALL			(24),
	XSQUARE			(25),
	XCUBIC			(26),
	XPOWY			(27),
	EPOWX			(28),
	TENPOWX			(29),
	ROOT			(30),
	TWOROOTX		(31),
	THREEROOTX		(32),
	LN				(33),
	LOG10			(34),
	XEXCL			(35),
	SIN				(36),
	COS				(37),
	TAN				(38),
	E				(39),
	EE				(40),
	RAD				(41),
	SINH			(42),
	COSH			(43),
	TANH			(44),
	crap			(45),
	PI				(46),
	RAND			(47),
	ROOTX			(48),
	XROOTY			(49),
	SECOND			(50),
	INVERT			(51);

	private final int index;
    
	Icn(int index) {
        this.index = index;
    }

	int id() {
		return index;
	}

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java IconEnum <index>");
            System.exit(-1);
        }
    }
}