package baraja;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Principal {

    public int intervalo;
    public double random;
    public int nJuegos;
    DefaultPieDataset dataset = new DefaultPieDataset();
    Carta carta = new Carta();

    public String reparteCartas() {
        String tipoCarta = null;
        for (int i = 0; i < 40; i++) {
            random = (Math.random());
            if (random > 0.00 && random <= 0.25) {
                tipoCarta = "Oro";
            } else if (random > 0.25 && random <= 0.50) {
                tipoCarta = "Copas";
            } else if (random > 0.50 && random <= 0.75) {
                tipoCarta = "Espadas";
            } else if (random > 0.75 && random <= 1.00) {
                tipoCarta = "Bastos";
            }
        }
        return tipoCarta;
    }
}

