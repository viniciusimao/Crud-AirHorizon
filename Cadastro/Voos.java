package Cadastro;


public class Voos {

    private int idVoos;
    private String localVoos;
    private int fk_Cliente_idCli;



    public int getFk_Cliente_idCli() {
        return fk_Cliente_idCli;
    }
    public void setFk_Cliente_idCli(int fk_Cliente_idCli) {
        this.fk_Cliente_idCli = fk_Cliente_idCli;
    }
    public int getIdVoos() {
        return idVoos;
    }
    public void setIdVoos(int idVoos) {
        this.idVoos = idVoos;
    }

    public String getLocalVoos() {
        return localVoos;
    }
    public void setLocalVoos(String localVoos) {
        this.localVoos = localVoos;
    }

    
}
