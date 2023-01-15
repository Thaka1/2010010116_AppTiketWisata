package koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class DataAgen {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String kd_agen;
    public String nama_agen_travel;
    public String jenis_kelamin;
    public String alamat;
    public String no_telp;
    
    public void simpan()throws SQLException{
        conn = koneksiDatabase.getKoneksi();
        sql = "INSERT INTO Agen(kd_agen,nama_agen_travel,jenis_kelamin,alamat,no_telp)VALUE(?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,kd_agen);
        pst.setString(2,nama_agen_travel);
        pst.setString(3,jenis_kelamin);
        pst.setString(4,alamat);
        pst.setString(5,no_telp);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = koneksiDatabase.getKoneksi();
        sql = "UPDATE Agen set nama_agen_travel=?, jenis_kelamin=?, alamat=?, no_telp=? where kd_agen=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nama_agen_travel);
        pst.setString(2,jenis_kelamin);
        pst.setString(3,alamat);
        pst.setString(4,no_telp);
        pst.setString(5,kd_agen);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=koneksiDatabase.getKoneksi();
        String sql="DELETE from Agen where kd_agen=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, kd_agen);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet Updatetabelagen()throws SQLException{
        conn = koneksiDatabase.getKoneksi();
        sql = "select kd_agen,nama_agen_travel,jenis_kelamin,alamat,no_telp from Agen";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
    
    
}