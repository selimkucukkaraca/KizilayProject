package ui;

import service.AdminService;
import ui.Admin.AdminPanel;
import ui.Donor.DonorForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login {
    private JTextField nameField;
    private JTextField lastnameField;
    private JPasswordField passwordField;
    private JPanel rootPanel;
    private JButton loginButton;
    private JButton donateBloodButton;
    private JLabel warnLabel;

    private final AdminService adminService = new AdminService();


    public Login() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String lastname = lastnameField.getText();
                int password = Integer.parseInt(passwordField.getText());

                if (adminService.Login(name,lastname,password)){
                    warnLabel.setText("");
                    JFrame frame = new JFrame();

                    frame.setContentPane(new AdminPanel().rootPanel);
                    frame.setSize(800, 800);
                    frame.setTitle("Admin Panel");
                    frame.setVisible(true);
                }
                else {
                    warnLabel.setText("admin not found, wrong login");
                }
            }
        });


        donateBloodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new DonorForm().rootPanel);
                frame.setSize(600,300);
                frame.setLocation(500, 100);
                frame.setTitle("DonorForm Panel");
                frame.setVisible(true);

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
                    passwordField.requestFocus();
                }
            }
        });
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == 10) {
                    loginButton.doClick();
                }
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setContentPane(new Login().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(400, 300);
        frame.setTitle("Login");
        frame.setLocation(300, 300);

    }
}
