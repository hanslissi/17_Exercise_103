
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class AppointmentDialog extends javax.swing.JDialog {

    private Appointment termin;
    private boolean ok;
    private LocalDateTime dateTime;
    private String text;
    private boolean toChange;
    private static DateTimeFormatter dtf;

    static {
        dtf = DateTimeFormatter.ofPattern("");
    }

    public AppointmentDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfDay = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfMonth = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfYear = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfHour = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfMinute = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfText = new javax.swing.JTextField();
        btOK = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(7, 2));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Tag:");
        getContentPane().add(jLabel1);

        tfDay.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfDay.setText("3");
        getContentPane().add(tfDay);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Monat:");
        getContentPane().add(jLabel2);

        tfMonth.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfMonth.setText("10");
        getContentPane().add(tfMonth);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Jahr:");
        getContentPane().add(jLabel3);

        tfYear.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfYear.setText("2018");
        getContentPane().add(tfYear);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Stunde:");
        getContentPane().add(jLabel4);

        tfHour.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfHour.setText("8");
        getContentPane().add(tfHour);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Minute:");
        getContentPane().add(jLabel5);

        tfMinute.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfMinute.setText("0");
        getContentPane().add(tfMinute);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Text:");
        getContentPane().add(jLabel6);

        tfText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfText.setText("NVS HÜ");
        getContentPane().add(tfText);

        btOK.setText("Übernehmen");
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOKActionPerformed(evt);
            }
        });
        getContentPane().add(btOK);

        btCancel.setText("Abbrechen");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btCancel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Appointment getTermin() {
        return termin;
    }

    public boolean isOk() {
        return ok;
    }

    public void setTermin(Appointment termin) {
        this.termin = termin;
    }

    public void setToChange(boolean toChange) {
        this.toChange = toChange;
    }

    public void setAllTextfields() {
        tfDay.setText(Integer.toString(termin.getDateTime().getDayOfMonth()));
        tfMonth.setText(Integer.toString(termin.getDateTime().getMonthValue()));
        tfYear.setText(Integer.toString(termin.getDateTime().getYear()));
        tfHour.setText(Integer.toString(termin.getDateTime().getHour()));
        tfMinute.setText(Integer.toString(termin.getDateTime().getMinute()));
        tfText.setText(termin.getTitle());
    }


    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        ok = false;
        this.dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOKActionPerformed
        if (!toChange) {
            try {
                text = tfText.getText();
                dateTime = LocalDateTime.of(Integer.parseInt(tfYear.getText()), Integer.parseInt(tfMonth.getText()),
                        Integer.parseInt(tfDay.getText()), Integer.parseInt(tfHour.getText()), Integer.parseInt(tfMinute.getText()));
                termin = new Appointment(text, dateTime);
                ok = true;
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error with input!");
            }
        } else {
            try{
            text = tfText.getText();
            dateTime = LocalDateTime.of(Integer.parseInt(tfYear.getText()), Integer.parseInt(tfMonth.getText()),
                    Integer.parseInt(tfDay.getText()), Integer.parseInt(tfHour.getText()), Integer.parseInt(tfMinute.getText()));
            termin = new Appointment(text, dateTime);
            ok = true;
            this.dispose();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error with input!");
            }
        }
    }//GEN-LAST:event_btOKActionPerformed

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
            java.util.logging.Logger.getLogger(AppointmentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppointmentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppointmentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppointmentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AppointmentDialog dialog = new AppointmentDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField tfDay;
    private javax.swing.JTextField tfHour;
    private javax.swing.JTextField tfMinute;
    private javax.swing.JTextField tfMonth;
    private javax.swing.JTextField tfText;
    private javax.swing.JTextField tfYear;
    // End of variables declaration//GEN-END:variables
}
