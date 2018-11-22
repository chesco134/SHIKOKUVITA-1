/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Usuarios.ManejadorArchivoUsuarios;
import Usuarios.Usuario;
import Seguridad.MD5HAsh;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Categorias.*;
import java.awt.Event;
import java.awt.event.KeyEvent;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

/**
 *
 * @author tetra
 */
public class ModAdmin extends javax.swing.JFrame {


    private ManejadorArchivoUsuarios fileManager;
    private ManejadorArchivoUsuarios bkpFileManager;
    private ManejoArchivoCategorias categoriesManager;
    private ManejoArchivoCategorias bkpCategoriesManager;
    private int auxiliar = 0;
	
    public ModAdmin(ManejadorArchivoUsuarios fileManager, ManejoArchivoCategorias categoriesManager){
        this.fileManager = fileManager;
        bkpFileManager = new ManejadorArchivoUsuarios();
        bkpCategoriesManager = new ManejoArchivoCategorias();
        for(Usuario usuario : fileManager.getUsuarios())
            bkpFileManager.agregarusuario(usuario);
        for(Categoria categoria : categoriesManager.getUsuarios())
            bkpCategoriesManager.agregarCategoria(categoria);
        this.categoriesManager = categoriesManager;
        try{
            this.categoriesManager
                    .recuperaCategorias(URLDecoder.decode(ModAdmin.class.getResource("/shikokuvita/Categorias")
                            .getFile(),"UTF-8"));
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
        try {
                fileManager.recuperarUsuarioActual(URLDecoder.decode(IniciarSesion.class.getResource("/shikokuvita/forbiddenmemories2").getFile(),"UTF-8"));
        } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(ModAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        doMachin();
    }
	private void doMachin() {
            initComponents();
            int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
            int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
            this.setBounds((ancho / 2) - (this.getWidth() / 2),  (alto / 2) - (this.getHeight() / 2),976,296);
            jPanel1.setToolTipText(null);
			agregarCategorias.setDocument
			(new JTextFieldLimit(15));
            recargaCombo(true);
            recargarCategoria();
		    InputMap map2 = agregarCategorias.getInputMap(agregarCategorias.WHEN_FOCUSED);
    	    map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
	}
        
        private void guardarCambios(){
            try {
                fileManager.guardaUsuarios(URLDecoder.decode(getClass().getResource("/shikokuvita/forbiddenmemories").getFile(),"UTF-8"));
                categoriesManager.guardaCategorias(URLDecoder.decode(getClass().getResource("/shikokuvita/Categorias").getFile(),"UTF-8"));
                bkpFileManager = fileManager;
                bkpCategoriesManager = categoriesManager;
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(ModAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboUsuarios = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Categorias = new javax.swing.JComboBox<>();
        EliminarCategoria = new javax.swing.JButton();
        agregarCategorias = new javax.swing.JTextField();
        AgregarCategoria = new javax.swing.JButton();
        EliminarUsuario = new javax.swing.JButton();
        RecuperarContrasena = new javax.swing.JButton();
        comboRecuperar = new javax.swing.JComboBox<>();
        CerrarSesion = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(988, 400));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Modificar Usuarios");

        jLabel2.setText("Seleccionar Usuario");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Modificar Categorias");

        jLabel4.setText("Seleccionar Categoria");

        EliminarCategoria.setText("Eliminar Categoria");
        EliminarCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EliminarCategoriaMouseClicked(evt);
            }
        });

        agregarCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCategoriasActionPerformed(evt);
            }
        });
        agregarCategorias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                agregarCategoriasKeyTyped(evt);
            }
        });

        AgregarCategoria.setText("Agregar Categoria");
        AgregarCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AgregarCategoriaMouseClicked(evt);
            }
        });

        EliminarUsuario.setText("Eliminar usuario");
        EliminarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EliminarUsuarioMouseClicked(evt);
            }
        });
        EliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarUsuarioActionPerformed(evt);
            }
        });

        RecuperarContrasena.setText("Recuperar Contrasena");
        RecuperarContrasena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RecuperarContrasenaMouseClicked(evt);
            }
        });

        CerrarSesion.setText("Cerrar Sesion");
        CerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerrarSesionMouseClicked(evt);
            }
        });

        jButton1.setText("Guardar Cambios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(290, 290, 290)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(EliminarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(RecuperarContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboUsuarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboRecuperar, 0, 194, Short.MAX_VALUE))
                                .addGap(92, 92, 92)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(EliminarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(AgregarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(agregarCategorias)
                                    .addComponent(Categorias, 0, 194, Short.MAX_VALUE))))
                        .addGap(0, 56, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EliminarUsuario)
                    .addComponent(EliminarCategoria)
                    .addComponent(Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(agregarCategorias, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RecuperarContrasena)
                        .addComponent(comboRecuperar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AgregarCategoria)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarSesionMouseClicked
        InicioDeSesion ids = new InicioDeSesion(bkpFileManager, bkpCategoriesManager);
        this.dispose();
        ids.setVisible(true);
    }//GEN-LAST:event_CerrarSesionMouseClicked
	
    private void recargarCategoria(){
        if(categoriesManager.getUsuarios().length == 0){
			Categorias.removeAllItems();
			Categorias.addItem("no hay categorias");
        }else{
			Categorias.removeAllItems();
            for(Categoria categoria : categoriesManager.getUsuarios())
                Categorias.addItem(categoria.getNombreCategoria());
		}
    }

    private void AgregarCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AgregarCategoriaMouseClicked
		String str = agregarCategorias.getText();
                boolean trel = true;
                Categoria cat;
                trel = categoriesManager.checkCategoria(str, trel);
		if(!str.equals("")){
                    if(trel){
                        cat = new Categoria();
                        cat.setNombreCategoria(str);
			categoriesManager.agregarCategoria(cat);
			recargarCategoria();
                    }else{
                        JOptionPane.showMessageDialog(null,"No puede haber categorias iguales.","Aviso",JOptionPane.INFORMATION_MESSAGE);
                    }
		}else{
			JOptionPane.showMessageDialog(null,"No puede ingresar una categoria vacia","Aviso",JOptionPane.INFORMATION_MESSAGE);
		}
        agregarCategorias.setText("");
    }//GEN-LAST:event_AgregarCategoriaMouseClicked

    private void EliminarCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarCategoriaMouseClicked
		if(categoriesManager.getUsuarios().length == 0){
            JOptionPane.showMessageDialog(this, "No hay categorias", "Falta de categorias", JOptionPane.ERROR_MESSAGE);
		}else{
			String nombreCategoria;
        	nombreCategoria = (String)Categorias.getSelectedItem();
        	categoriesManager.quitaCategorias(nombreCategoria);
			Categorias.removeItemAt(Categorias.getSelectedIndex());
		}
		recargarCategoria();
    }//GEN-LAST:event_EliminarCategoriaMouseClicked

    private void EliminarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarUsuarioMouseClicked
    }//GEN-LAST:event_EliminarUsuarioMouseClicked

    private void RecuperarContrasenaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RecuperarContrasenaMouseClicked
        if(fileManager.getUsuarios().length == 0){
            JOptionPane.showMessageDialog(this, "No hay usuarios", "Falta de usuarios", JOptionPane.ERROR_MESSAGE);
        }else{
            String theName = (String)comboRecuperar.getSelectedItem();
            String newPass="";
            boolean trul = true;
            String passwd = JOptionPane.showInputDialog(null, "Ingrese la nueva contrasena", "Recuperar contrasena", JOptionPane.QUESTION_MESSAGE);
            String passwdconf = JOptionPane.showInputDialog(null, "Ingrese de nuevo la contrasena", "Recuperar contrasena", JOptionPane.QUESTION_MESSAGE);
			if(passwd.equals(passwdconf)){
            if(passwd != null){
                newPass = passwd;
                trul = true;
            }else{
                trul = false;
            }
            if(trul){
                if (newPass.matches(".*[a-zñ].*")
                        && newPass.matches(".*[A-ZÑ].*")
                        && newPass.matches(".*[0-9].*")
                        && newPass.matches(".*[^A-Za-zñÑ0-9 ].*")
                        && newPass.length() > 4){
                    fileManager.getUserByName(theName).setNewPasswd(new MD5HAsh().makeHash(newPass));
                } else {
                    JOptionPane.showMessageDialog(this, "La contraseña es débil, debe tener al menos una letra mayúscula, una minúscula, un número, un símbolo y mínimo 5 caracteres.", "Contraseña Débil", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Cancelado.", "Cancelado", JOptionPane.ERROR_MESSAGE);
            }
			}else{
                JOptionPane.showMessageDialog(this, "Las contrasenas no coinciden", "Cancelado", JOptionPane.ERROR_MESSAGE);
			}
        }
    }//GEN-LAST:event_RecuperarContrasenaMouseClicked

    private void EliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarUsuarioActionPerformed
        if(fileManager.getUsuarios().length == 0){
            JOptionPane.showMessageDialog(this, "No hay usuarios", "Falta de usuarios", JOptionPane.ERROR_MESSAGE);
        }else{
            int x = comboUsuarios.getSelectedIndex();
            boolean trel;
            int j=comboUsuarios.getItemCount();
            if(auxiliar < j+1){
                trel = false;
            }else{
                trel = true;
            }
            if(!trel){
                if(comboUsuarios.getItemCount()!= 0){        
                    int result = JOptionPane.showConfirmDialog(null, "Esta seguro?", "InfoBox: " + "confirmar", JOptionPane.OK_CANCEL_OPTION);
                    if(result == JOptionPane.OK_OPTION){
                        fileManager.quitaUsuario(x);
                        comboUsuarios.removeItemAt(x);
                        comboRecuperar.removeItemAt(x);
                        auxiliar++;
                    }
				}
            }else{
                JOptionPane.showMessageDialog(null, "Ya no hay usuarios para borrar", "Sin usuarios", JOptionPane.ERROR_MESSAGE);
            }
        }
        recargaCombo(false);
    }//GEN-LAST:event_EliminarUsuarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        guardarCambios();
        JOptionPane.showMessageDialog(this, "Cambios guardados", "Guardado exitoso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void agregarCategoriasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_agregarCategoriasKeyTyped
        char c = evt.getKeyChar();
        if ((Character.isAlphabetic(c))) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_agregarCategoriasKeyTyped

    private void agregarCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCategoriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregarCategoriasActionPerformed

    private void recargaCombo(boolean fromFile){
        Usuario [] us = null;
        if(fromFile)
            try {
                    us = fileManager.recuperaUsuarios(URLDecoder.decode(ManejadorArchivoUsuarios.class.getResource("/shikokuvita/forbiddenmemories").getFile(),"UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(ModAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        else
            us = fileManager.getUsuarios();
        if(fileManager.getUsuarios().length == 0){
            comboUsuarios.removeAllItems();
            comboRecuperar.removeAllItems();
            comboUsuarios.addItem("no hay usuarios");
            comboRecuperar.addItem("no hay usuarios");
        }else{
            comboUsuarios.removeAllItems();
            comboRecuperar.removeAllItems();
            for (Usuario u : us) {
                comboUsuarios.addItem(u.getNombreUsuario());
            }
            for (Usuario u : us) {
                comboRecuperar.addItem(u.getNombreUsuario());
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarCategoria;
    private javax.swing.JComboBox<String> Categorias;
    private javax.swing.JButton CerrarSesion;
    private javax.swing.JButton EliminarCategoria;
    private javax.swing.JButton EliminarUsuario;
    private javax.swing.JButton RecuperarContrasena;
    private javax.swing.JTextField agregarCategorias;
    private javax.swing.JComboBox<String> comboRecuperar;
    private javax.swing.JComboBox<String> comboUsuarios;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
