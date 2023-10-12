package src.Codigo;

public interface AnalizadorConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int Do = 5;
  /** RegularExpression Id. */
  int While = 6;
  /** RegularExpression Id. */
  int LBRACE = 7;
  /** RegularExpression Id. */
  int RBRACE = 8;
  /** RegularExpression Id. */
  int COMA = 9;
  /** RegularExpression Id. */
  int LKEY = 10;
  /** RegularExpression Id. */
  int RKEY = 11;
  /** RegularExpression Id. */
  int SEMICOLON = 12;
  /** RegularExpression Id. */
  int ASSIGN = 13;
  /** RegularExpression Id. */
  int LT = 14;
  /** RegularExpression Id. */
  int GT = 15;
  /** RegularExpression Id. */
  int EQ = 16;
  /** RegularExpression Id. */
  int NE2 = 17;
  /** RegularExpression Id. */
  int NE = 18;
  /** RegularExpression Id. */
  int LE = 19;
  /** RegularExpression Id. */
  int GE = 20;
  /** RegularExpression Id. */
  int OR = 21;
  /** RegularExpression Id. */
  int AND = 22;
  /** RegularExpression Id. */
  int PLUS = 23;
  /** RegularExpression Id. */
  int MINUS = 24;
  /** RegularExpression Id. */
  int STAR = 25;
  /** RegularExpression Id. */
  int SLASH = 26;
  /** RegularExpression Id. */
  int VARNUM = 27;
  /** RegularExpression Id. */
  int VARCAD = 28;
  /** RegularExpression Id. */
  int NUM = 29;
  /** RegularExpression Id. */
  int INTEGER_LITERAL = 30;
  /** RegularExpression Id. */
  int FLOATING_POINT_LITERAL = 31;
  /** RegularExpression Id. */
  int EXPONENT = 32;
  /** RegularExpression Id. */
  int STRING_LITERAL = 33;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\t\"",
    "\"Do\"",
    "\"while\"",
    "\"(\"",
    "\")\"",
    "\",\"",
    "\"{\"",
    "\"}\"",
    "\";\"",
    "\"=\"",
    "\"<\"",
    "\">\"",
    "\"==\"",
    "\"!\"",
    "\"!=\"",
    "\"<=\"",
    "\">=\"",
    "\"||\"",
    "\"&&\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "<VARNUM>",
    "<VARCAD>",
    "<NUM>",
    "<INTEGER_LITERAL>",
    "<FLOATING_POINT_LITERAL>",
    "<EXPONENT>",
    "<STRING_LITERAL>",
  };

}
