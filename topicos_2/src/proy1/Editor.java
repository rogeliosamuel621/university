package proy1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.*;

class Editor extends JFrame {
    private JMenu menuArchivos;
    private JMenuItem nuevo;
    private JMenuItem abrir;
    private JMenuItem guardarComo;
    private JMenuItem imprimir;
    private JMenuItem salir;

    private JMenu menuEditar;
    private JDialog ventanaLetra;
    private JMenuItem estilo;

    private JComboBox<String> fuente;
    private JCheckBox[] estilosNombre;
    private JComboBox<String> tamaño;
    private int tamDeLetra = 12;
    private int estiloDeLetra;

    private JMenuItem copiar;
    private JMenuItem pegar;


    private JMenu menuAyuda;
    private JMenuItem acercaDe;


    private JTextArea textArea;

    String[] estilosDeLetraHabilitados = {"Negritas", "Cursiva"};

    public Editor(String tittle) {
        super(tittle);
        setPreferredSize(new Dimension(600, 400));

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        ListenerEnArchivos listenerEnArchivos = new ListenerEnArchivos();

        menuArchivos = new JMenu(" Archivo ");

        nuevo = new JMenuItem("Nuevo");
        nuevo.addActionListener(listenerEnArchivos);

        abrir = new JMenuItem("Abrir");
        abrir.addActionListener(listenerEnArchivos);

        guardarComo = new JMenuItem("Guardar Como");
        guardarComo.addActionListener(listenerEnArchivos);

        imprimir = new JMenuItem("Imprimir");
        imprimir.addActionListener(listenerEnArchivos);

        salir = new JMenuItem("Salir ");
        salir.addActionListener(listenerEnArchivos);

        menuArchivos.add(nuevo);
        menuArchivos.add(abrir);
        menuArchivos.add(guardarComo);
        menuArchivos.add(imprimir);
        menuArchivos.add(salir);

        ListenerEnEditar listenerEnEditar = new ListenerEnEditar();
        menuEditar = new JMenu(" Edicion ");

        estilo = new JMenuItem("Tipo de Letra");
        estilo.addActionListener(listenerEnEditar);

        copiar = new JMenuItem("Copiar");
        copiar.addActionListener(listenerEnEditar);

        pegar = new JMenuItem("Pegar");
        pegar.addActionListener(listenerEnEditar);

        ListenerEnEditarItems listenerEnEditarItems = new ListenerEnEditarItems();

        ventanaLetra = new JDialog();
        ventanaLetra.setLayout(null);

        ventanaLetra.setTitle("Tipo de letra");
        ventanaLetra.setModal(true);
        ventanaLetra.setSize(200,200);
        ventanaLetra.setLocationRelativeTo(textArea);


        estilosNombre = new JCheckBox[estilosDeLetraHabilitados.length];

        for (int i = 0; i < estilosDeLetraHabilitados.length; i++) {
            estilosNombre[i] = new JCheckBox(estilosDeLetraHabilitados[i]);
            estilosNombre[i].addItemListener(listenerEnEditarItems);
            ventanaLetra.add(estilosNombre[i]);
        }

        String[] nombreFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fuente = new JComboBox<String>(nombreFuentes);
        fuente.setVisible(true);
        fuente.addActionListener(listenerEnEditarItems);


        String[] tamDeFuente = {"12", "14", "16", "18", "20", "24", "28", "32",
                "36", "40", "44", "48", "52", "56", "64"};
        tamaño = new JComboBox<String>(tamDeFuente);
        tamaño.setVisible(true);
        tamaño.addActionListener(listenerEnEditarItems);



        estilosNombre[0].setBounds(15,10,150,20);
        estilosNombre[1].setBounds(15,40,150,20);
        fuente.setBounds(15,70,150, 20);
        tamaño.setBounds(15, 100, 150, 20);

        ventanaLetra.add(fuente);
        ventanaLetra.add(tamaño);


        menuEditar.add(copiar);
        menuEditar.add(pegar);
        menuEditar.add(estilo);

        ListenerEnAyuda mAyuda = new ListenerEnAyuda();
        menuAyuda = new JMenu(" Ayuda ");
        acercaDe = new JMenuItem("Acerca de");
        acercaDe.addActionListener(mAyuda);
        menuAyuda.add(acercaDe);

        menuBar.add(menuArchivos);
        menuBar.add(menuEditar);
        menuBar.add(menuAyuda);

        textArea = new JTextArea();
        textArea.setEditable(true);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(scroll);

        ListenerEnCerrarVentana miOyente = new ListenerEnCerrarVentana();
        addWindowListener(miOyente);

    }


