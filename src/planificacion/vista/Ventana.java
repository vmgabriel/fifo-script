package planificacion.vista;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import planificacion.modelo.Data;

public class Ventana extends JFrame {

    private JLabel lblId;
    private JTextField txtId;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblTLlegada;

    private JTextField txtTLlegada;
    private JLabel lblTRafaga;
    private JTextField txtTRafaga;

    private JButton btnAgregar;
    private JButton btnGenerar;

    private JPanel panelOpciones;
    //private JButton btnAtender;

    private static final Object[] columnaNombres = {"Id", "Procesado", "Tiempo Llegada", "Tiempo Rafaga", "Tiempo Comienzo", "Tiempo Final", "Tiempo Retorno", "Tiempo Espera"};
    private JTable tabla;
    private DefaultTableModel dtmProcesos;
    private JScrollPane jspProcesos;

    private Lienzo lienzo;
    private JPanel panelLienzo;

    private Data d;

    public Ventana() {
        setLayout(new BorderLayout(0, 0));
        setSize(1200, 750);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Algoritmo SO - I");

        setLocationRelativeTo(null);

        initComponents();
        setVisible(true);
    }

    public void setData(Data a) {
        this.d = a;
    }

    public void initComponents() {

        panelOpciones = new JPanel();

        lblId = new JLabel("Identificador: ");
        panelOpciones.add(lblId);

        txtId = new JTextField();
        txtId.setColumns(5);
        panelOpciones.add(txtId);

        lblNombre = new JLabel("Nombre: ");
        panelOpciones.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setColumns(10);
        panelOpciones.add(txtNombre);

        lblTLlegada = new JLabel("Tiempo Llegada: ");
        panelOpciones.add(lblTLlegada);

        txtTLlegada = new JTextField();
        txtTLlegada.setColumns(5);
        panelOpciones.add(txtTLlegada);

        lblTRafaga = new JLabel("Tiempo Ráfaga: ");
        panelOpciones.add(lblTRafaga);

        txtTRafaga = new JTextField();
        txtTRafaga.setColumns(5);
        panelOpciones.add(txtTRafaga);

        btnAgregar = new JButton("Insertar");
        panelOpciones.add(btnAgregar);

        btnGenerar = new JButton("Generar");
        panelOpciones.add(btnGenerar);

        dtmProcesos = new DefaultTableModel(null, columnaNombres);
        tabla = new JTable(dtmProcesos);
        tabla.setModel(dtmProcesos);
        jspProcesos = new JScrollPane(tabla);

        lienzo = new Lienzo(false);

        lienzo.setBounds(0, 0, 1150, 600);
        panelLienzo = new JPanel();
        panelLienzo.setLayout(null);

        panelLienzo.setSize(1150, 600);

        panelLienzo.add(lienzo);

        panelOpciones.add(lblId);
        panelOpciones.add(txtId);
        panelOpciones.add(lblNombre);
        panelOpciones.add(txtNombre);
        panelOpciones.add(lblTLlegada);
        panelOpciones.add(txtTLlegada);
        panelOpciones.add(lblTRafaga);
        panelOpciones.add(txtTRafaga);
        panelOpciones.add(btnAgregar);
        
        panelLienzo.setBorder(javax.swing.BorderFactory.createTitledBorder("FIFO"));
        
        jspProcesos.setBorder(javax.swing.BorderFactory.createTitledBorder("Algoritmo de Planificacion FCFS"));

        add(panelOpciones, BorderLayout.SOUTH);
        add(jspProcesos, BorderLayout.NORTH);
        add(panelLienzo, BorderLayout.CENTER);

    }

    public void mostarMenssaje(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void rellenarDatos(int id, String nom, int tLlegdada, int tRafaga) {
        txtId.setText(Integer.toString(id));
        txtNombre.setText(nom);
        txtTLlegada.setText(Integer.toString(tLlegdada));
        txtTRafaga.setText(Integer.toString(tRafaga));
    }

    public void refrescar(Object[][] datos) {
        dtmProcesos.setRowCount(0);
        dtmProcesos.setDataVector(datos, columnaNombres);
        getLienzo().setData(datos);
    }

    public Lienzo getLienzo() {
        return lienzo;
    }

    public JLabel getLblId() {
        return lblId;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JLabel getLblTLlegada() {
        return lblTLlegada;
    }

    public JTextField getTxtTLlegada() {
        return txtTLlegada;
    }

    public JLabel getLblTRafaga() {
        return lblTRafaga;
    }

    public JTextField getTxtTRafaga() {
        return txtTRafaga;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JPanel getPanelOpciones() {
        return panelOpciones;
    }

    public static Object[] getColumnaNombres() {
        return columnaNombres;
    }

    public JTable getTabla() {
        return tabla;
    }

    public DefaultTableModel getDtmProcesos() {
        return dtmProcesos;
    }

    public JScrollPane getJspProcesos() {
        return jspProcesos;
    }

    public JPanel getPanelLienzo() {
        return panelLienzo;
    }

    public void addBtnAgregar(ActionListener l) {
        btnAgregar.addActionListener(l);
    }

    public void addBtnGenerar(ActionListener l) {
        btnGenerar.addActionListener(l);
    }
}
