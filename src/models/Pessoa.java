
package models;


public class Pessoa {

    private int id;
    private int codigo;
    private String nome;
    private String presente;
    private Pessoa quemeupeguei;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPresente() {
        return presente;
    }

    public void setPresente(String presente) {
        this.presente = presente;
    }

    public Pessoa getQuemeupeguei() {
        return quemeupeguei;
    }

    public void setQuemeupeguei(Pessoa quemeupeguei) {
        this.quemeupeguei = quemeupeguei;
    }
    
    
    
    public static void ImprimirPessoas(Pessoa p){
        
        System.out.println("Codigo: " + p.codigo);
        System.out.println("Nome: " + p.nome);
        
    }
    
    public static void ImprimirAmigoSecreto(Pessoa z){
        System.out.println("Codigo: " + z.codigo);
        System.out.println("Nome: " + z.nome);
        System.out.println("Quem eu Peguei: " + z.getQuemeupeguei().nome);
        System.out.println("Presente de quem eu peguei: " + z.getQuemeupeguei().presente);
    }
    
    /*public static void ImprimirMeuAmigo (int cod){
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Quem eu Peguei: " + z.getQuemeupeguei().nome);
        System.out.println("Presente de quem eu peguei: " + z.getQuemeupeguei().presente);
    }*/
}
