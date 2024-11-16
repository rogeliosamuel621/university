package paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.*;
import java.util.Vector;

class Dibujador extends JFrame {

    //Seccion de archivos del menu
    private JMenu archivos;
    private JMenuItem nuevo;
    private JMenuItem abrir;
    private JMenuItem guardarComo;
    private JMenuItem imprimir;
    private JMenuItem salir;

    //Seccion de Editar del menu
    private JMenu dibujar;
    private JRadioButton linea, rect, circ;
    private enum Tipos { RECTANGULO, CIRCULO, LINEA };
    private Tipos tipo;
    private ButtonGroup btn;
    private JCheckBox isFill;
    private JMenuItem itemcolor;
    private JColorChooser colores;
    private Color colorSelect = Color.black;
    private Color aux = Color.black;
    private Vector<Figura> figuras;

    //Seccion ayuada del menu
    private JMenu ayuda;
    private JMenuItem acercaDe;

    //Agregamos el panel para los dibujos
    PanelDibujo panel;

    public Dibujador(String tittle) {
        super(tittle);
        setPreferredSize(new Dimension(600, 400));

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        MenuArchivos mArchivos = new MenuArchivos();

        //--------------------------------------------SECCION ARCHIVOS
        archivos = new JMenu(" Archivos ");

        nuevo = new JMenuItem("Nuevo");
        nuevo.addActionListener(mArchivos);

        abrir = new JMenuItem("Abrir");
        abrir.addActionListener(mArchivos);

        guardarComo = new JMenuItem("Guardar Como");
        guardarComo.addActionListener(mArchivos);

        imprimir = new JMenuItem("Imprimir");
        imprimir.addActionListener(mArchivos);

        salir = new JMenuItem("Salir ");
        salir.addActionListener(mArchivos);

        //Se agregan al Menu Archivos
        archivos.add(nuevo);
        archivos.add(abrir);
        archivos.add(guardarComo);
        archivos.add(imprimir);
        archivos.add(salir);

        //--------------------------------------------SECCION EDITAR
        MenuDibujar mDibujar = new MenuDibujar();
        dibujar = new JMenu(" Dibujar ");
        btn = new ButtonGroup();

        btn = new ButtonGroup();

        linea = new JRadioButton("Linea");
        btn.add(linea);
        btn.setSelected(linea.getModel(), true);
        linea.addActionListener(mDibujar);

        rect = new JRadioButton("Rectangulo");
        btn.add(rect);
        rect.addActionListener(mDibujar);

        circ = new JRadioButton("Elipse");
        btn.add(circ);
        circ.addActionListener(mDibujar);


        isFill = new JCheckBox("Relleno");
        isFill.addActionListener(mDibujar);

        itemcolor = new JMenuItem("Colores");
        itemcolor.addActionListener(mDibujar);


        dibujar.add(linea);
        dibujar.add(rect);
        dibujar.add(circ);
        dibujar.add(isFill);
        dibujar.add(itemcolor);


        //--------------------------------------------SECCION AYUDA
        MenuAyuda mAyuda = new MenuAyuda();
        ayuda = new JMenu(" Ayuda ");
        acercaDe = new JMenuItem("Acerca de");
        acercaDe.addActionListener(mAyuda);
        ayuda.add(acercaDe);

        menuBar.add(archivos);
        menuBar.add(dibujar);
        menuBar.add(ayuda);

        //--------------------------------------------PANEL
        panel = new PanelDibujo();
        add(panel);


        ListenerVentana oyente = new ListenerVentana();
        addWindowListener(oyente);

    }

    class PanelDibujo extends JPanel {
        // Tipos de Figuras

        // Variables de clase
        Shape figura;
        Graphics2D g2D;
        boolean relleno = false;
        Tipos t;
        Point p1;
        Point p2;

        // Constructor para inicializar valores
        public PanelDibujo()
        {
            MiOyente miOyente = new MiOyente();
            addMouseListener( miOyente );
            addMouseMotionListener( miOyente );

            // Valores iniciales
            figuras = new Vector<>();
            figura = null;
            tipo = tipo.LINEA;
            p1 = null;
            p2 = null;

        }

        public void paintComponent( Graphics g )
        {
            super.paintComponent( g );
            g2D = ( Graphics2D )g;

            //Shape figurita = figuras.get(figuras.size() - 1);

            for (Figura f : figuras )
                f.dibujar(g2D);
        }


        private Shape crearFigura()
        {
            Shape f;
            // Preguntar por el tipo de figura
            if ( tipo == Tipos.LINEA )
                f = new Line2D.Double( p1.getX(), p1.getY(), p2.getX(), p2.getY() );
            else
            {
                double xInicio = Math.min( p1.getX(), p2.getX() );
                double yInicio = Math.min( p1.getY(), p2.getY() );
                double ancho = Math.abs( p2.getX() - p1.getX() );
                double alto = Math.abs( p2.getY() - p1.getY() );

                if ( tipo == Tipos.RECTANGULO )
                    f = new Rectangle2D.Double( xInicio, yInicio, ancho, alto );
                else
                    f = new Ellipse2D.Double( xInicio, yInicio, ancho, alto );
            }
            return f;
        }

