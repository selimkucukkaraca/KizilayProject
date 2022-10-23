package ui.Donor;

import model.Donor;
import service.DonorService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    }
}
