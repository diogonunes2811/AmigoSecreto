
package banco;

import java.util.ArrayList;
import java.util.List;
import models.Pessoa;


public class BancoDadosAmigoSecreto {
    
    private static List<Pessoa> listapessoa;
    
    private static List<Pessoa> listapessoamepegou;
    
    private static List<Pessoa> listapessoaapegar;
    
    public static List<Pessoa> getListaparticipantes(){
        return listapessoa;
    }
    
    public static List<Pessoa> getListapessoamepegou(){
        return listapessoamepegou;
    }
    
    public static List<Pessoa> getListapessoaapegar(){
        return listapessoaapegar;
    }
    
    public static void inicializarBanco(){
        listapessoa = new ArrayList<Pessoa>();
        listapessoamepegou = new ArrayList<Pessoa>();
        listapessoaapegar = new ArrayList<Pessoa>();
    } 
}