package ui.Admin;

import model.Donor;
import service.DonorService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

public class AdminPanel {
    public JPanel rootPanel;
    private JTable bloodGroupTable;
    private JButton takeBloodButton;
    private JTextField aramaCubugu;


    private final DonorService donorService = new DonorService();


    public void dinamikAra(String ara) {

        TableRowSorter<DefaultTableModel> tableModelTableRowSorter = new TableRowSorter<DefaultTableModel>((DefaultTableModel) bloodGroupTable.getModel());
        bloodGroupTable.setRowSorter(tableModelTableRowSorter);
        tableModelTableRowSorter.setRowFilter(RowFilter.regexFilter(ara));
    }


    public AdminPanel(){
        Vector<String> column = new Vector<>();
        column.add("name");
        column.add("lastname");
        column.add("age");
        column.add("identity_number");
        column.add("blood_group");

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(column);

        for (Donor donor : donorService.getAll()){
            Object [] row = {donor.getName(),donor.getLastname(),donor.getAge(),donor.getIdentityNumber(),donor.getBloodGroup()};
            tableModel.addRow(row);
        }
        bloodGroupTable.setModel(tableModel);


        takeBloodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String identityNumber = JOptionPane.showInputDialog(rootPanel, "identiy Number:");
                int response = JOptionPane.showConfirmDialog(rootPanel, "almak istediginiz kandan emin misiniz ?");
                if (response ==JOptionPane.YES_OPTION){
                    donorService.getBlood(Integer.parseInt(identityNumber));
                }else {
                    JOptionPane.showMessageDialog(rootPanel,"silme islemi iptal edildi.");
                }
            }
        });


        aramaCubugu.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String ara = aramaCubugu.getText();
                dinamikAra(ara);
            }
        });
    }
}
