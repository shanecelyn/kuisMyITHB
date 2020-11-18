/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author User
 */
public class MainMenu extends JFrame implements ActionListener{
    JFrame frame;
    JButton buttonInsertJurusan;
    JButton buttonLihatJurusan;
    JButton buttonInsertMahasiswa;
    JButton buttonLihatMahasiswa;
    
    public MainMenu(){
        frame = new JFrame("MyITHB");
        frame.setSize(400, 420);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        buttonInsertJurusan = new JButton("Insert Data Jurusan Baru");
        buttonInsertJurusan.setBounds(75, 50, 250, 50);
        buttonInsertJurusan.addActionListener(this);
        frame.add(buttonInsertJurusan);
        
        buttonLihatJurusan = new JButton("Lihat Data Semua Jurusan");
        buttonLihatJurusan.setBounds(75, 125, 250, 50);
        buttonLihatJurusan.addActionListener(this);
        frame.add(buttonLihatJurusan);
        
        buttonInsertMahasiswa = new JButton("Insert Data Mahasiswa Baru");
        buttonInsertMahasiswa.setBounds(75, 200, 250, 50);
        buttonInsertMahasiswa.addActionListener(this);
        frame.add(buttonInsertMahasiswa);
        
        buttonLihatMahasiswa = new JButton("Lihat Data Mahasiswa Per Jurusan");
        buttonLihatMahasiswa.setBounds(75, 275, 250, 50);
        buttonLihatMahasiswa.addActionListener(this);
        frame.add(buttonLihatMahasiswa);
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
    //DataUser du = new DataUser();
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "Insert Data Jurusan Baru":
                frame.setVisible(false);
                new InsertJurusan();
                break;
            case "Lihat Data Semua Jurusan":
                frame.setVisible(false);
                new LihatJurusan();
                break;
            case "Insert Data Mahasiswa Baru":
                frame.setVisible(false);
                new InsertMahasiswa();
                break;
            case "Lihat Data Mahasiswa Per Jurusan":
                frame.setVisible(false);
                new LihatMahasiswa();
                break;
            case "EXIT": 
                System.exit(0);
                break;
        }
    }
}
