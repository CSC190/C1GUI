/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1gui;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

/**
 *
 * @author caltrans
 */
public class TabbedPanel1 extends javax.swing.JPanel {
    
        
    /**
     * Creates new form TabbePanel1
     */
    public TabbedPanel1() {
        initComponents();
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel tabPanel1 = new JPanel();
        JPanel tabPanel2 = new JPanel();
        JPanel tabPanel3 = new JPanel();
        
        tabbedPane.addTab("Panel 1", tabPanel1);
        tabbedPane.addTab("Panel 2", tabPanel2);
        tabbedPane.addTab("Panel 3", tabPanel3);
        this.add(tabbedPane);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.CardLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}