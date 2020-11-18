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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import model.Jurusan;

/**
 *
 * @author User
 */
public class InsertJurusan extends JFrame implements ActionListener{
    JFrame frame = new JFrame("Insert Data Jurusan Baru");
    
    JLabel l_kode = new JLabel("Kode");
    JTextField tf_kode = new JTextField();

    JLabel l_nama = new JLabel("Nama");
    JTextField tf_nama = new JTextField();
    
    JButton btn_insert = new JButton("Submit");

    
    public InsertJurusan(){
        frame.setSize(450,250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        l_kode.setText("Kode ");
        l_kode.setBounds(10,0,150,50);
        tf_kode.setBounds(160,15, 250, 20);
        frame.add(tf_kode);
        frame.add(l_kode);
        
        l_nama.setText("Nama ");
        l_nama.setBounds(10,25,150,50);
        tf_nama.setBounds(160,40, 250, 20);
        frame.add(tf_nama);
        frame.add(l_nama);
        
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
                Jurusan new_jurusan = new Jurusan();
                new_jurusan.setNama(tf_nama.getText());
                new_jurusan.setKode(tf_kode.getText());
                Controller.insertNewJurusan(new_jurusan);
                new MainMenu();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
