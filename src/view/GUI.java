package view;

import controller.Controller;

import javax.naming.ldap.Control;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame {

    private final JPanel mainPanel;
    private final JPanel toPdfPanel;
    private final JPanel fromPdfPanel;
    private final JPanel loadedFilesPanel;
    private final JButton txtToPdfButton;
    private final Controller controller;
    private GridBagConstraints gbc;

    public GUI() {

        controller = new Controller();

        this.setTitle("PDFConverter");
        this.setSize(700, 400);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel        = new JPanel();
        toPdfPanel       = new JPanel();
        fromPdfPanel     = new JPanel();
        loadedFilesPanel = new JPanel();
        txtToPdfButton   = new JButton(".txt -> .pdf");

        initComponents();
    }

    public void initComponents() {

        this.add(mainPanel);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(toPdfPanel, BorderLayout.WEST);
        mainPanel.add(fromPdfPanel, BorderLayout.EAST);
        mainPanel.add(loadedFilesPanel, BorderLayout.SOUTH);

        toPdfPanel.setLayout(new FlowLayout());

        fromPdfPanel.setLayout(new FlowLayout());
        fromPdfPanel.setBackground(Color.LIGHT_GRAY);

        loadedFilesPanel.setLayout(new GridBagLayout());
        loadedFilesPanel.setBackground(Color.LIGHT_GRAY);

        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        txtToPdfButton.addActionListener(new TxtToPdfButtonHandler());
        txtToPdfButton.setBackground(Color.WHITE);

        toPdfPanel.add(txtToPdfButton);
    }

    class TxtToPdfButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt files", "txt");

            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(null); //Fix startup location and change the file manager
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                controller.convertFile(chooser.getSelectedFile());
                loadedFilesPanel.add(new JLabel(chooser.getSelectedFile().getName()), gbc);
                loadedFilesPanel.updateUI();
            }
        }
    }
}