package Login;

import java.util.Scanner;
import java.util.Random;

public class primeiroAcessoF {

    funcionario func = new funcionario();
    admin ad = new admin();

    public void setIdF(){
        Random rand = new Random();
        int limite = 100000; // gera um inteiro aleatório entre 0 e 100000
        int randNumF = rand.nextInt(limite);

        this.func.idF = randNumF;
        if (randNumF == ad.idA){ //caso gere um ID igual ao id de algum admin
            randNumF = rand.nextInt(limite);
            this.func.idF = randNumF;
        }
        System.out.println("ID de funcionario: "+func.idF);
    }

    public void CadFunc(){ //public ou private?

        Scanner ler = new Scanner(System.in);
        
        System.out.println("\nCadastro de Funcionario");
        System.out.print("Login(seu nome): ");
        func.nomeF = ler.nextLine();
        System.out.print("Senha(sequência numérica): "); //como limitar pra 7 digitos? >> mensagem de erro se passar de 7
        func.senhaF = ler.nextInt();
        ler.nextLine();

        System.out.println("Login e senha definidos. Por favor, digite-os novamente para verificação.\n");
        System.out.print("Digite seu login: ");
        String VerLoginF = ler.next();
        System.out.print("Digite sua senha: ");
        int VerSenhaF = ler.nextInt();

        if (VerLoginF.equals(func.nomeF) && VerSenhaF == func.senhaF){

            System.out.println("Login e senha verificados.");
            
        } else if (!VerLoginF.equals(func.nomeF) || VerSenhaF != func.senhaF){

            System.out.println("Login ou senha incorretos.");

            do{
                System.out.println("Tente novamente.\n");
                System.out.print("Login: ");
                VerLoginF = ler.next();
                System.out.print("Senha: ");
                VerSenhaF = ler.nextInt();
            } while (!VerLoginF.equals(func.nomeF) || VerSenhaF != func.senhaF);

            System.out.println("Login e senha verificados.");
        }
        ler.close();
    }

    public void setQuantidadeF(){
        this.func.quantidadeF++;
        System.out.println("Funcionario adicionado");
        System.out.println("Qtd de func: "+this.func.quantidadeF);
    }

    public void main(String[] args) {

        primeiroAcessoF primFunc = new primeiroAcessoF();
        primFunc.CadFunc();
        primFunc.setIdF();
        primFunc.setQuantidadeF();
    }
}