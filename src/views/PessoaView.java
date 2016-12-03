
package views;

import banco.BancoDadosAmigoSecreto;
import controllers.PessoasController;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import models.Pessoa;


public class PessoaView {
    
    Scanner leitor = new Scanner(System.in);
    
    public void mostraMenuPessoa(){
       System.out.println("");
       System.out.println("1 - Cadastrar Pessoa");
       System.out.println("2 - Listar Pessoas");
       System.out.println("3 - Gerar Amigos Secretos");
       System.out.println("4 - Buscar Amigo Secreto");
       System.out.println("");
       System.out.print("Digite: ");
       
      try {
          int opcao = leitor.nextInt();
       leitor.nextLine();
       
        switch(opcao){
            case 1:
                adicionarPessoa();
                break;
            case 2:
                listarPessoas();
                break;
            case 3:
                gerarAmigosSecreto();
                break;
            case 4:
                buscarSeuAmigoSecreto();
                break;
            default:
                 System.out.println("opção Invalida");
               break;       
        }
          
      }catch(InputMismatchException ie){
          System.out.println("***Erro: Esperava um número inteiro. (" + ie.toString()+")");
          leitor.nextLine();
      }
      catch (Exception e){
          System.out.println("Erro: Esperava um número Inteiro. (" + e.toString() + ")");
          leitor.nextLine();
      }
   }

    private void adicionarPessoa() {
        System.out.println("");
        System.out.print("Digite o codigo da Pessoa: ");
        int cod = leitor.nextInt();
        leitor.nextLine();

        System.out.print("Digite o nome da Pessoa: ");
        String nome = leitor.nextLine();
        
        System.out.print("Digite o que deseja de presente: ");
        String presente = leitor.nextLine();

        PessoasController.adicionarAluno(cod, nome, presente);
    }

    private void listarPessoas() {
        System.out.println("---");
           
       for (Pessoa a: BancoDadosAmigoSecreto.getListaparticipantes()){
           
           System.out.println("Codigo: "+ a.getCodigo());
           System.out.println("Nome: " + a.getNome());
           System.out.println("Presentes: " + a.getPresente());
           System.out.println("---");  
           
           
       }
    }

    private void buscarSeuAmigoSecreto() {
        System.out.print("Digite o codigo da Pessoa: ");
        int cod = leitor.nextInt();
        leitor.nextLine();

        
        Pessoa p = PessoasController.buscarPorCodigo(cod);
        
        if (p != null){
            System.out.println("");
           /*System.out.println("Codigo: "+ p.getCodigo());
           System.out.println("Nome: " + p.getNome());
           System.out.println("---");*/
           System.out.println("Codigo: " + p.getCodigo());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Quem eu Peguei: " + p.getQuemeupeguei().getNome());
            System.out.println("Presente de quem eu peguei: " + p.getQuemeupeguei().getPresente());
           
        }else{
            System.out.println("Pessoa não Encontrado");
        }
    }

    private void gerarAmigosSecreto() {  
       PessoasController.embaralhar();
       
       System.out.println("Amigo Secreto Gerados .:.:.:.:.:.:.:.:.:.:.:");
    }

}
