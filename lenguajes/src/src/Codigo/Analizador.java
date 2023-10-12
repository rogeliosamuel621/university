package src.Codigo;

public class Analizador implements AnalizadorConstants {

  /**
   * esponsable de procesar una secuencia de tokens de acuerdo con la gramática definida
   * y controlar la estructura de bucle do-while en el análisis sintáctico.
   * @throws ParseException
   */
  final public void Input() throws ParseException {
    label_1:
    while (true) {
      // método que procesa una estructura de bucle do-while en la gramática.
      DoWhile();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case Do:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
    }
    jj_consume_token(0);
  }

  final public void DoWhile() throws ParseException {
    // empezar con do
    jj_consume_token(Do);
    // llave de apertura
    jj_consume_token(LKEY);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        // diferentes sentencias que se pueden encontrar en el bucle do while
      case Do:
      case SEMICOLON:
      case VARNUM:
      case VARCAD:
        ;
        break;
      default:
        // mal sintaxis
        jj_la1[1] = jj_gen;
        break label_2;
      }
      Sentencia();
    }
    // analizar palabras de cierre
    jj_consume_token(RKEY);
    jj_consume_token(While);
    jj_consume_token(LBRACE);
    ComparacionExpr();
    jj_consume_token(RBRACE);
    // completado la estructure del bucle do while
    jj_consume_token(SEMICOLON);
  }

  /**
   * Analiza las sentencias
   * @throws ParseException
   */
  final public void Sentencia() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      // no hay sentencia
    case SEMICOLON:
      SinSentencia();
      break;
      // sentencia de asignacion
    case VARNUM:
    case VARCAD:
      Asignacion();
      break;
      // sentencia do while
    case Do:
      DoWhile();
      break;
      // sentencia inválida
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void SinSentencia() throws ParseException {
    jj_consume_token(SEMICOLON);
  }

  final public void Asignacion() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VARNUM:
      jj_consume_token(VARNUM);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ASSIGN:
        jj_consume_token(ASSIGN);
        SumExpr();
        break;
      default:
        jj_la1[3] = jj_gen;
        ;
      }
      break;
    case VARCAD:
      jj_consume_token(VARCAD);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ASSIGN:
        jj_consume_token(ASSIGN);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case STRING_LITERAL:
          jj_consume_token(STRING_LITERAL);
          break;
        case VARCAD:
          jj_consume_token(VARCAD);
          break;
        default:
          jj_la1[4] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        label_3:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case PLUS:
            ;
            break;
          default:
            jj_la1[5] = jj_gen;
            break label_3;
          }
          jj_consume_token(PLUS);
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case STRING_LITERAL:
            jj_consume_token(STRING_LITERAL);
            break;
          case VARCAD:
            jj_consume_token(VARCAD);
            break;
          default:
            jj_la1[6] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
        break;
      default:
        jj_la1[7] = jj_gen;
        ;
      }
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(SEMICOLON);
  }

////////////OPERACIONES ARITMETICAS
  final public void SumExpr() throws ParseException {
    UnOp();
    ProdExpr();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_4;
      }
      SumOp();
      ProdExpr();
    }
  }

  final public void ProdExpr() throws ParseException {
    Factor();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STAR:
      case SLASH:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_5;
      }
      MultOp();
      UnOp();
      Factor();
    }
  }

  final public void Factor() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VARNUM:
      jj_consume_token(VARNUM);
      break;
    case NUM:
      jj_consume_token(NUM);
      break;
    case LBRACE:
      jj_consume_token(LBRACE);
      SumExpr();
      jj_consume_token(RBRACE);
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void UnOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
    case MINUS:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MINUS:
        jj_consume_token(MINUS);
        break;
      case PLUS:
        jj_consume_token(PLUS);
        break;
      default:
        jj_la1[12] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[13] = jj_gen;
      ;
    }
  }

  final public void SumOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MINUS:
      jj_consume_token(MINUS);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
        break;
      default:
        jj_la1[14] = jj_gen;
        ;
      }
      break;
    case PLUS:
      jj_consume_token(PLUS);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MINUS:
        jj_consume_token(MINUS);
        break;
      default:
        jj_la1[15] = jj_gen;
        ;
      }
      break;
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void MultOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STAR:
      jj_consume_token(STAR);
      break;
    case SLASH:
      jj_consume_token(SLASH);
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