    class ListenerEnArchivos implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            boolean nuevoEsClickeado = e.getSource() == nuevo;
            boolean abrirEsClickeado = e.getSource() == abrir;
            boolean guardarComoEsClickeado = e.getSource() == guardarComo;
            boolean imprimirEsClickeado = e.getSource() == imprimir;
            boolean salirEsClickeado = e.getSource() == salir;

            if (nuevoEsClickeado) {
                textArea.setText("");
                return;
            }

            JFileChooser select = new JFileChooser();

            if (abrirEsClickeado) {
                int op = select.showOpenDialog(textArea);
                if (op == JFileChooser.APPROVE_OPTION) {

                    File archivo = select.getSelectedFile();
                    try {
                        FileReader leer = new FileReader(archivo);
                        BufferedReader buff = new BufferedReader(leer);
                        String textoAbierto;
                        textArea.setText(" ");
                        while ((textoAbierto = buff.readLine()) != null)
                            textArea.append(textoAbierto + "\n");
                        buff.close();
                    } catch (IOException io) {
                        JOptionPane.showMessageDialog(abrir, "Error al abrir el archivo", "ERROR", JOptionPane.WARNING_MESSAGE);
                    }
                }
                return;
            }

            if (guardarComoEsClickeado) {
                int op = select.showOpenDialog(textArea);
                if (op == JFileChooser.APPROVE_OPTION) {
                    File archivo = select.getSelectedFile();
                    try {
                        FileWriter writer = new FileWriter(archivo);
                        writer.write(textArea.getText());
                        writer.close();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(guardarComo, "Ah ocurrido un error al guardar.");
                    }
                }
                return;
            }

            if (imprimirEsClickeado) {
                try {
                    textArea.print();
                } catch (PrinterException e1) {
                    JOptionPane.showMessageDialog(imprimir, "Ah ocurrido un error al imprimir", "Error", JOptionPane.WARNING_MESSAGE);
                }
                return;
            }

            if (salirEsClickeado) {
                int op = JOptionPane.showConfirmDialog(salir, "¿Seguro que quieres salir?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (op == JOptionPane.YES_OPTION) {
                    System.exit(EXIT_ON_CLOSE);
                }
            }
        }
    }


    class ListenerEnEditar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == copiar) {
                textArea.selectAll();
                textArea.copy();
                return;
            }

            if (e.getSource() == pegar) {
                textArea.paste();
                return;
            }

            if (e.getSource() == estilo) {
                ventanaLetra.setVisible(true);
                return;
            }
        }

    }

    class ListenerEnEditarItems implements ActionListener, ItemListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == fuente) {
                String nombre = fuente.getSelectedItem().toString();
                textArea.setFont(new Font(nombre, estiloDeLetra, tamDeLetra));
                repaint();
            }

            if(e.getSource() == tamaño) {
                int cuenta = 12;
                String aux = cuenta+"";
                String tam2 = tamaño.getSelectedItem().toString();

                for (int i = 0; i < 29; i++) {

                    if(tam2.equals(aux)) {
                        tamDeLetra = cuenta;
                        break;
                    }
                    else {
                        cuenta += 2;
                        aux = cuenta+"";
                    }
                }
                textArea.setFont(new Font(textArea.getFont().getName(), estiloDeLetra, tamDeLetra));
                repaint();
            }
        }

        // Tipo de letra
        public void itemStateChanged(ItemEvent e) {
            estiloDeLetra = 0;
            boolean negritasSeleccionadas = estilosNombre[0].isSelected();
            boolean cursivasSeleccionadas = estilosNombre[1].isSelected();

            if (negritasSeleccionadas) {
                estiloDeLetra += Font.BOLD; //Agrega negritas
            }
            if (cursivasSeleccionadas) {
                estiloDeLetra += Font.ITALIC;//Agrega cursivas
            }

            textArea.setFont(new Font(textArea.getFont().getName(), estiloDeLetra, tamDeLetra));
            repaint();
        }
    }

    class ListenerEnAyuda implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == acercaDe) {

                JOptionPane.showMessageDialog(null,
                        "<html><h1>Elaborado por</h1>"
                                + "<ul>"
                                + "<li>Rogelio Samuel Moreno Corrales</li>"
                                + "<li>Clase: 4pm - 5pm</li>"
                                + "</ul></html>");

            }

        }

    }

    static class ListenerEnCerrarVentana extends WindowAdapter {

        public void windowClosing(WindowEvent e) {
            int opt = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres salir?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (opt == JOptionPane.YES_OPTION) {
                System.exit(EXIT_ON_CLOSE);
            }
        }
    }
}
