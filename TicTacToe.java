import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TicTacToe {
    public static void main(String[] args) {

        static ArrayList<Integer> posicoesJogador = new ArrayList<Integer>();
        static ArrayList<Integer> posicoesComputador = new ArrayList<Integer>();
    
        char[][] tabela =
                         {
                            {' ', '|', ' ', '|', ' '},
                            {'-', '+', '-', '+', '-'}, 
                            {' ', '|', ' ', '|', ' '},
                            {'-', '+', '-', '+', '-'}, 
                            {' ', '|', ' ', '|', ' '},
                        };

                criarTabela(tabela);

                Scanner leitor = new Scanner(System.in);

                while(true) {
                    System.out.println("Digite qual jogada da tabela você irá escolher (1-9):");

                    int jogadaJogador = leitor.nextInt();
                    System.out.println(jogadaJogador);
                    realizaJogada(tabela, jogadaJogador, "player");
    
                    Random randomize = new Random(); 
                    int jogadaComputador = randomize.nextInt(9) + 1;
                    realizaJogada(tabela, jogadaComputador, "computador");
    
                    criarTabela(tabela);
                }
    }


    public static String verificaVencedor() {

            List linhaDeCima = Arrays.asList(1, 2, 3);
            List linhaDoMeio = Arrays.asList(4, 5, 6);
            List linhaDeBaixo = Arrays.asList(7, 8, 9);

            List ColunaDoMeio = Arrays.asList(3, 6, 9);
            List ColunaDaDireita = Arrays.asList(1, 5, 9);
            List colunaDaEsquerda = Arrays.asList(7, 5, 3);

            return "";
    }




    public static void criarTabela(char[][] tabela) {
        for(char[] linha : tabela) {
            for(char k : linha ) {
                System.out.print(k);
            }
            System.out.println();
        }
    }

    public static void realizaJogada(char[][] tabela, int jogada, String user) {

        char chave = 'X';

        if(user.equals("player")) {
            chave = 'X';
        } else if(user.equals("computador")) {
            chave = 'O';
        }

        switch(jogada) {
            case 1:
                tabela[0][0] = chave;
                break;
            case 2:
                tabela[0][2] = chave;
                break;
            case 3:
                tabela[0][4] = chave;
                break;
            case 4:
                tabela[2][0] = chave;
                break;
            case 5:
                tabela[2][2] = chave;
                break;
            case 6:
                tabela[2][4] = chave;
                break;
            case 7:
                tabela[4][0] = chave;
                break;
            case 8:
                tabela[4][2] = chave;
                break;
            case 9:
                tabela[4][4] = chave;
                break;    
            default:
                break;                                           
        }

    }

}