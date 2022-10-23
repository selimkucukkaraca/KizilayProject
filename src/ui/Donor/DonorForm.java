package ui.Donor;

import model.Donor;
import service.DonorService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DonorForm {
    public JPanel rootPanel;
    private JTextField nameField;
    private JTextField lastnameField;
    private JTextField ageField;
    private JTextField identiynumberField;
    private JTextField bloodgroupField;
    private JButton addButton;

    private final DonorService donorService = new DonorService();
    public DonorForm() {

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String lastname = lastnameField.getText();
                int age = Integer.parseInt(ageField.getText());
                int identiyNumber = Integer.parseInt(identiynumberField.getText());
                String bloodGroup = bloodgroupField.getText();

                donorService.addDonor(new Donor(name,lastname,age,identiyNumber,bloodGroup));

            }
        });
        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == 10) {
                    lastnameField.requestFocus();
                }
            }
        });
        lastnameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == 10) {
                    ageField.requestFocus();
                }
            }
        });
        ageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == 10) {
                    identiynumberField.requestFocus();
                }
            }
        });
        identiynumberField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == 10) {
                    bloodgroupField.requestFocus();
                }
            }
        });
        bloodgroupField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == 10) {
                    addButton.doClick();
                }
            }
        });
    }
}
