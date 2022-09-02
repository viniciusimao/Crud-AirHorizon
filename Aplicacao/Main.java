package Aplicacao;


import Cadastro.Cadastro;
import Cadastro.Voos;
import DAO.CadastroDAO;
import DAO.VoosDAO;

public class Main {
    public static void main(String[] args) {
//Parte dos Clientes     
        Cadastro cadastro = new Cadastro();
        cadastro.setNomeCli("Vinicius Simão");
        cadastro.setTellCli(123456);
        cadastro.setEmailCli("iii@fffff");

        CadastroDAO cadastroDAO = new CadastroDAO();

        cadastroDAO.salvar(cadastro);

        Cadastro cad1 = new Cadastro();

        cad1.setNomeCli("Vinicius Simão");
        cad1.setTellCli(123456);
        cad1.setEmailCli("iii@fffff");
        cad1.setIdCli(1);

        cadastroDAO.update(cad1);

        cadastroDAO.delete(1);


        for(Cadastro c : cadastroDAO.getCadastros()){
            System.out.println("Cadastro: " + c.getNomeCli());
        }

//Parte dos Voos
        Voos voo = new Voos();
        voo.setLocalVoos("rj");
        voo.setFk_Cliente_idCli(1);

        VoosDAO voosDAO = new VoosDAO();

        voosDAO.salvar(voo);


        Voos voos1 = new Voos();
        voos1.setLocalVoos("Sp");
        voos1.setIdVoos(1);
        voos1.setFk_Cliente_idCli(1);

        voosDAO.update(voos1);
        
        voosDAO.delete(1);

        for(Voos v : voosDAO.getVoos()){
            System.out.println("Voos Listados: " + v.getLocalVoos());
        }
        

    }
}
