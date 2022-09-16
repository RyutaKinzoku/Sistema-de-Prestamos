package prestamos;

import logic.Sistema;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 * @author Andrey Badilla && Kenneth Ibarra
 */
public class ventanaItem extends javax.swing.JDialog {

    private String nombre;
    private boolean editar = false;

    public ventanaItem(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        Sistema s = Sistema.getInstance();
        ArrayList<String> tipos = s.tiposToString();
        jComboBoxTipo.setModel(new DefaultComboBoxModel(tipos.toArray()));
        this.nombre = jTextNombre.getText();
        jComboBoxTipo.setEnabled(false);
        jButtonAgregarC.setEnabled(false);
        jButtonEliminarC.setEnabled(false);
        jComboBoxCategoriasSis.setEnabled(false);
    }

    public ventanaItem(java.awt.Frame parent, boolean modal, String nombre, boolean editar) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        Sistema s = Sistema.getInstance();
        this.nombre = nombre;
        cargarDatos();
        this.editar = editar;
        if (!editar) {
            jTextNombre.setEnabled(editar);
            jComboBoxTipo.setEnabled(editar);
            jListCategoria.setEnabled(editar);
            jButtonAgregarC.setEnabled(editar);
            jButtonEliminarC.setEnabled(editar);
        }
    }
    public void cargarDatos() {
        Sistema s = Sistema.getInstance();
        jTextNombre.setText(nombre);
        ArrayList<String> tipos = s.tiposToString();
        jComboBoxTipo.setModel(new DefaultComboBoxModel(tipos.toArray()));
        try {
            jComboBoxTipo.setSelectedItem(s.getTipoItem(nombre));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        ArrayList<String> categoriasSis = s.categoriasToString();
        jComboBoxCategoriasSis.setModel(new DefaultComboBoxModel(categoriasSis.toArray()));
        jComboBoxCategoriasSis.setSelectedItem(-1);
        DefaultListModel<String> listModel = new DefaultListModel();
        ArrayList<String> categorias = null;
        try {
            categorias = s.getCategoriasItem(nombre);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        for(String str: categorias)
            listModel.addElement(str);
        jListCategoria.setModel(listModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListCategoria = new javax.swing.JList<>();
        jButtonAgregarC = new javax.swing.JButton();
        jButtonEliminarC = new javax.swing.JButton();
        jComboBoxCategoriasSis = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setText("Nombre:");

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo:");

        jLabel3.setText("Categorías:");

        jScrollPane1.setViewportView(jListCategoria);

        jButtonAgregarC.setText("Agregar");
        jButtonAgregarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarCActionPerformed(evt);
            }
        });

        jButtonEliminarC.setText("Eliminar");
        jButtonEliminarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jButtonAceptar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonCancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButtonAgregarC)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonEliminarC))
                                    .addComponent(jComboBoxCategoriasSis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextNombre)
                            .addComponent(jComboBoxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(88, 88, 88))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jComboBoxCategoriasSis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonEliminarC)
                            .addComponent(jButtonAgregarC))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        Sistema s = Sistema.getInstance();
        if(s.existeItem(nombre)){
            if (editar) {
                ListModel<String> categorias = jListCategoria.getModel();
                try {
                    s.modificarItem(nombre, jTextNombre.getText(), jComboBoxTipo.getSelectedItem().toString());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else{
            s.crearItem(jTextNombre.getText());
        }
        dispose();
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAgregarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarCActionPerformed
        Sistema s = Sistema.getInstance();
        String c = (String) jComboBoxCategoriasSis.getSelectedItem();
        try {
            if (!s.itemContainsCategoria(nombre, c)){
                s.agregarCategoriaItem(nombre , c);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        cargarDatos();
    }//GEN-LAST:event_jButtonAgregarCActionPerformed

    private void jButtonEliminarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarCActionPerformed
        Sistema s = Sistema.getInstance();
        if(!jListCategoria.isSelectionEmpty()){
            String c = jListCategoria.getSelectedValue();
            try {
                s.borrarCategoriaItem(nombre , c);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        cargarDatos();
    }//GEN-LAST:event_jButtonEliminarCActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        Sistema sistema = Sistema.getInstance();
        String mensaje = sistema.revisarAlarmas();
        if(mensaje != null)
            JOptionPane.showMessageDialog(null, mensaje, "Alarma", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAgregarC;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEliminarC;
    private javax.swing.JComboBox<String> jComboBoxCategoriasSis;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jListCategoria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextNombre;
    // End of variables declaration//GEN-END:variables
}
