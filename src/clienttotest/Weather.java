/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttotest;

/**
 *
 * @author Wiliam
 */
public class Weather extends javax.swing.JPanel {

    /**
     * Creates new form Weather
     */
    public Weather() {
        initComponents();
        
        lblCity.setText("shit");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCity = new javax.swing.JLabel();
        lblTemperature = new javax.swing.JLabel();
        lblMin = new javax.swing.JLabel();
        lblMax = new javax.swing.JLabel();
        lblBg = new javax.swing.JLabel();

        setLayout(null);

        lblCity.setText("City:");
        add(lblCity);
        lblCity.setBounds(50, 220, 34, 15);

        lblTemperature.setText("Temperature:");
        add(lblTemperature);
        lblTemperature.setBounds(130, 220, 100, 15);

        lblMin.setText("Min");
        add(lblMin);
        lblMin.setBounds(260, 220, 34, 15);

        lblMax.setText("Max");
        add(lblMax);
        lblMax.setBounds(360, 220, 20, 15);

        lblBg.setIcon(new javax.swing.ImageIcon("D:\\Cloud\\Dropbox\\4 UNI\\Service Centric Cloud Computing\\LABs\\FlightAgencyWSClient\\images\\Weather-Api.jpg")); // NOI18N
        add(lblBg);
        lblBg.setBounds(-40, 0, 540, 260);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBg;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblMax;
    private javax.swing.JLabel lblMin;
    private javax.swing.JLabel lblTemperature;
    // End of variables declaration//GEN-END:variables
}
