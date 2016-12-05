
package controllers;

import banco.BancoDadosAmigoSecreto;
import java.util.Collections;
import models.Pessoa;


public class PessoasController {
    
    public static void adicionarUsuario (int codigo, String nome, String presente){
        Pessoa p = new Pessoa();
        p.setCodigo(codigo);
        p.setNome(nome);
        p.setPresente(presente);
                
        BancoDadosAmigoSecreto.getListaparticipantes().add(p);
        BancoDadosAmigoSecreto.getListapessoaapegar().add(p);
        BancoDadosAmigoSecreto.getListapessoamepegou().add(p);
    }
    public static Pessoa buscarPorCodigo (int codigo){
        for (Pessoa a: BancoDadosAmigoSecreto.getListaparticipantes()){
            if (codigo == a.getCodigo()){
                return a;
            }
        }    
        
        return null;    
    }
    public static void embaralhar (){
        /*Embaralha as listas*/
        Collections.shuffle(BancoDadosAmigoSecreto.getListapessoaapegar());
        Collections.shuffle(BancoDadosAmigoSecreto.getListapessoamepegou());
        
        /*Inicia a Variavel*/
        String ultimonomeprimeiralista = null;
        String ultimonomesegundalista = null;
        
        /*Pega o ultimo nome das duas lista*/
        for (Pessoa z:BancoDadosAmigoSecreto.getListaparticipantes()){
            ultimonomeprimeiralista = z.getNome();
        }
        for(Pessoa w:BancoDadosAmigoSecreto.getListapessoaapegar()){
           ultimonomesegundalista = w.getNome();
        }
        /*Compara o nome da primeira lista com o nome da segunda lista e o ultimo nome da primeira lista e o ultimo nome da segunda lista*/
        for (Pessoa a: BancoDadosAmigoSecreto.getListaparticipantes()){
            for (Pessoa b: BancoDadosAmigoSecreto.getListapessoaapegar()){
                if(a.getNome() != b.getNome()){
                    if(ultimonomeprimeiralista !=ultimonomesegundalista){
                        a.setQuemeupeguei(b);
                        BancoDadosAmigoSecreto.getListapessoaapegar().remove(b);
                        break;
                    }else{
                        embaralhar();
                    }
                }
            }
        }
    }
    public static void editarUsuario(int cod, String nome, String presente){
        
        for (Pessoa a: BancoDadosAmigoSecreto.getListaparticipantes()){
            if(a.getCodigo() == cod){
                a.setNome(nome);
                a.setPresente(presente);
            }
        }
        
    }
    public static void buscarParticipantes(int codigo){
        
        for (Pessoa a: BancoDadosAmigoSecreto.getListaparticipantes()){
            if(a.getCodigo() == codigo){
                System.out.println("");
                System.out.println("Codigo: " + a.getCodigo());
                System.out.println("Nome: " + a.getNome());
                System.out.println("Presentes: " + a.getPresente());
            }
        }
    }
    public static void excluirParticipantes(int codigo){
        for (Pessoa a: BancoDadosAmigoSecreto.getListaparticipantes())
            if (a.getCodigo() == codigo){
                BancoDadosAmigoSecreto.getListaparticipantes().remove(a);
            }
    }
}