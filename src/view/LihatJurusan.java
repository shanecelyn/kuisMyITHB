/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Jurusan;

/**
 *
 * @author User
 */
public class LihatJurusan  { 
    JFrame f; 
    JTable j; 
  
    public LihatJurusan() 
    { 
        f = new JFrame(); 
        f.setTitle("Lihat Data Semua Jurusan"); 
        ArrayList<Jurusan> listJurusan = Controller.getAllJurusan();
        for (Jurusan user : listJurusan) {
            System.out.println(Jurusan.toString());
        }
        
        String[] columnNames = { "Kode", "Nama"}; 
  
        //j = new JTable(listJurusan, columnNames); 
        j.setBounds(30, 40, 200, 300); 
  
        // adding it to JScrollPane 
        JScrollPane sp = new JScrollPane(j); 
        f.add(sp); 
        f.setSize(500, 200); 
        f.setVisible(true); 
    } 
}
