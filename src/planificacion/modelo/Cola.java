package planificacion.modelo;

public class Cola {

    private Nodo ultimo;
    private Nodo primero;
    private int tamano;

    public Cola() {
        tamano = 0;
        primero = new Nodo();
        primero.setNombreProceso("FCFS");
        primero.setSig(ultimo);
        ultimo = primero;
        ultimo.setSig(primero);
    }

    /**
     * Implementacion del algortinmo *
     */
    public String insertar(int id, String nombre, int tLlegada, int tRafaga) {
        
        String msg="";
        
        Nodo q = new Nodo();
        q.setIdProceso(id);
        q.setNombreProceso(nombre);
        q.settLlegada(tLlegada);
        q.settRafaga(tRafaga);

        // forzamos para que empiece el primero de una 
        if (ultimo.gettFinal() == 0) {
            q.settComienzo(tLlegada);
        } else {
            q.settComienzo(ultimo.gettFinal());
        }

        q.settFinal(tRafaga + q.gettComienzo());
        q.settRetorno(q.gettFinal() - q.gettLlegada());
        q.settEspera(q.gettRetorno() - q.gettRafaga());

        //Forzando no datos negativos 
        if (q.gettEspera() < 0) {
            q.settEspera(0);
        }

        q.setSig(primero);

        primero.settFinal(q.gettFinal());

        ultimo.setSig(q);
        ultimo = q;

        tamano++;
        return msg;
    }

    public Nodo retirar() {
        Nodo aux = primero.getSig();
        if (aux != primero) {
            primero.setSig(aux.getSig());
            if (aux == ultimo) {
                ultimo = aux.getSig();
            }
            aux.setSig(null);
            tamano--;
        }
        return aux;

        /*if(aux==p){
            return aux;
        }
        if(aux!=cab){  
            p.setSig(aux.getSig());
            aux.setSig(null);
            return aux;
        }
        else{
            cab=aux.getSig();
        }*/
    }

    public boolean isVacia() {
        boolean val = false;
        if (primero == ultimo) {
            val = true;
        }
        return val;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public int getTamano() {
        return tamano;
    }

}
