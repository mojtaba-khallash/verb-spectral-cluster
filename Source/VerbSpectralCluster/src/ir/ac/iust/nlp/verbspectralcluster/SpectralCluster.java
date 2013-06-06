package ir.ac.iust.nlp.verbspectralcluster;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Mojtaba Khallash
 */
public class SpectralCluster extends javax.swing.JFrame {

    private HashMap<Integer, List<String>> map;
    
    public SpectralCluster() {
        initComponents();

        pnlContainResult.setVisible(false);
        
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboClusterID.getModel();
        map = ReadFile.GetList();
        Iterator<Integer> iter = map.keySet().iterator();
        int count = 0;
        while(iter.hasNext()) {
            model.addElement(iter.next());
            count++;
        }
        lblNOC.setText(String.valueOf(count));
        
        setDrop();
    }
    
    private void setDrop() {
        FileDrop fd;
        fd = new FileDrop(null, txtInputFile, new FileDrop.Listener() {
            @Override
            public void filesDropped(java.io.File[] files) {
                if (files.length > 0) {
                    try {
                        boolean dropped = false;
                        for (int i = 0; i < files.length; i++) {
                            if (files[i].isFile()) {
                                txtInputFile.setText(files[i].getCanonicalPath());
                                dropped = true;
                                break;
                            }
                        }
                        if (dropped == false) {
                            JOptionPane.showMessageDialog(null, "File needed.");
                        }
                    } // end try
                    catch (java.io.IOException e) {
                    }
                }   // end for: through each dropped file
            }   // end filesDropped
        }); // end FileDrop.Listener
        
        fd = new FileDrop(null, txtOutputPath, new FileDrop.Listener() {
            @Override
            public void filesDropped(java.io.File[] files) {
                if (files.length > 0) {
                    try {
                        if (files[0].isFile()) {
                            files[0] = files[0].getParentFile();
                        }

                        txtOutputPath.setText(files[0].getCanonicalPath() + File.separator);
                    } // end try
                    catch (java.io.IOException e) {
                    }
                }   // end for: through each dropped file
            }   // end filesDropped
        }); // end FileDrop.Listener
    }
    
