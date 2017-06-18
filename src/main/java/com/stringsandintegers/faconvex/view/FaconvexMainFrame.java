/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stringsandintegers.faconvex.view;

import com.stringsandintegers.faconvex.control.FaconvexMainController;
import com.stringsandintegers.faconvex.document.DocumentCostantTypes;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Daniele Porcelli
 */
public class FaconvexMainFrame extends javax.swing.JFrame {

    /**
     * Creates new form FaconvexMainFrame
     */
    public FaconvexMainFrame() {
        initComponents();
        
        //Initialize the ListSelectionModel of jListConvs
        ListSelectionModel lsm = jListConvs.getSelectionModel();
        
        //Add a ListSelectionListener
        lsm.addListSelectionListener(new ListSelectionListener() {
            
            public void valueChanged(ListSelectionEvent event) {
                ListSelectionModel srcList = (ListSelectionModel)event.getSource();
                
                //If an index is selected, enable the "export" buttons
                if(!srcList.isSelectionEmpty()) {
                    jButtonExportPDF.setEnabled(true);
                    jMenuItemExport.setEnabled(true);
                }
                else {
                    //No index is selected: disable the "export" buttons
                    jButtonExportPDF.setEnabled(false);
                    jMenuItemExport.setEnabled(false);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jPanelActions = new javax.swing.JPanel();
        jButtonExportPDF = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListConvs = new javax.swing.JList();
        jLabelStatus = new javax.swing.JLabel();
        jLabelDot = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jMenuItemExport = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemClose = new javax.swing.JMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuItemAbout = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Faconvex");
        setResizable(false);

        jPanelActions.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        jButtonExportPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pdf.png"))); // NOI18N
        jButtonExportPDF.setText("Export as PDF file");
        jButtonExportPDF.setEnabled(false);
        jButtonExportPDF.setMaximumSize(new java.awt.Dimension(125, 23));
        jButtonExportPDF.setMinimumSize(new java.awt.Dimension(125, 23));
        jButtonExportPDF.setPreferredSize(new java.awt.Dimension(125, 23));
        jButtonExportPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelActionsLayout = new javax.swing.GroupLayout(jPanelActions);
        jPanelActions.setLayout(jPanelActionsLayout);
        jPanelActionsLayout.setHorizontalGroup(
            jPanelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonExportPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanelActionsLayout.setVerticalGroup(
            jPanelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonExportPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Conversations"));

        jListConvs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListConvs.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(jListConvs);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
        );

        jLabelStatus.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabelStatus.setText("Ready!");

        jLabelDot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bullet_green.png"))); // NOI18N

        jMenuFile.setText("File");

        jMenuItemOpen.setText("Open messages file...");
        jMenuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemOpen);

        jMenuItemExport.setText("Export as PDF file...");
        jMenuItemExport.setEnabled(false);
        jMenuItemExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemExport);
        jMenuFile.add(jSeparator1);

        jMenuItemClose.setText("Close");
        jMenuItemClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCloseActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemClose);

        jMenuBar1.add(jMenuFile);

        jMenuHelp.setText("?");

        jMenuItemAbout.setText("About...");
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuItemAbout);

        jMenuBar1.add(jMenuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jPanelActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabelDot)
                                .addGap(11, 11, 11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelStatus)
                                .addGap(18, 18, 18)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenActionPerformed
        //Creates the file chooser
        JFileChooser fc = new JFileChooser();
        
        //Creates and sets the file filter (only html files allowed)
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("HTML files", "htm", "html");
        fc.setFileFilter(fileFilter);
        
        //Change the label text in "Loading..."
        jLabelStatus.setText("Loading...");
        
        //Set the status dot red.
        jLabelDot.setIcon(new ImageIcon(getClass().getResource("/bullet_red.png")));
        
        //Disable the buttons
        jButtonExportPDF.setEnabled(false);
        jMenuFile.setEnabled(false);
        jMenuHelp.setEnabled(false);
        
        //Prompt the "open" dialog
        int result = fc.showOpenDialog(this);
        
        //Check whether the user chose the messages' file. If so, the procedure retrieves the location of the choosen file and passes it to the main controller which returns a list of the conversations found; else does nothing
        if (result == JFileChooser.APPROVE_OPTION) {
            File messagesFile = fc.getSelectedFile();
            try {
           
                jListConvs.setModel(FaconvexMainController.openFile(messagesFile));
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "An error occurred while loading the conversations list:\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
        else if(result == JFileChooser.ERROR_OPTION)
            JOptionPane.showMessageDialog(this, "An error occurred while opening the conversations file.", "Error", JOptionPane.ERROR_MESSAGE);
        
        //Change the label text in "Ready!"
        jLabelStatus.setText("Ready!");
        
        //Set the status dot to green
        jLabelDot.setIcon(new ImageIcon(getClass().getResource("/bullet_green.png")));
        
        //Enable the buttons back again
        if (!jListConvs.isSelectionEmpty())
            jButtonExportPDF.setEnabled(true);
        
        jMenuFile.setEnabled(true);
        jMenuHelp.setEnabled(true);
    }//GEN-LAST:event_jMenuItemOpenActionPerformed

    private void jMenuItemCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemCloseActionPerformed

    private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutActionPerformed
        AboutFrame.main(this);
    }//GEN-LAST:event_jMenuItemAboutActionPerformed

    private void jButtonExportPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportPDFActionPerformed
        exportPDF();
    }//GEN-LAST:event_jButtonExportPDFActionPerformed

    private void jMenuItemExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportActionPerformed
        exportPDF();
    }//GEN-LAST:event_jMenuItemExportActionPerformed

