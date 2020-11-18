/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Jurusan;
import model.Mahasiswa;

/**
 *
 * @author User
 */
public class Controller {
    static DatabaseHandler conn = new DatabaseHandler();

    // SELECT ALL from table jurusan
    public static ArrayList<Jurusan> getAllJurusan() {
        ArrayList<Jurusan> listJurusan = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM jurusan";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Jurusan jurusan = new Jurusan();
                jurusan.setKode(rs.getString("kode"));
                jurusan.setNama(rs.getString("nama"));
                listJurusan.add(jurusan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listJurusan);
    }
    
    // SELECT KODE from table jurusan
    public static ArrayList<String> getAllKodeJurusan() {
        ArrayList<String> listKodeJurusan = new ArrayList<>();
        conn.connect();
        String query = "SELECT kode FROM jurusan";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String kode = rs.getString("kode");
                listKodeJurusan.add(kode);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listKodeJurusan);
    }

    // SELECT MAHASISWA PER JURUSAN
    public static ArrayList<Mahasiswa> getMahasiswa(String kode_jurusan) {
        conn.connect();
        String query = "SELECT * FROM users WHERE kode_jurusan='" + kode_jurusan + "'";
        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();
        Mahasiswa mahasiswa = new Mahasiswa();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                mahasiswa.setNim(rs.getString("nim"));
                mahasiswa.setNama(rs.getString("nama"));
                mahasiswa.setAngkatan(rs.getString("angkatan"));
                mahasiswa.setKode_jurusan(rs.getString("kode_jurusan"));
                listMahasiswa.add(mahasiswa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listMahasiswa);
    }
    
    // INSERT JURUSAN
    public static boolean insertNewJurusan(Jurusan jurusan) {
        conn.connect();
        String query = "INSERT INTO jurusan VALUES(?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, jurusan.getKode());
            stmt.setString(2, jurusan.getNama());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    // INSERT JURUSAN
    public static boolean insertNewMahasiswa(Mahasiswa mahasiswa) {
        conn.connect();
        String query = "INSERT INTO mahasiswa VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, mahasiswa.getNim());
            stmt.setString(2, mahasiswa.getNama());
            stmt.setString(3, mahasiswa.getAngkatan());
            stmt.setString(2, mahasiswa.getKode_jurusan());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
