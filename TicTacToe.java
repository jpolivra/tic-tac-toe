import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
    
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
                System.out.println("Digite qual casa da tabela você irá escolher (1-9):");
                int casa = leitor.nextInt();

                System.out.println(casa);

                switch(casa) {
                    case 1:
                        tabela[0][0] = 'X';
                        break;
                    case 2:
                        tabela[0][0] = 'X';
                        break;
                    case 3:
                        tabela[0][0] = 'X';
                        break;
                    case 4:
                        tabela[0][0] = 'X';
                        break;
                    case 5:
                        tabela[0][0] = 'X';
                        break;
                    case 6:
                        tabela[0][0] = 'X';
                        break;
                    case 7:
                        tabela[0][0] = 'X';
                        break;
                    case 8:
                        tabela[0][0] = 'X';
                        break;
                    case 9:
                        tabela[0][0] = 'X';
                        break;                                               
                }

    }

    public static void criarTabela(char[][] tabela) {
        for(char[] linha : tabela) {
            for(char k : linha ) {
                System.out.print(k);
            }
            System.out.println();
        }
    }

}