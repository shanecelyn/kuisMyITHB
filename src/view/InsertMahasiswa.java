/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import model.Mahasiswa;

/**
 *
 * @author User
 */
public class InsertMahasiswa extends JFrame implements ActionListener{
    JFrame frame = new JFrame("Insert Data Mahasiswa Baru");
    
    JLabel l_nim = new JLabel("NIM");
    JTextField tf_nim = new JTextField();

    JLabel l_nama = new JLabel("Nama");
    JTextField tf_nama = new JTextField();
    
    JLabel l_angkatan = new JLabel("Angkatan");
    JTextField tf_angkatan = new JTextField();

    JLabel l_kode_jurusan = new JLabel("Kode Jurusan");
    JCheckBox cb_IF = new JCheckBox("IF");
    JCheckBox cb_TI = new JCheckBox("TI");
    JCheckBox cb_MG = new JCheckBox("MG");
    JCheckBox cb_pengangguran = new JCheckBox("Pengangguran");
    String kode_jurusan;
    
    JButton btn_insert = new JButton("Submit");

    
    public InsertMahasiswa(){
        frame.setSize(450,250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        l_nim.setText("NIM ");
        l_nim.setBounds(10,0,150,50);
        tf_nim.setBounds(160,15, 250, 20);
        frame.add(tf_nim);
        frame.add(l_nim);
        
        l_nama.setText("Nama ");
        l_nama.setBounds(10,25,150,50);
        tf_nama.setBounds(160,40, 250, 20);
        frame.add(tf_nama);
        frame.add(l_nama);
        
        l_angkatan.setText("Angkatan ");
        l_angkatan.setBounds(10,50,150,50);
        tf_angkatan.setBounds(160,65, 250, 20);
        frame.add(tf_angkatan);
        frame.add(l_angkatan);
        
        btn_insert.setBounds(10,110,80,30);
        btn_insert.setActionCommand("Submit");
        btn_insert.addActionListener(this);
        frame.add(btn_insert);
        
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch (command) {
            case "Submit":
                Mahasiswa new_mahasiswa = new Mahasiswa();
                new_mahasiswa.setNama(tf_nama.getText());
                new_mahasiswa.setNim(tf_nim.getText());
                new_mahasiswa.setAngkatan(tf_angkatan.getText());
                Controller.insertNewMahasiswa(new_mahasiswa);
                new MainMenu();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
    
}