////OPERACIONES RELACIONALES
  final public void ComparacionExpr() throws ParseException {
    AndExpr();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OR:
        ;
        break;
      default:
        jj_la1[18] = jj_gen;
        break label_6;
      }
      jj_consume_token(OR);
      AndExpr();
    }
  }

  final public void AndExpr() throws ParseException {
    RelExpr();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
        ;
        break;
      default:
        jj_la1[19] = jj_gen;
        break label_7;
      }
      jj_consume_token(AND);
      RelExpr();
    }
  }

  final public void RelExpr() throws ParseException {
    if (jj_2_1(2147483647)) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NE2:
        jj_consume_token(NE2);
        break;
      default:
        jj_la1[20] = jj_gen;
        ;
      }
      jj_consume_token(LBRACE);
      ComparacionExpr();
      jj_consume_token(RBRACE);
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LBRACE:
      case PLUS:
      case MINUS:
      case VARNUM:
      case NUM:
        SumExpr();
        RelOp();
        SumExpr();
        break;
      default:
        jj_la1[21] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void RelOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EQ:
      jj_consume_token(EQ);
      break;
    case NE:
      jj_consume_token(NE);
      break;
    case GT:
      jj_consume_token(GT);
      break;
    case GE:
      jj_consume_token(GE);
      break;
    case LT:
      jj_consume_token(LT);
      break;
    case LE:
      jj_consume_token(LE);
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_3R_20() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(24)) {
    jj_scanpos = xsp;
    if (jj_scan_token(23)) return true;
    }
    return false;
  }

  private boolean jj_3R_17() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_20()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_21() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(27)) {
    jj_scanpos = xsp;
    if (jj_scan_token(29)) {
    jj_scanpos = xsp;
    if (jj_3R_24()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_18() {
    if (jj_3R_21()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_22()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_16() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(16)) {
    jj_scanpos = xsp;
    if (jj_scan_token(18)) {
    jj_scanpos = xsp;
    if (jj_scan_token(15)) {
    jj_scanpos = xsp;
    if (jj_scan_token(20)) {
    jj_scanpos = xsp;
    if (jj_scan_token(14)) {
    jj_scanpos = xsp;
    if (jj_scan_token(19)) return true;
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_15() {
    if (jj_3R_17()) return true;
    if (jj_3R_18()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_19()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_12() {
    if (jj_scan_token(AND)) return true;
    if (jj_3R_11()) return true;
    return false;
  }

  private boolean jj_3R_14() {
    if (jj_3R_15()) return true;
    if (jj_3R_16()) return true;
    if (jj_3R_15()) return true;
    return false;
  }

  private boolean jj_3_1() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(17)) jj_scanpos = xsp;
    if (jj_scan_token(LBRACE)) return true;
    if (jj_3R_8()) return true;
    return false;
  }

  private boolean jj_3R_13() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(17)) jj_scanpos = xsp;
    if (jj_scan_token(LBRACE)) return true;
    if (jj_3R_8()) return true;
    if (jj_scan_token(RBRACE)) return true;
    return false;
  }

  private boolean jj_3R_11() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_13()) {
    jj_scanpos = xsp;
    if (jj_3R_14()) return true;
    }
    return false;
  }

  private boolean jj_3R_10() {
    if (jj_scan_token(OR)) return true;
    if (jj_3R_9()) return true;
    return false;
  }

  private boolean jj_3R_9() {
    if (jj_3R_11()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_12()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_8() {
    if (jj_3R_9()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_10()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_25() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(25)) {
    jj_scanpos = xsp;
    if (jj_scan_token(26)) return true;
    }
    return false;
  }

  private boolean jj_3R_19() {
    if (jj_3R_23()) return true;
    if (jj_3R_18()) return true;
    return false;
  }

  private boolean jj_3R_24() {
    if (jj_scan_token(LBRACE)) return true;
    if (jj_3R_15()) return true;
    if (jj_scan_token(RBRACE)) return true;
    return false;
  }

  private boolean jj_3R_27() {
    if (jj_scan_token(PLUS)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(24)) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_26() {
    if (jj_scan_token(MINUS)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(23)) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_23() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_26()) {
    jj_scanpos = xsp;
    if (jj_3R_27()) return true;
    }
    return false;
  }

  private boolean jj_3R_22() {
    if (jj_3R_25()) return true;
    if (jj_3R_17()) return true;
    if (jj_3R_21()) return true;
    return false;
  }

  /** Generated Token Manager. */
  public AnalizadorTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[23];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x20,0x18001020,0x18001020,0x2000,0x10000000,0x800000,0x10000000,0x2000,0x18000000,0x1800000,0x6000000,0x28000080,0x1800000,0x1800000,0x800000,0x1000000,0x1800000,0x6000000,0x200000,0x400000,0x20000,0x29800080,0x1dc000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x2,0x0,0x2,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[1];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Analizador(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Analizador(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new AnalizadorTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 23; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 23; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Analizador(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AnalizadorTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 23; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 23; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Analizador(AnalizadorTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 23; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(AnalizadorTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 23; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[34];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 23; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 34; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
