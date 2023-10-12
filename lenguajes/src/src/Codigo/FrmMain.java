package src.Codigo;

import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.logging.*;

public class FrmMain extends JFrame {

	private JButton btnAnalizar;
	private JLabel jLabel1;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane3;
	private JScrollPane jScrollPane4;
	private JTextArea jTextArea1;
	private JLabel lblExpresion1;
	private JLabel lblestado;
	private JTextArea txtEvaluacion;
	private JTextPane txtFuncion;

	/**
	 * Inicializa los componentes de la interfaz
	 * configura los colores y llama a algunos métodos para analizar y colorear la sintaxis.
	 */
	public FrmMain() {
		initComponents();
		iniciarColores();
		btnAnalizarActionPerformed(null);
		timerColor.start();
	}

	int color = 0;
	Timer timerColor = new Timer(1000, new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			if (color == 0) {
				color = 1;
			} else {
				color = 0;
			}
			for (Token token : ultimosTokenDoWhile) {
				if (color == 0) {
					colorearTokens(token, attrs);
				} else {
					colorearTokens(token, attrsBlue);
				}
			}
		}
	});
	SimpleAttributeSet attrs;
	SimpleAttributeSet attrsNormal;
	SimpleAttributeSet attrsRojo;
	SimpleAttributeSet attrsMorado;
	SimpleAttributeSet attrsSalmon;
	SimpleAttributeSet attrsGreen;
	SimpleAttributeSet attrsRed;
	SimpleAttributeSet attrsOp;
	SimpleAttributeSet attrsBlue;

	/**
	 * Inicializamos los colores
	 */
	private void iniciarColores() {
		attrs = new SimpleAttributeSet();
		StyleConstants.setBold(attrs, true);
		StyleConstants.setForeground(attrs, Color.blue);
		attrsNormal = new SimpleAttributeSet();
		StyleConstants.setBold(attrsNormal, false);
		StyleConstants.setForeground(attrsNormal, Color.black);
		attrsRojo = new SimpleAttributeSet();
		StyleConstants.setBold(attrsRojo, false);
		StyleConstants.setForeground(attrsRojo, Color.getHSBColor(200, 220, 800));
		attrsMorado = new SimpleAttributeSet();
		StyleConstants.setBold(attrsMorado, true);
		StyleConstants.setForeground(attrsMorado, Color.MAGENTA);
		attrsSalmon = new SimpleAttributeSet();
		StyleConstants.setBold(attrsSalmon, false);
		StyleConstants.setForeground(attrsSalmon, Color.ORANGE);
		attrsGreen = new SimpleAttributeSet();
		StyleConstants.setBold(attrsGreen, true);
		StyleConstants.setForeground(attrsGreen, Color.green);
		attrsRed = new SimpleAttributeSet();
		StyleConstants.setForeground(attrsRed, Color.RED);
		StyleConstants.setItalic(attrsRed, true);
		StyleConstants.setBold(attrsRed, true);
		attrsOp = new SimpleAttributeSet();
		StyleConstants.setForeground(attrsOp, Color.DARK_GRAY);
		StyleConstants.setItalic(attrsOp, true);
		StyleConstants.setBold(attrsOp, true);
		attrsBlue = new SimpleAttributeSet();
		StyleConstants.setForeground(attrsBlue, Color.blue);
		StyleConstants.setItalic(attrsBlue, true);
		StyleConstants.setBold(attrsBlue, true);
	}

	List<Token> ultimosTokenDoWhile = new LinkedList<Token>();

	/**
	 * Aplica colores a la sintaxis del código según los tokens proporcionados.
	 * @param tokens
	 */
	private void colorearTokens(List<Token> tokens) {
		ultimosTokenDoWhile.clear();
		for (Token token : tokens) {
			switch (token.kind) {
			case Analizador.Do:
			case Analizador.While:
				ultimosTokenDoWhile.add(token);
				colorearTokens(token, attrs);
				break;
			case Analizador.LKEY:
			case Analizador.RKEY:
			case Analizador.LBRACE:
			case Analizador.RBRACE:
				colorearTokens(token, attrsRojo);
				break;
			case Analizador.VARNUM:
				colorearTokens(token, attrsMorado);
				break;
			case Analizador.VARCAD:
				colorearTokens(token, attrsGreen);
				break;
			case Analizador.STRING_LITERAL:
				colorearTokens(token, attrsSalmon);
				break;
			case Analizador.NUM:
				colorearTokens(token, attrsRed);
				break;
			case Analizador.MINUS:
			case Analizador.PLUS:
			case Analizador.SLASH:
			case Analizador.STAR:
				colorearTokens(token, attrsOp);
				break;
			default:
				colorearTokens(token, attrsNormal);
			}
		}
		if (!tokens.isEmpty()) {
			Token token = tokens.get(tokens.size() - 1);
			int posicionFinal = posicionesEnLineaCaracter(txtFuncion.getText(), token.endLine, token.endColumn);
			if (posicionFinal >= 0) {
				StyledDocument sd = txtFuncion.getStyledDocument();
				if (sd != null) {
					sd.setCharacterAttributes(posicionFinal, txtFuncion.getText().length() - posicionFinal + 1,
							attrsNormal, true);
				}
			}
		}
	}

	/**
	 * Aplica colores a un token específico según el estilo proporcionado.
	 * @param token
	 * @param simpleAttribute
	 */
	private void colorearTokens(Token token, SimpleAttributeSet simpleAttribute) {
		int posicionInicial = posicionesEnLineaCaracter(txtFuncion.getText(), token.beginLine, token.beginColumn);
		int posicionFinal = posicionesEnLineaCaracter(txtFuncion.getText(), token.endLine, token.endColumn);
		StyledDocument sd = txtFuncion.getStyledDocument();
		if (posicionInicial >= 0 && posicionFinal >= 0) {
			if (sd != null) {
				sd.setCharacterAttributes(posicionInicial, posicionFinal - posicionInicial + 1, simpleAttribute, true);
			}
		}

	}

	/**
	 * Traducimos el mensaje de error al español
	 * @param msg
	 * @return
	 */
	private String traducir(String msg) {
		msg = msg.replace("Lexical error ", "Error Lexico ");
		msg = msg.replace("at line ", "en linea ");
		msg = msg.replace("column ", "columna ");
		msg = msg.replace("Was expecting one of:", "Se esperaba uno de estos:");
		msg = msg.replace("Was expecting:", "Se esperaba:");
		msg = msg.replace("Encountered \"<EOF>\"", "Se finalizo el texto");
		msg = msg.replace("Encountered", "Se encontro");
		msg = msg.replace("after ", "despues");
		return msg;
	}

	/**
	 *  Calcula la posición de un carácter en una línea de texto.
	 * @param cadena
	 * @param linea
	 * @param columna
	 * @return
	 */
	private int posicionesEnLineaCaracter(String cadena, int linea, int columna) {
		int posicion = 0;
		String cadenaSplit[] = cadena.split("\\r?\\n");
		for (int i = 0; i < cadenaSplit.length; i++) {
			if (i != 0) {
				posicion++;
			}
			if (i == linea - 1) {
				posicion += columna;
				break;
			} else {
				posicion += (cadenaSplit[i].length());
			}
		}
		posicion -= 1;
		return posicion;
	}

	/**
	 * Inicializa los componentes de la interfaz y define su diseño y configuración.
	 */
	private void initComponents() {

		btnAnalizar = new JButton();
		jScrollPane2 = new JScrollPane();
		txtEvaluacion = new JTextArea();
		lblestado = new JLabel();
		jScrollPane3 = new JScrollPane();
		jTextArea1 = new JTextArea();
		lblExpresion1 = new JLabel();
		jLabel1 = new JLabel();
		jScrollPane4 = new JScrollPane();
		txtFuncion = new JTextPane();
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Analizador Lexico y Sintactico con JavaCC - lenguajes y automatas");

		btnAnalizar.setText("Comprobar Sintaxis");
		btnAnalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnAnalizarActionPerformed(evt);
			}
		});

		txtEvaluacion.setColumns(20);
		txtEvaluacion.setForeground(new Color(255, 0, 0));
		txtEvaluacion.setRows(5);
		jScrollPane2.setViewportView(txtEvaluacion);

		lblestado.setBackground(new Color(0, 255, 51));
		lblestado.setFont(new Font("Tahoma", 3, 11)); // NOI18N
		lblestado.setForeground(new Color(255, 255, 255));
		lblestado.setOpaque(true);
		lblestado.setVisible(false);

		jTextArea1.setEditable(false);
		jTextArea1.setColumns(20);
		jTextArea1.setFont(new Font("Courier New", 0, 13)); // NOI18N
		jTextArea1.setLineWrap(true);
		jTextArea1.setRows(5);
		jTextArea1.setText(
				"Do{\n\t.....\n}while(condicion);\n---------------------------------\n*Dentro de un ciclo Do while pueden haber mas ciclos Do while.\n*Dentro de un ciclo Do while pueden haber variables, asignaciones, comparaciones y operaciones basicas.\n*Para cada fin de operacion se finaliza con \";\"\n*Las variables pueden ser de dos tipos:\n  -Numericas: las cuales comienzan con el simbolo # y debe ir seguida por lo menos por un digito, letra o guion bajo.\n  -Alfanumericas: las cuales comienzan con el \nsimbolo $ y debe ir seguida por lo menos por un \ndigito, letra o guion bajo.\n\nLas asignaciones se hacen de la siguiente manera:\nvariable= operaciones basicas |\n\tvariable | numero | \"texto\"\n\nLas operaciones basicas son : \n\t*,/,+,-\nLos simbolos de comparacion son: \n\t==,!=,<,<=,>,>=,&&,||\n\n----------------------\nElaborado por:\n-Rogelio Samuel Moreno Corrales");
		jScrollPane3.setViewportView(jTextArea1);

		lblExpresion1.setFont(new Font("Tahoma", 3, 11)); // NOI18N
		lblExpresion1.setForeground(new Color(255, 0, 0));
		lblExpresion1.setText("Errores");

		jLabel1.setIcon(new ImageIcon("Teoria de Automatas.jpg")); // NOI18N

		txtFuncion.setFont(new Font("Courier New", 0, 18)); // NOI18N
		txtFuncion.setText("Do{\n $cad=\" Prueba Cadena\";\n}while(2!=3 && (#var==2));");
		txtFuncion.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				txtFuncionKeyPressed(evt);
			}

			public void keyReleased(KeyEvent evt) {
				txtFuncionKeyReleased(evt);
			}
		});
		jScrollPane4.setViewportView(txtFuncion);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout
						.createSequentialGroup()
						.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
								.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(lblestado, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE,
										489, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblExpresion1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 499,
										GroupLayout.PREFERRED_SIZE))
								.addComponent(jScrollPane4)))
						.addGroup(layout.createSequentialGroup().addGap(527, 527, 527).addComponent(btnAnalizar,
								GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
						.addComponent(jLabel1))));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addComponent(jLabel1)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(lblestado, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(lblExpresion1)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane2))
						.addComponent(jScrollPane3, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 513,
								GroupLayout.PREFERRED_SIZE))
				.addGap(126, 126, 126).addComponent(btnAnalizar).addContainerGap()));

		setBounds(0, 0, 960, 670);
	}

	/**
	 * Maneja el evento de hacer clic en el botón "Comprobar Sintaxis" y realiza la evaluación léxica y sintáctica del código
	 * @param evt
	 */
	private void btnAnalizarActionPerformed(ActionEvent evt) {
		txtEvaluacion.setText("");
		// remplaza el texto a bytes remplazando los tabs por espacios
		InputStream is = new ByteArrayInputStream(txtFuncion.getText().replaceAll("\t", " ").getBytes());
		Analizador analizador = null;
		try {
			analizador = new Analizador(is);
			// comienza el analisis
			analizador.Input();
			mostrarestado(1, "Expresion evaluada exitosamente");
		} catch (ParseException pe) { // errores sintácticos
			txtEvaluacion.setText(traducir(pe.getMessage()));
		} catch (TokenMgrError tm) { // errores léxcios
			txtEvaluacion.setText(traducir(tm.getMessage()));
		}
		if (analizador != null) { // si es exitoso
			colorearTokens(analizador.token_source.getListaToken());
		}

	}

	/**
	 * Maneja el evento de soltar una tecla en el área de texto txtFuncion
	 * y llama al método btnAnalizarActionPerformed para realizar la evaluación léxica y sintáctica.
	 * @param evt
	 */
	private void txtFuncionKeyReleased(KeyEvent evt) {
		btnAnalizarActionPerformed(null);
		timerColor.start();
	}

	/**
	 *  Maneja el evento de presionar una tecla en el área de texto txtFuncion y detiene el temporizador timerColor.
	 * @param evt
	 */
	private void txtFuncionKeyPressed(KeyEvent evt) {
		timerColor.stop();
	}

	Timer timerestado = new Timer(3000, new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			lblestado.setVisible(false);
		}
	});

	/**
	 * Muestra un estado (éxito o error) y un mensaje en la interfaz durante un tiempo determinado.
	 * @param estado
	 * @param msg
	 */
	private void mostrarestado(int estado, String msg) {
		timerestado.stop();
		if (estado == 1) {
			lblestado.setBackground(Color.blue);
			lblestado.setIcon(new ImageIcon("1.gif"));
		} else {
			lblestado.setBackground(Color.red);
			lblestado.setIcon(new ImageIcon("2.gif"));
		}
		lblestado.setText(msg);
		lblestado.setVisible(true);
		timerestado.start();
	}

	/**
	 * Punto de entrada principal del programa, crea una instancia de FrmMain y muestra la interfaz gráfica.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FrmMain().setVisible(true);
			}
		});
	}

}
