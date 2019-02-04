package planificacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import planificacion.modelo.Data;
import planificacion.vista.Ventana;

public class Gestor {

    private Ventana ventana;
    private Data data;

    int MIN_TURNO = 1;
    int MAX_TURNO = 10;

    public Gestor() {
        this.data = new Data();
        this.ventana = new Ventana();

        ventana.addBtnAgregar(new ListenerBtnAtender());
        ventana.addBtnGenerar(new ListenerBtnGenerar());

    }

    public void agregarProceso(int id, String nombre, int tLlegada, int tRafaga) {
       
        data.getCola().insertar(id, nombre, tLlegada, tRafaga);

        //Ordenar 
        ventana.mostarMenssaje("Se ha insertado el proceso");

        ventana.refrescar(data.atenderProcesos());
        ventana.getLienzo().setEjecuta(true);
        ventana.getLienzo().repaint();
    }

    public int generarNumero(int inicio, int fin) {
        int valorEntero = (int) Math.floor(Math.random() * (fin - inicio + 1) + inicio);
        return valorEntero;
    }

    public Data getData() {
        return data;
    }

///////////////////////////////////////Listeners///////////////////////////////////
    class ListenerBtnAtender implements ActionListener {

        public void actionPerformed(ActionEvent a) {

            try {
                agregarProceso(Integer.parseInt(ventana.getTxtId().getText()), ventana.getTxtNombre().getText(), Integer.parseInt(ventana.getTxtTLlegada().getText()), Integer.parseInt(ventana.getTxtTRafaga().getText()));
            } catch (NumberFormatException e) {
                ventana.mostarMenssaje("Error de ingreso");
            }
        }
    }

    class ListenerBtnGenerar implements ActionListener {

        public void actionPerformed(ActionEvent a) {
            try {
                ventana.rellenarDatos(generarNumero(MIN_TURNO, MAX_TURNO), String.valueOf((char) generarNumero(65, 91)), generarNumero(MIN_TURNO, MAX_TURNO), generarNumero(MIN_TURNO, MAX_TURNO));
            } catch (NumberFormatException e) {
                ventana.mostarMenssaje("Genaracion");
            }
        }
    }
}
