package planificacion.modelo;

public class Nodo {

    private int idProceso;
    private String nombreProceso;
    //private int nServicios;
    private int tLlegada;
    private int tRafaga;
    private int tComienzo;
    private int tFinal;
    private int tRetorno;
    private int tEspera;
    private Nodo sig;

    public Nodo() {
        this.idProceso = 0;
        this.nombreProceso = "";
        //this.nServicios=0;
        this.sig = null;

        this.tLlegada = 0;
        this.tRafaga = 0;
        this.tComienzo = 0;
        this.tFinal = 0;
        this.tRetorno = 0;
        this.tEspera = 0;
    }

    public int getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(int idProceso) {
        this.idProceso = idProceso;
    }

    public String getNombreProceso() {
        return nombreProceso;
    }

    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public int gettLlegada() {
        return tLlegada;
    }

    public void settLlegada(int tLlegada) {
        this.tLlegada = tLlegada;
    }

    public int gettRafaga() {
        return tRafaga;
    }

    public void settRafaga(int tRafaga) {
        this.tRafaga = tRafaga;
    }

    public int gettComienzo() {
        return tComienzo;
    }

    public void settComienzo(int tComienzo) {
        this.tComienzo = tComienzo;
    }

    public int gettFinal() {
        return tFinal;
    }

    public void settFinal(int tFinal) {
        this.tFinal = tFinal;
    }

    public int gettRetorno() {
        return tRetorno;
    }

    public void settRetorno(int tRetorno) {
        this.tRetorno = tRetorno;
    }

    public int gettEspera() {
        return tEspera;
    }

    public void settEspera(int tEspera) {
        this.tEspera = tEspera;
    }

}
