package DAO;
import Cadastro.*;
import Conector.Conector;

import java.sql.*;
import java.util.*;

public class VoosDAO {

    public void salvar(Voos salvar){
        String sql = "INSERT INTO Voos(localVoos,fk_Cliente_idCli) values(?,?)";


        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Conector.createConnectionToMySQL();
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, salvar.getLocalVoos());
            pstm.setInt(2, salvar.getFk_Cliente_idCli());

            pstm.execute();

            System.out.println("Voo Cadastado");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Voos update){
        String sql = "UPDATE Voos SET localVoos = ?"+"WHERE idVoos = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Conector.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, update.getLocalVoos());
            pstm.setInt(2, update.getIdVoos());

            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void delete(int id){
        String sql = "DELETE FROM Voos WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Conector.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Voos> getVoos(){
        String sql = "SELECT * FROM Voos";

        List<Voos> voos = new ArrayList<Voos>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            conn = Conector.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();
            
            while(rset.next()){
                Voos voo = new Voos();
                voo.setIdVoos(rset.getInt("idVoos"));
                voo.setLocalVoos(rset.getString("localVoos"));
                voo.setFk_Cliente_idCli(rset.getInt("fk_Cliente_idCli"));
                
                voos.add(voo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(rset != null){
                    rset.close();
                }
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return voos;
    }
}