    private void SetVerbList(int key) {
        List<String> list = map.get(key);
        
        DefaultListModel model = (DefaultListModel) lstVerbs.getModel();
        model.clear();

        for (int i = 0; i < list.size(); i++) {
            model.add(i, list.get(i));
        }
        lblNOV.setText(String.valueOf(list.size()) + "  ");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlList = new javax.swing.JPanel();
        cboClusterID = new javax.swing.JComboBox(new DefaultComboBoxModel());
        lblClusterID = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstVerbs = new javax.swing.JList(new DefaultListModel());
        pnlStatusBar = new javax.swing.JPanel();
        lblNOCTitle = new javax.swing.JLabel();
        lblNOV = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNOC = new javax.swing.JLabel();
        pnlSearch = new javax.swing.JPanel();
        lblEnterVerb = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        rbFullMatch = new javax.swing.JRadioButton();
        rbContain = new javax.swing.JRadioButton();
        pnlFullMatchResult = new javax.swing.JPanel();
        lblClusterResult = new javax.swing.JLabel();
        pnlContainResult = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstClusterResults = new javax.swing.JList(new DefaultListModel());
        jScrollPane2 = new javax.swing.JScrollPane();
        lstVerbResults = new javax.swing.JList(new DefaultListModel());
        btnSearch = new javax.swing.JButton();
        pnlTagger = new javax.swing.JPanel();
        lblInputFile = new javax.swing.JLabel();
        btnOutputFile = new javax.swing.JButton();
        lblOutputPath = new javax.swing.JLabel();
        txtOutputPath = new javax.swing.JTextField();
        btnOutputPath = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();
        btnStartTagging = new javax.swing.JButton();
        txtInputFile = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spectral Cluster of Persian Verbs");

        cboClusterID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboClusterID_ValueChanged(evt);
            }
        });

        lblClusterID.setText("Cluster ID:");

        jScrollPane1.setViewportView(lstVerbs);

        pnlStatusBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblNOCTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNOCTitle.setText("  Number of Clusters:");

        lblNOV.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel3.setText("Number of Verbs in Cluster:");

        javax.swing.GroupLayout pnlStatusBarLayout = new javax.swing.GroupLayout(pnlStatusBar);
        pnlStatusBar.setLayout(pnlStatusBarLayout);
        pnlStatusBarLayout.setHorizontalGroup(
            pnlStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatusBarLayout.createSequentialGroup()
                .addComponent(lblNOCTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNOC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNOV))
        );
        pnlStatusBarLayout.setVerticalGroup(
            pnlStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNOV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
            .addComponent(lblNOCTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblNOC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlListLayout = new javax.swing.GroupLayout(pnlList);
        pnlList.setLayout(pnlListLayout);
        pnlListLayout.setHorizontalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addGroup(pnlListLayout.createSequentialGroup()
                        .addComponent(lblClusterID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboClusterID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(pnlStatusBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlListLayout.setVerticalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClusterID)
                    .addComponent(cboClusterID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Cluster List", pnlList);

        lblEnterVerb.setText("Enter Verb:");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch_KeyReleased(evt);
            }
        });

        buttonGroup1.add(rbFullMatch);
        rbFullMatch.setSelected(true);
        rbFullMatch.setText("Full Match");
        rbFullMatch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbFullMatch_SelectionChanged(evt);
            }
        });

        buttonGroup1.add(rbContain);
        rbContain.setText("Contain");
        rbContain.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbContain_SelectionChanged(evt);
            }
        });

        lblClusterResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClusterResult.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlFullMatchResultLayout = new javax.swing.GroupLayout(pnlFullMatchResult);
        pnlFullMatchResult.setLayout(pnlFullMatchResultLayout);
        pnlFullMatchResultLayout.setHorizontalGroup(
            pnlFullMatchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblClusterResult, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlFullMatchResultLayout.setVerticalGroup(
            pnlFullMatchResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblClusterResult, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        lstClusterResults.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lst_Clicked(evt);
            }
        });
        lstClusterResults.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstClusterResults_ValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstClusterResults);

        lstVerbResults.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lst_Clicked(evt);
            }
        });
        lstVerbResults.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstVerbResults_ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstVerbResults);

        javax.swing.GroupLayout pnlContainResultLayout = new javax.swing.GroupLayout(pnlContainResult);
        pnlContainResult.setLayout(pnlContainResultLayout);
        pnlContainResultLayout.setHorizontalGroup(
            pnlContainResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainResultLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlContainResultLayout.setVerticalGroup(
            pnlContainResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
            .addComponent(jScrollPane3)
        );

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
        pnlSearch.setLayout(pnlSearchLayout);
        pnlSearchLayout.setHorizontalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFullMatchResult, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlSearchLayout.createSequentialGroup()
                        .addComponent(lblEnterVerb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch))
                    .addGroup(pnlSearchLayout.createSequentialGroup()
                        .addComponent(rbFullMatch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbContain))
                    .addComponent(pnlContainResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnterVerb)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbContain)
                    .addComponent(rbFullMatch, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFullMatchResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContainResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Search", pnlSearch);

        lblInputFile.setText("Input CoNLL File:");

        btnOutputFile.setText("...");
        btnOutputFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutputFileActionPerformed(evt);
            }
        });

        lblOutputPath.setText("Output Path:");

        txtOutputPath.setEditable(false);

        btnOutputPath.setText("...");
        btnOutputPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutputPathActionPerformed(evt);
            }
        });

        txtLog.setColumns(20);
        txtLog.setEditable(false);
        txtLog.setRows(5);
        jScrollPane4.setViewportView(txtLog);

        btnStartTagging.setText("Start Tagging");
        btnStartTagging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartTaggingActionPerformed(evt);
            }
        });

        txtInputFile.setEditable(false);

        javax.swing.GroupLayout pnlTaggerLayout = new javax.swing.GroupLayout(pnlTagger);
        pnlTagger.setLayout(pnlTaggerLayout);
        pnlTaggerLayout.setHorizontalGroup(
            pnlTaggerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaggerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTaggerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addGroup(pnlTaggerLayout.createSequentialGroup()
                        .addGroup(pnlTaggerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInputFile)
                            .addComponent(lblOutputPath))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlTaggerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOutputPath)
                            .addComponent(txtInputFile))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlTaggerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOutputFile, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOutputPath, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTaggerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnStartTagging)))
                .addContainerGap())
        );
        pnlTaggerLayout.setVerticalGroup(
            pnlTaggerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaggerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTaggerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInputFile)
                    .addComponent(btnOutputFile)
                    .addComponent(txtInputFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTaggerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOutputPath)
                    .addComponent(txtOutputPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOutputPath))
                .addGap(9, 9, 9)
                .addComponent(btnStartTagging)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tagger", pnlTagger);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboClusterID_ValueChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboClusterID_ValueChanged
        SetVerbList(Integer.parseInt(evt.getItem().toString()));
    }//GEN-LAST:event_cboClusterID_ValueChanged

    private void rbContain_SelectionChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbContain_SelectionChanged
        pnlFullMatchResult.setVisible(false);
        pnlContainResult.setVisible(true);
        DefaultListModel model;
        
        model = (DefaultListModel) lstVerbResults.getModel();
        model.clear();
        
        model = (DefaultListModel) lstClusterResults.getModel();
        model.clear();
    }//GEN-LAST:event_rbContain_SelectionChanged

    private void rbFullMatch_SelectionChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbFullMatch_SelectionChanged
        pnlFullMatchResult.setVisible(true);
        lblClusterResult.setText("");
        pnlContainResult.setVisible(false);
    }//GEN-LAST:event_rbFullMatch_SelectionChanged

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String verb = txtSearch.getText();
        verb = verb.replaceAll("ي", "ی");
        lblClusterResult.setText("");

        DefaultListModel verbModel =(DefaultListModel) lstVerbResults.getModel();
        verbModel.clear();
        DefaultListModel clusterModel = (DefaultListModel) lstClusterResults.getModel();
        clusterModel.clear();
        int ind = 0;
        
        Iterator<Integer> iter = map.keySet().iterator();
        while(iter.hasNext()) {
            int id = iter.next();
            List<String> list = map.get(id);
            if (rbFullMatch.isSelected() == true) {
                boolean find = false;
                for(int i = 0; i < list.size(); i++) {
                    if (list.get(i).equals(verb)) {
                        lblClusterResult.setText(String.valueOf(id));
                        find = true;
                        break;
                    }
                }
                if (find == true)
                    break;
            }
            else {
                for(int i = 0; i < list.size(); i++) {
                    if (list.get(i).indexOf(verb) != -1) {
                        verbModel.add(ind, list.get(i));
                        clusterModel.add(ind, String.valueOf(id));
                        ind++;
                    }
                }                
            }
        }
        
        if (rbFullMatch.isSelected() == true && lblClusterResult.getText().length() == 0) {
            lblClusterResult.setText("Not Found.");
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearch_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch_KeyReleased
        if (evt.getKeyCode() == 10)
            btnSearch.doClick();
    }//GEN-LAST:event_txtSearch_KeyReleased

    boolean lock = false;
    
    private void lstVerbResults_ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstVerbResults_ValueChanged
        if (lock == false) {
            lock = true;
            lstClusterResults.setSelectedIndex(lstVerbResults.getSelectedIndex());
            lstClusterResults.setBounds(lstVerbResults.getBounds());
        }
        else
            lock = false;
    }//GEN-LAST:event_lstVerbResults_ValueChanged

    private void lstClusterResults_ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstClusterResults_ValueChanged
        if (lock == false) {
            lock = true;
            lstVerbResults.setSelectedIndex(lstClusterResults.getSelectedIndex());
            lstVerbResults.setBounds(lstClusterResults.getBounds());
        }
        else
            lock = false;
    }//GEN-LAST:event_lstClusterResults_ValueChanged

    private void lst_Clicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lst_Clicked
        lock = false;
    }//GEN-LAST:event_lst_Clicked

    private void btnStartTaggingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartTaggingActionPerformed
        String Introduction = "-----------------------------------------------------------------------------\n" +
                              "                          VerbSpectralCluster 1.0\n" +
                              "-----------------------------------------------------------------------------\n" +
                              "                            Mojtaba Khallash\n\n" +
                              "             Iran University of Science and Technology (IUST)\n" +
                              "                                 Iran\n" +
                              "-----------------------------------------------------------------------------\n";
        
        PrintStream out = new PrintStream(new OutputStream() {

            private StringBuffer buffer = new StringBuffer();

            @Override
            public void write(int b)
                    throws IOException {
                this.buffer.append((char) b);
                txtLog.setText(buffer.toString());
                txtLog.setCaretPosition(txtLog.getDocument().getLength() - 1);
            }
        });
        out.println(Introduction);
        ApplyInCoNLL.out = out;
        try {
            ApplyInCoNLL.Start(txtInputFile.getText(), txtOutputPath.getText() + "output_vsc.conll");
        }
        catch(Exception ex) {
            out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnStartTaggingActionPerformed

    private void btnOutputFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutputFileActionPerformed
        txtInputFile.setText(showFileDialog(txtInputFile.getText(), false, null));
    }//GEN-LAST:event_btnOutputFileActionPerformed

    private void btnOutputPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutputPathActionPerformed
        txtOutputPath.setText(showFileDialog(txtOutputPath.getText(), true, null));
    }//GEN-LAST:event_btnOutputPathActionPerformed

    private String showFileDialog(String currentDir, boolean isFolder,
            FileNameExtensionFilter filter) {
        JFileChooser fc = new JFileChooser();
        if (currentDir.length() == 0) {
            fc.setCurrentDirectory(new java.io.File("."));
        } else {
            fc.setCurrentDirectory(new java.io.File(currentDir));
        }
        fc.setMultiSelectionEnabled(false);
        if (filter != null) {
            fc.setFileFilter(filter);
        }
        String title = "Select File";
        if (isFolder == true) {
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            title = "Select Folder";
        }

        if (fc.showDialog(this, title) == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();

            String path = file.getPath();
            if (isFolder == true && path.lastIndexOf(File.separator) != path.length() - 1) {
                path = path + File.separator;
            }

            return path;
        } else {
            return currentDir;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpectralCluster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new SpectralCluster().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOutputFile;
    private javax.swing.JButton btnOutputPath;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnStartTagging;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboClusterID;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblClusterID;
    private javax.swing.JLabel lblClusterResult;
    private javax.swing.JLabel lblEnterVerb;
    private javax.swing.JLabel lblInputFile;
    private javax.swing.JLabel lblNOC;
    private javax.swing.JLabel lblNOCTitle;
    private javax.swing.JLabel lblNOV;
    private javax.swing.JLabel lblOutputPath;
    private javax.swing.JList lstClusterResults;
    private javax.swing.JList lstVerbResults;
    private javax.swing.JList lstVerbs;
    private javax.swing.JPanel pnlContainResult;
    private javax.swing.JPanel pnlFullMatchResult;
    private javax.swing.JPanel pnlList;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JPanel pnlStatusBar;
    private javax.swing.JPanel pnlTagger;
    private javax.swing.JRadioButton rbContain;
    private javax.swing.JRadioButton rbFullMatch;
    private javax.swing.JTextField txtInputFile;
    private javax.swing.JTextArea txtLog;
    private javax.swing.JTextField txtOutputPath;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}