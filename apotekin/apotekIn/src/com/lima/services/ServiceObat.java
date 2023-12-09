/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lima.services;

import com.lima.connection.DatabaseConnection;
import com.lima.models.ModelObat;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wildan
 */
public class ServiceObat {
    private final Connection con;
    
    public ServiceObat() {
        con = DatabaseConnection.getInstance().getConnection();
    }
    
    public void selectAll(JTable table) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        PreparedStatement p = con.prepareStatement("select * from `obat`");
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int id = r.getInt(1);
            String namaObat = r.getString(2);
            int jumlahStok = r.getInt(3);
            String satuan = r.getString(4);
            String tglKadaluarsa = r.getString(5);
            int hargaBeli = r.getInt(6);
            int hargaJual = r.getInt(7);
            String pemasok = r.getString(8);
            String catatan = r.getString(9);
            model.addRow(new Object[] {id, namaObat, jumlahStok, satuan, tglKadaluarsa, hargaBeli, hargaJual, pemasok, catatan});
        }
    }
    
    public void insertObat(String nama, int stok, String satuan, String tgl, int beli, int jual, String pemasok, String catatan) throws SQLException {
        PreparedStatement p = con.prepareStatement("insert into `obat` (nama_obat, jumlah_stok, satuan, tgl_kadaluarsa, harga_beli, harga_jual, pemasok, catatan) values (?, ?, ?, ?, ?, ?, ?, ?)");
        p.setString(1, nama);
        p.setInt(2, stok);
        p.setString(3, satuan);
        p.setDate(4, java.sql.Date.valueOf(tgl));
        p.setInt(5, beli);
        p.setInt(6, jual);
        p.setString(7, pemasok);
        p.setString(8, catatan);
        p.execute();
        p.close();
    }
    
    public void updateObat(int id, String nama, int stok, String satuan, String tgl, int beli, int jual, String pemasok, String catatan) throws SQLException {
        PreparedStatement p = con.prepareStatement("update `obat` set nama_obat=?, jumlah_stok=?, satuan=?, tgl_kadaluarsa=?, harga_beli=?, harga_jual=?, pemasok=?, catatan=? where id=?");
        p.setString(1, nama);
        p.setInt(2, stok);
        p.setString(3, satuan);
        p.setDate(4, java.sql.Date.valueOf(tgl));
        p.setInt(5, beli);
        p.setInt(6, jual);
        p.setString(7, pemasok);
        p.setString(8, catatan);
        p.setInt(9, id);
        p.executeUpdate();
        p.close();
    }
    
    public void deleteObat(int id) throws SQLException {
        PreparedStatement p = con.prepareStatement("delete from `obat` where id=?");
        p.setInt(1, id);
        p.execute();
        p.close();
    }
    
    public void cariObat(JTable table, String nama) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        PreparedStatement p = con.prepareStatement("select * from `obat` where nama_obat like concat('%', ?, '%')");
        p.setString(1, nama);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int id = r.getInt(1);
            String namaObat = r.getString(2);
            int jumlahStok = r.getInt(3);
            String satuan = r.getString(4);
            String tglKadaluarsa = r.getString(5);
            int hargaBeli = r.getInt(6);
            int hargaJual = r.getInt(7);
            String pemasok = r.getString(8);
            String catatan = r.getString(9);
            model.addRow(new Object[]{id, namaObat, jumlahStok, satuan, tglKadaluarsa, hargaBeli, hargaJual, pemasok, catatan});
        }
    }
}
