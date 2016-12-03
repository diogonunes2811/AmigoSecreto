
package controllers;

import banco.BancoDadosAmigoSecreto;
import java.util.Collections;
import models.Pessoa;


public class PessoasController {
    
    public static void adicionarAluno (int codigo, String nome, String presente){
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
        Collections.shuffle(BancoDadosAmigoSecreto.getListapessoaapegar());
        Collections.shuffle(BancoDadosAmigoSecreto.getListapessoamepegou());
        
        /*for (Pessoa a: BancoDadosAmigoSecreto.getListaparticipantes()){
            for (Pessoa b: BancoDadosAmigoSecreto.getListapessoaapegar()){
                    if(a.getQuemeupeguei() != b.getQuemmepegou()){
                        if(a.getQuemeupeguei() == null){
                            a.setQuemeupeguei(b);
                            BancoDadosAmigoSecreto.getListapessoaapegar().remove(b);

                            for (Pessoa x : BancoDadosAmigoSecreto.getListaparticipantes()){
                                if(x.getNome() == b.getNome()){
                                    x.setQuemmepegou(a);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                    
            }
            
            for (Pessoa c: BancoDadosAmigoSecreto.getListapessoamepegou()){
                if (a.getQuemmepegou() == null){
                    a.setQuemmepegou(c);
                    BancoDadosAmigoSecreto.getListapessoamepegou().remove(c);
                    for (Pessoa y : BancoDadosAmigoSecreto.getListaparticipantes()){
                        
                            if(y.getNome() == c.getNome()){
                                y.setQuemeupeguei(a);
                                break;
                            }
                       
                    }
                }
                break;
            }
        }*/
        for (Pessoa a: BancoDadosAmigoSecreto.getListaparticipantes()){
            for (Pessoa b: BancoDadosAmigoSecreto.getListapessoaapegar()){
                if(a.getNome() != b.getNome()){
                    a.setQuemeupeguei(b);
                    BancoDadosAmigoSecreto.getListapessoaapegar().remove(b);
                    break;
                }
            }
        }
    }
   
    
}
