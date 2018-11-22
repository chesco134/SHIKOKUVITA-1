
package GUI;

import Desecho.Desecho;
import Usuarios.ManejadorArchivoUsuarios;
import com.sun.org.apache.xpath.internal.axes.WalkerFactory;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import java.lang.Math;

/**
 *
 * @author Josué
 */

public class Estadistica extends javax.swing.JFrame{
	
    private ManejadorArchivoUsuarios fileManager;
	private MenuPrincipal men;
    private ArrayList<Desecho> des;
    private DefaultCategoryDataset datasetgrafica  = new DefaultCategoryDataset();
	private int periodo = 0;
	private String periodoTiempo;

    public Estadistica(ManejadorArchivoUsuarios fileManager, ArrayList<Desecho> des,MenuPrincipal men){
        this.fileManager = fileManager;
        this.des = des;
		this.men = men;
        doMachin();
    }
    
    private void doMachin() {
		getPeriodo();
		configurarVentana();

        int total = 0 ;
        for(Desecho d : des){
            total += d.getCantidad();
        }

		//faltan
        if(total >= 1400){
                jLabel1.setText("generas demasiada basura al dia");
        }else if(total >= 1000){
                jLabel1.setText("Vas bien, pero puede mejorar");
        }else if(total < 1000){
                jLabel1.setText("bien! Sigue asi");
        }


        setVisible(true);

		generardataset(periodo);
		mostrarGrafica(periodoTiempo);
    }
	private void configurarVentana(){

        initComponents();
        JPanel panel = new JPanel();
        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setBounds((ancho / 2) - (this.getWidth() / 2),  (alto / 2) - (this.getHeight() / 2),1080 , 720);
        this.setSize(1080, 720);
        grafica.setPreferredSize(new Dimension(100, 100));
        grafica.setMaximumSize(new Dimension(100, 100));
        grafica.setMinimumSize(new Dimension(100, 100));
        this.setMaximumSize(new Dimension(1080, 720));
        this.setPreferredSize(new Dimension(900, 720));
        this.setMinimumSize(new Dimension(900, 720));


        getContentPane().add(panel);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	private void getPeriodo(){

		Object [] per = {"Corto","Mediano","Largo"};
		JComboBox jcd = new JComboBox(per);

		Object input = JOptionPane.showInputDialog(null,"Elige un plazo", "Seleccione un plazo",
        JOptionPane.QUESTION_MESSAGE, null, per,
        per[0]);

		if(input == null || (input != null && ("".equals(input)))){
			this.dispose();
			men.setVisible(true);
		}else{
			setPeriodo(input);
		}
	}
    
	private void setPeriodo(Object str){
		if(str.equals("Corto")){
			periodo = 7;
			periodoTiempo = "Plazo Corto";
		}else if(str.equals("Mediano")){
			periodo = 40;
			periodoTiempo = "Plazo Mediano";
		}else if(str.equals("Largo")){
			periodo = 365;
			periodoTiempo = "Plazo Largo";
		}
	}
    private void generardataset(int periodoTiempo){
        double cantidad = 0d;
        int j = 0;
        boolean primeravez = true;
        for(int i = 0; i< periodoTiempo; i++){
            j++;
            for(Desecho d: des){
                System.out.println(i);
                if(!d.isTipoMasa()){
                    cantidad = (d.getCantidad());
                }else{
                    cantidad = d.getCantidad() * 1000;
                }
                if(!primeravez){
                    cantidad = (Math.random() * ((cantidad + 200 - cantidad) + 1)) + cantidad;
                }
                datasetgrafica.addValue(cantidad, d.getCategoria(), "dia: " + j);
                primeravez = false;
            }
        }
    }
    
    private void mostrarGrafica(String periodoTiempo){
        grafica.setLayout(new BorderLayout());
        JFreeChart panela = ChartFactory.createBarChart("Basura generada", periodoTiempo, "gramos", datasetgrafica);
        ChartPanel panel = new ChartPanel(panela);
        panel.setSize(900, 500);
        grafica.add(panel,0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton9 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        grafica = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grafica");
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(102, 153, 0));
        setLocation(new java.awt.Point(0, 0));
        setPreferredSize(new java.awt.Dimension(1080, 720));
        setResizable(false);

        jButton9.setText("Cerrar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Informacion referente a la estadistica");

        grafica.setForeground(new java.awt.Color(255, 255, 255));
        grafica.setMinimumSize(new java.awt.Dimension(400, 400));
        grafica.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout graficaLayout = new javax.swing.GroupLayout(grafica);
        grafica.setLayout(graficaLayout);
        graficaLayout.setHorizontalGroup(
            graficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        graficaLayout.setVerticalGroup(
            graficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Corto", "Mediano", "Largo" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Seleccionar categoria");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(grafica, javax.swing.GroupLayout.DEFAULT_SIZE, 1435, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton1)
                        .addGap(66, 66, 66)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(60, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(grafica, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9))
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
		this.dispose();
		men.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		
		generardataset(periodo);
		mostrarGrafica(periodoTiempo);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel grafica;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
