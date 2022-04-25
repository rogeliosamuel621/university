package borracho;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.text.DecimalFormat;

public class Borracho extends JPanel{
    static ArrayList <Integer> xf = new ArrayList<>();
    static ArrayList <Integer> yf = new ArrayList<>();
    static DecimalFormat d = new DecimalFormat("0.000000");
    static int o, x, y, cont, e;
    static double prob, r;
    public static void main(String[] args) {
        //Creacion del Scanner
        Scanner sc = new Scanner(System.in);
        //Llamada de metodos
        mPrincipal(sc);
        ventana();
    }
    //Metodo del menu principal
    public static void mPrincipal(Scanner sc) {

        System.out.println("Cuantas veces decea correr la simulacion");
        do {
            o = sc.nextInt();
            System.out.println(" ");
            if(o<1) {
                System.out.println("Ingrese un numero valido");
            }
        }while(o<1);

        metodoPrincipal();
    }

    public static void metodoPrincipal() {
        System.out.println("|--------------------------------------------------------------------|");
        System.out.println("|N\t#CR\t   #AleGen\t\tLocalizacion\t       Exito?|");
        System.out.println("|--------------------------------------------------------------------|");
        for(int i=0; i<o; i++) {
            cont=0;
            System.out.print("|"+(i+1));
            for(int j=0; j<10; j++) {
                r = Math.random();
                if(r<=0.25) {
                    y++;
                    cont++;
                }
                if(r>0.25 && r<=0.50) {
                    y--;
                    cont++;
                }
                if(r>0.50 && r<=0.75) {
                    x++;
                    cont++;
                }
                if(r>0.75 && r<=1) {
                    x--;
                    cont++;
                }
                if(cont==10) {
                    if(Math.abs(x)>1 || Math.abs(y)>1) {
                        System.out.println("|\t"+(j+1)+"\t   "+d.format(r)+"\t"+"           (" +x+ " , " +y+")"+"\t\t'SI' |");
                        System.out.println("|--------------------------------------------------------------------|");
                        e++;
                    }
                    else {
                        System.out.println("|\t"+(j+1)+"\t   "+d.format(r)+"\t"+"           (" +x+ " , " +y+")"+"\t\t'NO' |");
                        System.out.println("|--------------------------------------------------------------------|");
                    }
                }
                else {
                    System.out.println("|\t"+(j+1)+"\t   "+d.format(r)+"\t"+"           ("+x+ " , " +y+")\t\t     |");
                }
            }
            xf.add(x);
            yf.add(y);
            x=0;
            y=0;
        }
        prob = ((double)e/(double)o)*100;
        System.out.println("La probabilidad de que el borracho quede a dos cuadras es de: "+d.format(prob)+"%");
    }
    public static void ventana() {
        JFrame ventana = new JFrame("Borracho");
        Borracho obj  = new Borracho();
        ventana.add(obj);
        ventana.setSize(698,698);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void puntos(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        BasicStroke n = new BasicStroke(6);
        g2d.setStroke(n);
        g.setColor(Color.red);
        for(int k=0; k<o; k++){
            //g.fillOval(20*xf.get(k)+350,-20*yf.get(k)+350,15,15);
            g2d.drawLine(20*xf.get(k)+350,-20*yf.get(k)+350,20*xf.get(k)+350,-20*yf.get(k)+350);
        }
    }
    public static void lineas(Graphics g) {
        //Lineas principales
        Graphics2D g2d = (Graphics2D)g;
        BasicStroke n = new BasicStroke(3);
        g2d.setStroke(n);
        g.setColor(Color.black);
        g.drawLine(350, 0, 350, 700);
        g.drawLine(0, 350, 700, 350);
        BasicStroke n1 = new BasicStroke(0);
        g.setColor(Color.black);
        g2d.setStroke(n1);
        int a=0, b=0;
        while(a<=70){
            a++;
            b=b+10;
            g.drawLine(0, b, 700, b);
            g.drawLine(b, 0, b, 700);
        }
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        //Fondo
        g.setColor(Color.white);
        g.fillRect(0,0,700,700);

        lineas(g);
        puntos(g);
        //Cuadros de fondo
        g.setColor(Color.white);
        g.fillRect(0, 0, 150, 35);
        g.fillRect(352, 5, 15, 15);
        g.fillRect(658, 352, 15, 15);

        //Texto
        Graphics2D g2d = (Graphics2D)g;
        g.setColor(Color.BLACK);
        g.drawString("Probabilidad= "+ d.format(prob), 0, 25);
        g2d.drawString("X", 662, 363);
        g2d.drawString("Y", 354, 18);
    }
}
