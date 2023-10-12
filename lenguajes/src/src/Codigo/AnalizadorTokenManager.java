package src.Codigo;

public class AnalizadorTokenManager implements AnalizadorConstants
{
    java.util.List<Token> listaToken=new java.util.LinkedList<Token>();
    void CommonTokenAction(Token t){
        listaToken.add(t);
    }
    public java.util.List<Token> getListaToken(){
        return listaToken;
    }

  public  java.io.PrintStream debugStream = System.out;
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 17;
         return jjMoveStringLiteralDfa1_0(0x40000L);
      case 38:
         return jjMoveStringLiteralDfa1_0(0x400000L);
      case 40:
         return jjStopAtPos(0, 7);
      case 41:
         return jjStopAtPos(0, 8);
      case 42:
         return jjStopAtPos(0, 25);
      case 43:
         return jjStopAtPos(0, 23);
      case 44:
         return jjStopAtPos(0, 9);
      case 45:
         return jjStopAtPos(0, 24);
      case 47:
         return jjStopAtPos(0, 26);
      case 59:
         return jjStopAtPos(0, 12);
      case 60:
         jjmatchedKind = 14;
         return jjMoveStringLiteralDfa1_0(0x80000L);
      case 61:
         jjmatchedKind = 13;
         return jjMoveStringLiteralDfa1_0(0x10000L);
      case 62:
         jjmatchedKind = 15;
         return jjMoveStringLiteralDfa1_0(0x100000L);
      case 68:
         return jjMoveStringLiteralDfa1_0(0x20L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x40L);
      case 123:
         return jjStopAtPos(0, 10);
      case 124:
         return jjMoveStringLiteralDfa1_0(0x200000L);
      case 125:
         return jjStopAtPos(0, 11);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active0 & 0x400000L) != 0L)
            return jjStopAtPos(1, 22);
         break;
      case 61:
         if ((active0 & 0x10000L) != 0L)
            return jjStopAtPos(1, 16);
         else if ((active0 & 0x40000L) != 0L)
            return jjStopAtPos(1, 18);
         else if ((active0 & 0x80000L) != 0L)
            return jjStopAtPos(1, 19);
         else if ((active0 & 0x100000L) != 0L)
            return jjStopAtPos(1, 20);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x40L);
      case 111:
         if ((active0 & 0x20L) != 0L)
            return jjStopAtPos(1, 5);
         break;
      case 124:
         if ((active0 & 0x200000L) != 0L)
            return jjStopAtPos(1, 21);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x40L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x40L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x40L) != 0L)
            return jjStopAtPos(4, 6);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 45;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 29)
                        kind = 29;
                     jjCheckNAddStates(0, 9);
                  }
                  else if (curChar == 46)
                     jjCheckNAddTwoStates(14, 18);
                  else if (curChar == 34)
                     jjCheckNAddStates(10, 12);
                  else if (curChar == 36)
                     jjCheckNAdd(3);
                  else if (curChar == 35)
                     jjCheckNAdd(1);
                  break;
               case 1:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 27)
                     kind = 27;
                  jjCheckNAdd(1);
                  break;
               case 2:
                  if (curChar == 36)
                     jjCheckNAdd(3);
                  break;
               case 3:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 28)
                     kind = 28;
                  jjCheckNAdd(3);
                  break;
               case 4:
                  if (curChar == 34)
                     jjCheckNAddStates(10, 12);
                  break;
               case 5:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                     jjCheckNAddStates(10, 12);
                  break;
               case 7:
                  if ((0x8400000000L & l) != 0L)
                     jjCheckNAddStates(10, 12);
                  break;
               case 8:
                  if (curChar == 34 && kind > 33)
                     kind = 33;
                  break;
               case 9:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(13, 16);
                  break;
               case 10:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(10, 12);
                  break;
               case 11:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 12;
                  break;
               case 12:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAdd(10);
                  break;
               case 13:
                  if (curChar == 46)
                     jjCheckNAddTwoStates(14, 18);
                  break;
               case 14:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 29)
                     kind = 29;
                  jjCheckNAddTwoStates(14, 15);
                  break;
               case 16:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(17);
                  break;
               case 17:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 29)
                     kind = 29;
                  jjCheckNAdd(17);
                  break;
               case 18:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 31)
                     kind = 31;
                  jjCheckNAddTwoStates(18, 19);
                  break;
               case 20:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(21);
                  break;
               case 21:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 31)
                     kind = 31;
                  jjCheckNAdd(21);
                  break;
               case 22:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 29)
                     kind = 29;
                  jjCheckNAddStates(0, 9);
                  break;
               case 23:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 29)
                     kind = 29;
                  jjCheckNAdd(23);
                  break;
               case 24:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(24, 25);
                  break;
               case 26:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(27);
                  break;
               case 27:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 29)
                     kind = 29;
                  jjCheckNAdd(27);
                  break;
               case 28:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(28, 29);
                  break;
               case 29:
                  if (curChar == 46)
                     jjCheckNAdd(30);
                  break;
               case 30:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 29)
                     kind = 29;
                  jjCheckNAddTwoStates(30, 31);
                  break;
               case 32:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(33);
                  break;
               case 33:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 29)
                     kind = 29;
                  jjCheckNAdd(33);
                  break;
               case 34:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 30)
                     kind = 30;
                  jjCheckNAdd(34);
                  break;
               case 35:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(35, 36);
                  break;
               case 36:
                  if (curChar == 46)
                     jjCheckNAdd(37);
                  break;
               case 37:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 31)
                     kind = 31;
                  jjCheckNAddTwoStates(37, 38);
                  break;
               case 39:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(40);
                  break;
               case 40:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 31)
                     kind = 31;
                  jjCheckNAdd(40);
                  break;
               case 41:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(41, 42);
                  break;
               case 43:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(44);
                  break;
               case 44:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 31)
                     kind = 31;
                  jjCheckNAdd(44);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 27)
                     kind = 27;
                  jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 3:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 28)
                     kind = 28;
                  jjstateSet[jjnewStateCnt++] = 3;
                  break;
               case 5:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(10, 12);
                  break;
               case 6:
                  if (curChar == 92)
                     jjAddStates(17, 19);
                  break;
               case 7:
                  if ((0x14404410000000L & l) != 0L)
                     jjCheckNAddStates(10, 12);
                  break;
               case 15:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(20, 21);
                  break;
               case 19:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(22, 23);
                  break;
               case 25:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(24, 25);
                  break;
               case 31:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(26, 27);
                  break;
               case 38:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(28, 29);
                  break;
               case 42:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(30, 31);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 5:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(10, 12);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 45 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   23, 24, 25, 28, 29, 34, 35, 36, 41, 42, 5, 6, 8, 5, 6, 10, 
   8, 7, 9, 11, 16, 17, 20, 21, 26, 27, 32, 33, 39, 40, 43, 44, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, "\104\157", "\167\150\151\154\145", "\50", "\51", 
"\54", "\173", "\175", "\73", "\75", "\74", "\76", "\75\75", "\41", "\41\75", 
"\74\75", "\76\75", "\174\174", "\46\46", "\53", "\55", "\52", "\57", null, null, null, 
null, null, null, null, };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x2ffffffe1L, 
};
static final long[] jjtoSkip = {
   0x1eL, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[45];
private final int[] jjstateSet = new int[90];
protected char curChar;
/** Constructor. */
public AnalizadorTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public AnalizadorTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 45; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      CommonTokenAction(matchedToken);
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         CommonTokenAction(matchedToken);
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