    private void exportPDF() {
        //Open the file chooser to get the path where to save the output document
        JFileChooser fc = new JFileChooser();
        
        //Creates and sets the file filter (only html files allowed)
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("PDF files", "pdf");
        fc.setFileFilter(fileFilter);
        
        //Change the label text in "Loading..."
        jLabelStatus.setText("Exporting...");
        
        //Set the status dot red.
        jLabelDot.setIcon(new ImageIcon(getClass().getResource("/bullet_red.png")));
        
        //Disable the buttons
        jButtonExportPDF.setEnabled(false);
        jMenuFile.setEnabled(false);
        jMenuHelp.setEnabled(false);
        
        int result = fc.showSaveDialog(this);
        
        if(result == JFileChooser.APPROVE_OPTION) {
            File outputFile = fc.getSelectedFile();
            if (!(outputFile.toString()).endsWith(".pdf"))
                outputFile = new File(fc.getSelectedFile() + ".pdf");
            
            System.out.println("Saving file in: " + outputFile);
            
            //Export the selected conversation by invoking FaconvexMainController
            int selectedIndex = jListConvs.getSelectedIndex();
            
            System.out.println("Selected element: " + selectedIndex);
            
            try {
                FaconvexMainController.exportConversation(selectedIndex, DocumentCostantTypes.PDF_DOCUMENT, outputFile);
                
                //Feedback message for the user
                JOptionPane.showMessageDialog(this, "Conversation exported successfully in a PDF file.", "Export to PDF",JOptionPane.PLAIN_MESSAGE);
            }
            catch(IOException ex) {
                JOptionPane.showMessageDialog(this, "An error occurred while exporting the conversation:\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
        else if(result == JFileChooser.ERROR_OPTION)
            JOptionPane.showMessageDialog(this, "An error occurred while saving the conversation file.", "Error", JOptionPane.ERROR_MESSAGE);
        
        //Change the label text in "Ready!"
        jLabelStatus.setText("Ready!");
        
        //Set the status dot to green
        jLabelDot.setIcon(new ImageIcon(getClass().getResource("/bullet_green.png")));
        
        //Enable the buttons back again
        jButtonExportPDF.setEnabled(true);
        jMenuFile.setEnabled(true);
        jMenuHelp.setEnabled(true);
    }
    
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
            java.util.logging.Logger.getLogger(FaconvexMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FaconvexMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FaconvexMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FaconvexMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               FaconvexMainFrame fmf = new FaconvexMainFrame();
               
               //Center the frame
               fmf.setLocationRelativeTo(null);
               
               fmf.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExportPDF;
    private javax.swing.JLabel jLabelDot;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JList jListConvs;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemClose;
    private javax.swing.JMenuItem jMenuItemExport;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelActions;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
