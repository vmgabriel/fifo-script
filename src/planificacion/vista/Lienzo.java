package planificacion.vista;

import java.awt.*;
import java.awt.Graphics;

public class Lienzo extends Canvas {

    private static int i = 135;
    private boolean ejecuta;
    private int x, y;
    private Object[][] data;

    public Lienzo(Boolean isRun) {
        this.x = i;
        this.y = 10;
        this.ejecuta = isRun;
    }

    // crea trazado de grafico 
    public void dibujarLinea(Graphics g) {
        int longitudGrafico = 50;

        g.setColor(Color.GREEN);
        g.drawLine(x, y, x + longitudGrafico * 20, y);
        g.setColor(Color.black);
        Font fuente = new Font("helvetica", Font.BOLD, 9);
        g.setFont(fuente);
        for (int i = 0; i <= longitudGrafico; i++) {
            g.setColor(Color.GREEN);
            g.drawLine(x + (i * 20), y, x + (i * 20), y + 10);
            g.setColor(Color.black);
            g.drawString("" + i, x + (i * 20) - 2, y + 20);
        }

        x = 5;
        y += 25;

    }

    public void graficaUnProceso(Graphics g, String nombre, int tLlegada, int tComienzo, int tFinal) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.drawString("" + nombre, x+30, y + 10);

        g2.setColor(Color.blue);
        BasicStroke bs = new BasicStroke(5);
        float arreglo[] = {5, 5, 5};
        BasicStroke bs1 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0, arreglo, 0);
        g2.setStroke(bs1);
        g2.drawLine(i + (20 * tLlegada), y + 5, i + (20 * tComienzo), y + 5);

        BasicStroke bs2 = new BasicStroke(0);
        g2.setStroke(bs2);
        g2.drawLine(i + (20 * tComienzo), y + 5, i + (20 * tFinal), y + 5);
        g2.drawLine(i + (20 * tLlegada), y + 1, i + (20 * tLlegada), y + 9);
        g2.drawLine(i + (20 * tComienzo), y + 1, i + (20 * tComienzo), y + 9);
        g2.drawLine(i + (20 * tFinal), y + 1, i + (20 * tFinal), y + 9);

        y += 10;
    }

    @Override
    public void paint(Graphics g) {
        x = i;
        y = 10;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        dibujarLinea(g);

        // si no se ha ejecuado nunca 
        if (ejecuta) {

            dibujaProcesos(g, data);
        }
    }

    public void dibujaProcesos(Graphics g, Object[][] procesos) {

        for (int i = 0; i < procesos.length; i++) {
            graficaUnProceso(g, (String) procesos[i][1], (int) procesos[i][2], (int) procesos[i][4], (int) procesos[i][5]);
        }
    }   

    public void setEjecuta(boolean ejecuta) {
        this.ejecuta = ejecuta;
    }

    public void setData(Object[][] d) {
        data = d;
    }
}