        class MiOyente extends MouseAdapter
        {
            public void mousePressed( MouseEvent e )
            {
                // Cambiar cursor
                PanelDibujo.this.setCursor( Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                // Obtener el punto inicial
                p1 = e.getPoint();
            }

            public void mouseReleased( MouseEvent e )
            {
                // Cambiar cursor
                PanelDibujo.this.setCursor( Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                // Obtener el punto final
                p2 = e.getPoint();
                figura = crearFigura();
                figuras.add(new Figura(figura, colorSelect, isFill.isSelected()));
                figura = null;
                repaint();
            }

            public void mouseDragged( MouseEvent e )
            {
                // Obtener objeto Graphics2D
                Graphics2D g2D = (Graphics2D) PanelDibujo.this.getGraphics();
                // Establecer modo XOR de dibujo
                g2D.setXORMode( PanelDibujo.this.getBackground() );

                // Si la figura existe, borrarla
                if ( figura != null )
                    g2D.draw( figura );

                // Crear la nueva figura y dibujarla
                p2 = e.getPoint();
                figura = crearFigura();
                g2D.draw( figura );
            }

        }
    }


    //Action Listener de la seccion de ARCHIVOS
    private class MenuArchivos implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == nuevo) {
                figuras.removeAll(figuras);
                panel.repaint();
                return; // EL RETURN ES PARA QUE EL FLUJO DEL CODIGO YA NO SIGA MAS EN EL METODO
            }

            JFileChooser select = new JFileChooser();

            if (e.getSource() == abrir) {
                int op = select.showOpenDialog(panel);
                if (op == JFileChooser.APPROVE_OPTION) {

                    File archivo = select.getSelectedFile();
                    try {
                        //Escribe los datos del archivo
                        FileInputStream lector = new FileInputStream(archivo);
                        //Dibuja los dibujos dentro de los datos del archivo
                        ObjectInputStream dibujante = new ObjectInputStream(lector);
                        figuras = (Vector<Figura>) dibujante.readObject();
                        panel.repaint();
                    } catch (Exception io) {
                        JOptionPane.showMessageDialog(abrir, "Error al abrir el archivo", "ERROR", JOptionPane.WARNING_MESSAGE);
                    }
                }
                return;
            }

            if (e.getSource() == guardarComo) {
                int op = select.showSaveDialog(panel);
                if (op == JFileChooser.APPROVE_OPTION) {
                    File archivo = select.getSelectedFile();
                    try {
                        //Escribe los datos del archivo
                        OutputStream lector = new FileOutputStream(archivo);
                        //Dibuja los dibujos dentro de los datos del archivo
                        ObjectOutputStream dibujante = new ObjectOutputStream(lector);
                        dibujante.writeObject(figuras);
                        figuras.removeAll(figuras);
                        panel.repaint();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(guardarComo, "Error al guardar.");
                    }
                }
                return;
            }

            if (e.getSource() == imprimir) {
                PrinterJob pj = PrinterJob.getPrinterJob();
                pj.setJobName(" Programa de Dibujo ");

                pj.setPrintable (new Printable() {
                    public int print(Graphics pg, PageFormat pf, int pageNum){
                        if (pageNum > 0){
                            return Printable.NO_SUCH_PAGE;
                        }

                        Graphics2D g2 = (Graphics2D) pg;
                        g2.translate(pf.getImageableX(), pf.getImageableY());
                        double factorEscalaX = 100.0;
                        double factorEscalaY = 100.0;
                        g2.scale(factorEscalaX/pf.getImageableWidth(), factorEscalaY/pf.getImageableHeight());
                        paint(g2);
                        return Printable.PAGE_EXISTS;
                    }
                });
                if (pj.printDialog() == false)
                    return;

                try {
                    pj.print();
                } catch (PrinterException ex) {
                    // handle exception
                }
                return;
            }

            if (e.getSource() == salir) {
                int op = JOptionPane.showConfirmDialog(salir, "¿Seguro que quieres salir?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (op == JOptionPane.YES_OPTION) {
                    System.exit(EXIT_ON_CLOSE);
                }
            }
        }
    }//fin MenuArchivos

    //Clase para la seccion del menu Editar
    private class MenuDibujar implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == itemcolor) {
                aux = colores.showDialog(null, "Seleccione un color", colorSelect);
                colorSelect = new Color(aux.getRed(), aux.getGreen(), aux.getBlue());
            }

            if(e.getSource() == linea) {
                if (isFill.isSelected()) {
                    JOptionPane.showMessageDialog(linea, "No se puede dibujar una linea con relleno", "Ten en cuenta", JOptionPane.WARNING_MESSAGE);
                    tipo = tipo;
                    return;
                }

                tipo = tipo.LINEA;
                return;
            }

            if(e.getSource() == rect) {
                tipo = tipo.RECTANGULO;
                return;
            }

            if(e.getSource() == circ) {
                tipo = tipo.CIRCULO;
                return;
            }

        }
    }
    //Clase para la seccion del menu de ayuda
    private class MenuAyuda implements ActionListener {
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