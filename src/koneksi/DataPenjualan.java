package koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DataPenjualan {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String kd_penjualan;
    public String tanggal;
    public String kd_objek_wisata;
    public String jumlah_tiket_terjual;
    public String harga_tiket;
    public String total_penjualan;
    
    public void simpan()throws SQLException{
        conn = koneksiDatabase.getKoneksi();
        sql = "INSERT INTO Penjualan(kd_penjualan,tanggal,kd_objek_wisata,jumlah_tiket_terjual,harga_tiket,total_penjualan)VALUE(?,?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,kd_penjualan);
        pst.setString(2,tanggal);
        pst.setString(3,kd_objek_wisata);
        pst.setString(4,jumlah_tiket_terjual);
        pst.setString(5,harga_tiket);
        pst.setString(6,total_penjualan);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = koneksiDatabase.getKoneksi();
        sql = "UPDATE Penjualan set tanggal=?, kd_objek_wisata=?, jumlah_tiket_terjual=?,harga_tiket=?, total_penjualan=? where kd_penjualan=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,tanggal);
        pst.setString(2,kd_objek_wisata);
        pst.setString(3,jumlah_tiket_terjual);
        pst.setString(4,harga_tiket);
        pst.setString(5,total_penjualan);
        pst.setString(6,kd_penjualan);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=koneksiDatabase.getKoneksi();
        String sql="DELETE from Penjualan where kd_penjualan=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,kd_penjualan);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet Updatetabelpenjualan()throws SQLException{
        conn = koneksiDatabase.getKoneksi();
        sql = "select kd_penjualan,tanggal,kd_objek_wisata,jumlah_tiket_terjual,harga_tiket,total_penjualan from Penjualan";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
}