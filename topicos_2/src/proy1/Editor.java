package proy1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.*;

class Editor extends JFrame {
    //Seccion de archivos del menu
    private JMenu archivos;
    private JMenuItem nuevo;
    private JMenuItem abrir;
    private JMenuItem guardarComo;
    private JMenuItem imprimir;
    private JMenuItem salir;

    //Seccion de Editar del menu
    private JMenu editar;
    private JDialog ventanaLetra;
    private JMenuItem estilo;

    private JComboBox<String> fuente;
    private JCheckBox[] estilosNombre;
    private JComboBox<String> tamaño;
    private int tamSeleccionado = 12;
    private int estiloCN; //Cursiva y Negritas

    private JMenuItem copiar;
    private JMenuItem pegar;

    //Seccion ayuad del menu
    private JMenu ayuda;
    private JMenuItem acercaDe;

    //Seccio de TEXTO
    private JTextArea textArea;

    public Editor(String tittle) {
        super(tittle);
        setPreferredSize(new Dimension(600, 400));

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        ListenerEnArchivos listenerEnArchivos = new ListenerEnArchivos();

        archivos = new JMenu(" Archivo ");

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

        archivos.add(nuevo);
        archivos.add(abrir);
        archivos.add(guardarComo);
        archivos.add(imprimir);
        archivos.add(salir);

        ListenerEnEditar listenerEnEditar = new ListenerEnEditar();
        editar = new JMenu(" Edicion ");

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

        String[] nombreEstilos = {"Negritas", "Cursiva"};
        estilosNombre = new JCheckBox[nombreEstilos.length];

        for (int i = 0; i < nombreEstilos.length; i++) {
            estilosNombre[i] = new JCheckBox(nombreEstilos[i]);
            estilosNombre[i].addItemListener(listenerEnEditarItems);
            ventanaLetra.add(estilosNombre[i]);
        }

        String[] nombreFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fuente = new JComboBox<String>(nombreFuentes);
        fuente.setVisible(true);
        fuente.addActionListener(listenerEnEditarItems);


        String[] tamañoFuente = {"12", "14", "16", "18", "20", "24", "28", "32",
                "36", "40", "44", "48", "52", "56", "64"};
        tamaño = new JComboBox<String>(tamañoFuente);
        tamaño.setVisible(true);
        tamaño.addActionListener(listenerEnEditarItems);



        estilosNombre[0].setBounds(15,10,150,20);
        estilosNombre[1].setBounds(15,40,150,20);
        fuente.setBounds(15,70,150, 20);
        tamaño.setBounds(15, 100, 150, 20);

        ventanaLetra.add(fuente);
        ventanaLetra.add(tamaño);


        editar.add(copiar);
        editar.add(pegar);
        editar.add(estilo);

        MenuAyuda mAyuda = new MenuAyuda();
        ayuda = new JMenu(" Ayuda ");
        acercaDe = new JMenuItem("Acerca de");
        acercaDe.addActionListener(mAyuda);
        ayuda.add(acercaDe);

        menuBar.add(archivos);
        menuBar.add(editar);
        menuBar.add(ayuda);

        textArea = new JTextArea();
        textArea.setEditable(true);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(scroll);

        ListenerVentana miOyente = new ListenerVentana();
        addWindowListener(miOyente);

    }


    private class ListenerEnArchivos implements ActionListener {

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


    private class ListenerEnEditar implements ActionListener, ItemListener {

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

            if (e.getSource() == fuente) {
                String nombre = fuente.getSelectedItem().toString();
                textArea.setFont(new Font(nombre, estiloCN, tamSeleccionado));
                repaint();
            }

            if(e.getSource() == tamaño) {
                int cuenta = 12;
                String aux = cuenta+"";
                String tam2 = tamaño.getSelectedItem().toString();

                for (int i = 0; i < 29; i++) {

                    if(tam2.equals(aux)) {
                        tamSeleccionado = cuenta;
                        break;
                    }
                    else {
                        cuenta += 2;
                        aux = cuenta+"";
                    }
                }
                textArea.setFont(new Font(textArea.getFont().getName(), estiloCN, tamSeleccionado));
                repaint();
            }
        }

        // Tipo de letra
        public void itemStateChanged(ItemEvent e) {
            estiloCN = 0;
            boolean negritasSeleccionadas = estilosNombre[0].isSelected();
            boolean cursivasSeleccionadas = estilosNombre[1].isSelected();

            if (negritasSeleccionadas) {
                estiloCN += Font.BOLD; //Agrega negritas
            }
            if (cursivasSeleccionadas) {
                estiloCN += Font.ITALIC;//Agrega cursivas
            }

            textArea.setFont(new Font(textArea.getFont().getName(), estiloCN, tamSeleccionado));
            repaint();
        }
    }

    private class ListenerEnEditarItems implements ActionListener, ItemListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == fuente) {
                String nombre = fuente.getSelectedItem().toString();
                textArea.setFont(new Font(nombre, estiloCN, tamSeleccionado));
                repaint();
            }

            if(e.getSource() == tamaño) {
                int cuenta = 12;
                String aux = cuenta+"";
                String tam2 = tamaño.getSelectedItem().toString();

                for (int i = 0; i < 29; i++) {

                    if(tam2.equals(aux)) {
                        tamSeleccionado = cuenta;
                        break;
                    }
                    else {
                        cuenta += 2;
                        aux = cuenta+"";
                    }
                }
                textArea.setFont(new Font(textArea.getFont().getName(), estiloCN, tamSeleccionado));
                repaint();
            }
        }

        // Tipo de letra
        public void itemStateChanged(ItemEvent e) {
            estiloCN = 0;
            boolean negritasSeleccionadas = estilosNombre[0].isSelected();
            boolean cursivasSeleccionadas = estilosNombre[1].isSelected();

            if (negritasSeleccionadas) {
                estiloCN += Font.BOLD; //Agrega negritas
            }
            if (cursivasSeleccionadas) {
                estiloCN += Font.ITALIC;//Agrega cursivas
            }

            textArea.setFont(new Font(textArea.getFont().getName(), estiloCN, tamSeleccionado));
            repaint();
        }
    }

    //Clase para la seccion del menu de ayuda
    private class MenuAyuda implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == acercaDe) {

                JOptionPane.showMessageDialog(null,
                        "html><h1>Elaborado por</h1>"
                                + "<ul>"
                                + "<li>Rogelio Samuel Moreno Corrales</li>"
                                + "<li>Clase: 4pm - 5pm</li>"
                                + "<li>Tópicos Avanzados de Programación</li>"
                                + "<li>Profesor: Jaime Arturo Felix Medina</li>"
                                + "</ul></html>");

            }

        }

    }

    //Clase para preguntar cuando cierre la ventana
    class ListenerVentana extends WindowAdapter {

        public void windowClosing(WindowEvent e) {
            int op = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres salir?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (op == JOptionPane.YES_OPTION) {
                System.exit(EXIT_ON_CLOSE);
            }
        }
    }
}
