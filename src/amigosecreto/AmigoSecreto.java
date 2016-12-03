package amigosecreto;

import banco.BancoDadosAmigoSecreto;
import views.PessoaView;


public class AmigoSecreto {

    
    public static void main(String[] args) {
       
        BancoDadosAmigoSecreto.inicializarBanco();
        
        PessoaView pessoaView = new PessoaView();
        
        while (true){
            pessoaView.mostraMenuPessoa();
        }
    }
    
}
