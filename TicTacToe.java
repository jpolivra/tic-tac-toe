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