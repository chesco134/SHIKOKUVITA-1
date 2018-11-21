package GUI;


import IO.LectorArchivo;
import Usuarios.ManejadorArchivoUsuarios;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
import Categorias.*;
import Desecho.Desecho;
import java.awt.Event;
import java.awt.event.KeyEvent;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class MenuPrincipal extends javax.swing.JFrame {
	

    private ManejadorArchivoUsuarios fileManager;
    private ManejoArchivoCategorias categoriesManager;
	private ArrayList<Desecho> cantidades = new ArrayList<>();
	private String nombreBotonsel = "";

	private JToggleButton sel = null;
    
    public MenuPrincipal(ManejadorArchivoUsuarios fileManager, ManejoArchivoCategorias categoriesManager){
        this.fileManager = fileManager;
        this.categoriesManager = categoriesManager;
        try{
            this.categoriesManager
                    .recuperaCategorias(URLDecoder.decode(ModAdmin.class.getResource("/shikokuvita/Categorias")
                            .getFile(),"UTF-8"));
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
        doMachin();
}

    private void doMachin() {

		LectorArchivo la = new LectorArchivo();
		try{
		jTextField2.setTransferHandler(null);
		}catch(NullPointerException ex){
				ex.printStackTrace();
		}

        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imágenes/logo.PNG")).getImage());
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setBounds((ancho / 2) - (this.getWidth() / 2),  (alto / 2) - (this.getHeight() / 2),1054 , 612);
		//jPanel1.setBackground(new java.awt.Color(0, 102, 0));
        jPanel1.setToolTipText(null);
		jPanel2.setToolTipText(null);
		jPanel3.setToolTipText(null);

        //jPanel2.setBackground(new java.awt.Color(255, 255, 255));
		//jPanel2.setPreferredSize(new Dimension(847, 574));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setText("¿Cómo calculo mis residuos con Shikoku Vita?");

		
        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setText("Ingresa la cantidad de basura que generaste");

		buttonGroup1.add(kg);
		buttonGroup1.add(gramos);

		setInvisibleInicio();
		
		Desecho des = new Desecho("",0,false);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText(la.LectorArchivoLinea(new File("src/Archivos/Introduccion/introduccion.txt")));
		jScrollPane1.add(jTextArea1);
        jScrollPane1.setViewportView(jTextArea1);
		categorias();

		InputMap map = jTextField2.getInputMap(jTextField2.WHEN_FOCUSED);
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
		map.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.SHIFT_MASK), "null");
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jTextField2 = new javax.swing.JTextField();
        gramos = new javax.swing.JToggleButton();
        kg = new javax.swing.JToggleButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        categoriasScroll = new javax.swing.JScrollPane();
        flowPanel = new javax.swing.JPanel();
        categorias = new javax.swing.JPanel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 30));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(20, 32767));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLayeredPane1.setForeground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setToolTipText("");
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setWheelScrollingEnabled(false);

        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("jLabel2");

        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jButton6.setText("Guadar cambios");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton10.setText("Generar estadística");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        gramos.setText("gramos");
        gramos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gramosActionPerformed(evt);
            }
        });

        kg.setText("kilogramos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(gramos, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(kg, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jButton10)
                        .addGap(29, 29, 29))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kg)
                            .addComponent(gramos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, 6, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton10))
                        .addContainerGap())))
        );

        jButton7.setText("Cerrar sesion");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("¿Cómo calculo mis reisduos con Shikoku Vita?");

        categoriasScroll.setBackground(new java.awt.Color(51, 51, 51));
        categoriasScroll.setForeground(new java.awt.Color(255, 255, 255));

        flowPanel.setBackground(new java.awt.Color(51, 51, 51));
        flowPanel.setForeground(new java.awt.Color(255, 255, 255));
        flowPanel.setPreferredSize(new java.awt.Dimension(121, 660));

        categorias.setBackground(new java.awt.Color(51, 51, 51));
        categorias.setForeground(new java.awt.Color(255, 255, 255));
        categorias.setLayout(new java.awt.GridLayout(1, 0));
        flowPanel.add(categorias);

        categoriasScroll.setViewportView(flowPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7)
                    .addComponent(categoriasScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(433, 433, 433)
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(337, 337, 337))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(categoriasScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1054, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
		this.pack();
    }//GEN-LAST:event_formComponentResized

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
		Estadistica es = new Estadistica(fileManager, cantidades);
		//this.dispose();
		es.setVisible(true);

    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        InicioDeSesion ids = new InicioDeSesion(fileManager, categoriesManager);
        this.dispose();
        ids.setVisible(true);
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
		String texto = jTextField2.getText();
		int posicion;
		if(cantidades.size() == categoriesManager.getUsuarios().length - 1){
			jButton10.setVisible(true);
		}else{
			jButton10.setVisible(false);
		}
		System.out.println(cantidades.size());
		System.out.println(categoriesManager.getUsuarios().length);
		if(texto.equals("")){
            JOptionPane.showMessageDialog(this, "No hay ningun valor seleccionado", "Falta de valor", JOptionPane.ERROR_MESSAGE);
		}else{
			Desecho des = new Desecho(nombreBotonsel, Integer.parseInt(texto),botonABooleano());
			if(cantidades.contains(des)){
				posicion = cantidades.indexOf(des);
				cantidades.set(posicion, des);
			}else{
				cantidades.add(des);
			}
			}
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void gramosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gramosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gramosActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped

		char c = evt.getKeyChar();
		int tam = jTextField2.getText().length();
		if(tam >= 10){
		    evt.consume();
		            }else{
		if ((Character.isDigit(c))) {
		} else {
		    evt.consume();
		}}
    }//GEN-LAST:event_jTextField2KeyTyped
	private boolean botonABooleano(){
		if(gramos.isSelected()){
			return true;
		}else{
			return false;
		}
	}
	
	private JToggleButton booleanoABoton(boolean b){
		if(b){
			return gramos;
		}else{
			return kg;
		}
	}
	
	private void categorias(){
		ButtonGroup bg = new ButtonGroup();

        categorias.setLayout(new GridBagLayout());
		GridBagConstraints gb = new GridBagConstraints();
		gb.anchor = GridBagConstraints.NORTH;
		gb.fill = GridBagConstraints.NONE;
		gb.weighty = 1.0;
		gb.gridy = GridBagConstraints.RELATIVE;
		gb.gridwidth = 0;
		
        categorias.setLayout(new BoxLayout(categorias, 1));
        for(int i=0; i<categoriesManager.getUsuarios().length;i++){
            JToggleButton button = new JToggleButton(categoriesManager.getUsuarios()[i].getNombreCategoria());
            button.setPreferredSize(new Dimension(130,90));
            button.setMinimumSize(new Dimension(130,90));
            button.setMaximumSize(new Dimension(130,90));
			button.setName("" + i);
			
			button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JToggleButton toggled =(JToggleButton) e.getSource();
				if(!nombreBotonsel.equals(toggled.getActionCommand())){

				LectorArchivo la = new LectorArchivo();
				Random rn = new Random();
				int rand = rn.nextInt(10 - 1 + 1) + 1;
        		jTextArea1.setText(la.LectorArchivoLinea(new File("src/Archivos/DatosCuriosos/" + rand + ".txt")));
				
				gramos.setSelected(true);
				setVisibleInicio();
					
				nombreBotonsel = toggled.getActionCommand();
				if(cantidades.contains(new Desecho(nombreBotonsel, 0, false))){
					jTextField2.setText(Integer.toString(obtenerDesCategoria(nombreBotonsel).getCantidad()));
					boolean prueba = obtenerDesCategoria(nombreBotonsel).isTipoMasa();
					booleanoABoton(prueba).doClick();
				}else{
					jTextField2.setText("");
				}

						
				jLabel1.setText(nombreBotonsel);
				}
					
				
        		    }
        		});
			
			bg.add(button);
            categorias.add(button, gb);
        }
		flowPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		flowPanel.setLayout(new BorderLayout());
		flowPanel.setVisible(true);
		flowPanel.add(categorias);
		categoriasScroll.add(flowPanel);
		categoriasScroll.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
		categoriasScroll.getVerticalScrollBar().setUnitIncrement(16);
		categoriasScroll.setViewportView(categorias);
		categoriasScroll.setVisible(true);
		
	}
	
	private Desecho obtenerDesCategoria(String name){
		for (Desecho c : cantidades) {
		    if (c.getCategoria().equals(name)) {
		        return c;
		    }
		}
	return null;
	}

	private void setInvisibleInicio(){

		//jPanel3.setVisible(false);
		//jPanel2.setVisible(false);
		
		
		jLabel1.setVisible(true);
		jLabel2.setVisible(false);
		jTextField2.setVisible(false);
		gramos.setVisible(false);
		kg.setVisible(false);
		jButton6.setVisible(false);
		jButton10.setVisible(false);
		
	}

	private void setVisibleInicio(){

		jPanel3.setVisible(true);
		jPanel2.setVisible(true);
		jLabel1.setVisible(true);
		jLabel2.setVisible(true);
		jTextField2.setVisible(true);
		gramos.setVisible(true);
		kg.setVisible(true);
		jButton6.setVisible(true);
		//jButton10.setVisible(true);
		

	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel categorias;
    private javax.swing.JScrollPane categoriasScroll;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JPanel flowPanel;
    private javax.swing.JToggleButton gramos;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToggleButton kg;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables

}
