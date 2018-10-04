
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author johannesriedmueller
 */
public class AppointmentGUI extends javax.swing.JFrame {

    private AppointmentBL bl = new AppointmentBL();

    public AppointmentGUI() {
        initComponents();
        liAll.setModel(bl);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        menu = new javax.swing.JMenu();
        miAdd = new javax.swing.JMenuItem();
        miDelete = new javax.swing.JMenuItem();
        miChange = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        liAll = new javax.swing.JList<>();

        menu.setText("Termin");

        miAdd.setText("hinzufügen");
        miAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddActionPerformed(evt);
            }
        });
        menu.add(miAdd);

        miDelete.setText("löschen");
        miDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDeleteActionPerformed(evt);
            }
        });
        menu.add(miDelete);

        miChange.setText("ändern");
        miChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miChangeActionPerformed(evt);
            }
        });
        menu.add(miChange);

        popupMenu.add(menu);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        liAll.setBorder(javax.swing.BorderFactory.createTitledBorder("Termine"));
        liAll.setToolTipText("");
        liAll.setComponentPopupMenu(popupMenu);
        jScrollPane1.setViewportView(liAll);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddActionPerformed
        AppointmentDialog dialog = new AppointmentDialog(this, true);
        dialog.setToChange(false);
        dialog.setVisible(true);
        if (dialog.isOk()) {
            bl.add(dialog.getTermin());
        }
    }//GEN-LAST:event_miAddActionPerformed

    private void miDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDeleteActionPerformed
        if (liAll.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select an item!");
        } else {
            bl.delete(liAll.getSelectedIndex());
        }
    }//GEN-LAST:event_miDeleteActionPerformed

    private void miChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miChangeActionPerformed
        if (liAll.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select an item!");
        } else {
            AppointmentDialog dialog = new AppointmentDialog(this, true);
            dialog.setToChange(true);
            dialog.setTermin(bl.getElementAt(liAll.getSelectedIndex()));
            dialog.setAllTextfields();
            dialog.setVisible(true);
            if (dialog.isOk()) {
                bl.setAppointmentAtIndex(dialog.getTermin(), liAll.getSelectedIndex());
            }
        }
    }//GEN-LAST:event_miChangeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppointmentGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Appointment> liAll;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuItem miAdd;
    private javax.swing.JMenuItem miChange;
    private javax.swing.JMenuItem miDelete;
    private javax.swing.JPopupMenu popupMenu;
    // End of variables declaration//GEN-END:variables
}
