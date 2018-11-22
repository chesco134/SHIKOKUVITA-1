
package GUI;

import Desecho.Desecho;
import Usuarios.ManejadorArchivoUsuarios;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.function.Predicate;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

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
	private JFreeChart panela = null;
	private ChartPanel panel = null;
	private CategoryPlot cp = null;


    public Estadistica(ManejadorArchivoUsuarios fileManager, ArrayList<Desecho> des,MenuPrincipal men){
        this.fileManager = fileManager;
        this.des = des;
		this.men = men;
        doMachin();
    }
    
    private void doMachin() {
		getPeriodo();
		configurarVentana();
		llenarCombo();

        int total = 0 ;
        for(Desecho d : des){
            total += d.getCantidad();
        }

		//faltan
        if(total >= 1400){
                jLabel1.setText("generas demasiada basura al dia (" + total + ") g");
        }else if(total >= 1000){
                jLabel1.setText("Vas bien, pero puede mejorar (" + total + ") g");
        }else if(total < 1000){
                jLabel1.setText("bien! Sigue asi (" + total + ") g");
        }
		

        setVisible(true);
		generardataset(periodo);
		mostrarGrafica(periodoTiempo,datasetgrafica);
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
	private void llenarCombo(){
		jComboBox1.addItem("Todos");
		for(Desecho d:des){
			jComboBox1.addItem(d.getCategoria());
		}
	}

	private void getPeriodo(){

		String [] options = {"OK"};
		Object [] per = {"Corto","Mediano","Largo"};
		JComboBox jcd = new JComboBox(per);
		JLabel jlb = new JLabel("Elige un plazo");
		JPanel pamel = new JPanel();
		pamel.add(jlb);
		pamel.add(jcd);

		int input = JOptionPane.showOptionDialog(null,pamel, "Seleccione un plazo",
        JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,options,
        options[0]);

		setPeriodo(jcd.getSelectedItem());
	}
    
	private void setPeriodo(Object str){
		if(str.equals("Corto")){
			periodo = 7;
			periodoTiempo = "Plazo Corto";
		}else if(str.equals("Mediano")){
			periodo = 49;
			periodoTiempo = "Plazo Mediano";
		}else if(str.equals("Largo")){
			periodo = 365;
			periodoTiempo = "Plazo Largo";
		}
	}
	private DefaultCategoryDataset formatdataset(String categoria){
		
		if(categoria.equals("Todos")){
			return datasetgrafica;
		}
    DefaultCategoryDataset formatgrafica  = datasetgrafica;
	//datasetgrafica.clear();
	
	int posicion = datasetgrafica.getRowIndex(categoria);
	//Comparable rowKey = datasetgrafica.getRowKey(posicion);

	for(int i = 0;i<datasetgrafica.getRowCount() ;i++){
		if(i == posicion){
			//se mantiene
		}else{
			formatgrafica.removeRow(i);
		}
	}
	return formatgrafica;
	}

    private void generardataset(int periodoTiempo){
        int cantidad = 0;
        int j = 0;
		//boolean primeravez = true;
		if(periodoTiempo == 7){
			for(int i = 0; i< periodoTiempo; i++){
        	    j++;
        	    for(Desecho d: des){
        	        if(d.isTipoMasa()){
        	            cantidad = (d.getCantidad());
        	        }else{
        	            cantidad = d.getCantidad() * 1000;
        	        }
        	        datasetgrafica.addValue(cantidad * j / 1000, d.getCategoria(), "dia: " + j);
        	    }
        	}

		}else if(periodoTiempo == 49){

			for(int i = 0; i< 7; i++){
        	    j++;
        	    for(Desecho d: des){
        	        if(d.isTipoMasa()){
        	            cantidad = (d.getCantidad());
        	        }else{
        	            cantidad = d.getCantidad() * 1000;
        	        }
        	        datasetgrafica.addValue(cantidad * (j * 7) / 1000, d.getCategoria(), "semana: " + j);
        	    }
        	}
		
		}else if(periodoTiempo == 365){
			for(int i = 0; i<12; i++){
        	    j++;
        	    for(Desecho d: des){
        	        if(d.isTipoMasa()){
        	            cantidad = (d.getCantidad());
        	        }else{
        	            cantidad = d.getCantidad() * 1000;
        	        }
        	        datasetgrafica.addValue(cantidad * ((j * 7) * 4) / 1000, d.getCategoria(), "mes: " + j);
        	    }
        	}
			
		}

    }
	private void actualizar(DefaultCategoryDataset x){
		cp.setDataset(x);
		panel.getChart().fireChartChanged();
		panel.repaint();
	}
    
    private void mostrarGrafica(String periodoTiempo,DefaultCategoryDataset dcd){
        grafica.setLayout(new BorderLayout());
        panela = ChartFactory.createBarChart("Basura generada", periodoTiempo, "kilogramos", dcd);
		cp = (CategoryPlot) panel.getChart().getPlot();
		panel = new ChartPanel(panela);
        panel.setSize(600, 500);
        grafica.add(panel,0);
    }
//			private void actualizar(DefaultCategoryDataset dcs){
//		
//				grafica().getPlot.setDataset(dcs);
//			}

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
        setBackground(new java.awt.Color(51, 51, 51));
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
                        .addGap(19, 19, 19)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
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
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
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
		//generardataset(periodo);
		//formatdataset(jComboBox1.getSelectedItem().toString());
		//mostrarGrafica(periodoTiempo,formatdataset(jComboBox1.getSelectedItem().toString()));
		//actualizar(formatdataset(jComboBox1.getSelectedItem().toString()));
		//char
		actualizar(formatdataset(jComboBox1.getSelectedItem().toString()));
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
