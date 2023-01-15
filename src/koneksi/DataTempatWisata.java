package koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DataTempatWisata {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String kd_objek_wisata;
    public String nama_objek_wisata;
    public String harga_tiket_masuk;
    public String kd_agen;
    
    public void simpan()throws SQLException{
        conn = koneksiDatabase.getKoneksi();
        sql = "INSERT INTO Tempat_wisata(kd_objek_wisata,nama_objek_wisata,harga_tiket_masuk,kd_agen)VALUE(?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,kd_objek_wisata);
        pst.setString(2,nama_objek_wisata);
        pst.setString(3,harga_tiket_masuk);
        pst.setString(4,kd_agen);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = koneksiDatabase.getKoneksi();
        sql = "UPDATE Tempat_wisata set nama_objek_wisata=?, harga_tiket_masuk=?, kd_agen=?where kd_objek_wisata=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nama_objek_wisata);
        pst.setString(2,harga_tiket_masuk);
        pst.setString(3,kd_agen);
        pst.setString(4,kd_objek_wisata);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=koneksiDatabase.getKoneksi();
        String sql="DELETE from Tempat_wisata where kd_objek_wisata=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, kd_objek_wisata);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet Updatetabelwisata()throws SQLException{
        conn = koneksiDatabase.getKoneksi();
        sql = "select kd_objek_wisata,nama_objek_wisata,harga_tiket_masuk,kd_agen from Tempat_wisata";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
}