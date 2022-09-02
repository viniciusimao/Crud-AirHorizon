package DAO;
import Cadastro.Cadastro;
import Conector.Conector;

import java.sql.*;
import java.util.*;


public class CadastroDAO {
    
    public void salvar(Cadastro Contato){
        String sql = "INSERT INTO Cliente(nomeCli,tellCli,emailCli) values(?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Conector.createConnectionToMySQL();
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, Contato.getNomeCli());
            pstm.setInt(2, Contato.getTellCli());
            pstm.setString(3, Contato.getEmailCli());

            pstm.execute();

            System.out.println("Cadastro feito");
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

    public void update(Cadastro cadastro){
        String sql = "UPDATE Cliente SET nomeCli = ?, tellCli = ?, emailCli = ? "+
        "WHERE idCli = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Conector.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cadastro.getNomeCli());
            pstm.setInt(2, cadastro.getTellCli());
            pstm.setString(3, cadastro.getEmailCli());

            pstm.setInt(4, cadastro.getIdCli());

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
        String sql = "DELETE FROM Cliente WHERE idCli = ?";

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



    public List<Cadastro> getCadastros(){
        String sql = "SELECT * FROM Cliente";
        
        List<Cadastro> cadastros = new ArrayList<Cadastro>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = Conector.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();



            while (rset.next()) {

                Cadastro cadastro = new Cadastro();
                cadastro.setIdCli(rset.getInt("idCli"));
                cadastro.setNomeCli(rset.getString("nomeCli"));
                cadastro.setTellCli(rset.getInt("tellCli"));
                cadastro.setEmailCli(rset.getString("emailCli"));

                cadastros.add(cadastro);
                
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

        return cadastros;
    }
}
