package planificacion.modelo;

public class Data {

    private Cola cola;

    public Data() {
        this.cola = new Cola();

    }

    public Object[][] atenderProcesos() {
        // datos de tabla 
        Object[][] datos = new Object[cola.getTamano()][8];
        Nodo nodo = cola.getPrimero().getSig();

        // organizar 
        for (int i = 0; i < cola.getTamano(); i++) {
            datos[i][0] = nodo.getIdProceso();
            datos[i][1] = nodo.getNombreProceso();
            datos[i][2] = nodo.gettLlegada();
            datos[i][3] = nodo.gettRafaga();
            datos[i][4] = nodo.gettComienzo();
            datos[i][5] = nodo.gettFinal();
            datos[i][6] = nodo.gettRetorno();
            datos[i][7] = nodo.gettEspera();

            nodo = nodo.getSig();
        };
        return datos;
    }

    public Cola getCola() {
        return cola;
    }

}
