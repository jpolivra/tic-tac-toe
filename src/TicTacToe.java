import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	static ArrayList<Integer> posicoesDoJogador = new ArrayList<Integer>();
	static ArrayList<Integer> posicoesDoComputador = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		// Modelo de tabuleiro referente ao jogo da velha.
		char[][] modeloDeTabuleiro = 
			{	
				{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'}, 
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'}, 
                {' ', '|', ' ', '|', ' '},
			};
		
		// Leitor de comandos no console.
		Scanner leitorDeComandos = new Scanner(System.in);
		
		// Escolhe a dificuldade do jogo.
		System.out.println("Qual dificuldade você pretende desafiar o computador (1-3):");
		int dificuldade = leitorDeComandos.nextInt();
		switch(dificuldade) {
        case 1:
        	System.out.println("Dificuldade escolhida: 1 - Facil");
            break;    
        case 2:
        	System.out.println("Dificuldade escolhida: 2 - Media");
            break; 
        case 3:
        	System.out.println("Dificuldade escolhida: 3 - Dificil");
            break; 
        default:
            break;                                           
    }
		
		// Monta o tabuleiro inicial.
		montarTabuleiro(modeloDeTabuleiro);
		
		// Inicia-se o jogo.
		while(true) {
			System.out.println("Digite qual jogada da tabela você irá escolher (1-9):");
			
			int jogadaDoJogador = leitorDeComandos.nextInt();
            
			while(posicoesDoJogador.contains(jogadaDoJogador) || posicoesDoComputador.contains(jogadaDoJogador)) {
				System.out.println("Essa casa ja foi escolhida, tente selecionar outra!");
				jogadaDoJogador = leitorDeComandos.nextInt();
			}
			
            dispararJogada(modeloDeTabuleiro, jogadaDoJogador, "jogador");
            
            String resultado = verificaVitoria();
            if(resultado.length() > 0) {
            	System.out.println(resultado);
            	montarTabuleiro(modeloDeTabuleiro);
            	break;
            }
            
            // Realiza a jogada do computador de acordo com a dificuldade escolhida.
            switch(dificuldade) {
            // Dificuldade facil.
            case 1:
            	int jogadaDoComputador =  jogadaDoJogador + 1;
           	 while(posicoesDoJogador.contains(jogadaDoComputador) || posicoesDoComputador.contains(jogadaDoComputador)) {
    				jogadaDoComputador = jogadaDoComputador + 1;
    			}
           	 dispararJogada(modeloDeTabuleiro, jogadaDoComputador, "computador");
           	 break;
             // Dificuldade media.
             case 2:
             	jogadaDoComputador =  jogadaDoJogador + 2;
            	 while(posicoesDoJogador.contains(jogadaDoComputador) || posicoesDoComputador.contains(jogadaDoComputador)) {
     				jogadaDoComputador = jogadaDoComputador + 2;
     			}
            	 dispararJogada(modeloDeTabuleiro, jogadaDoComputador, "computador");
            	 break;           	 
             // Dificuldade dificil.
             case 3:
            	 Random randomizador = new Random();
            	 jogadaDoComputador = randomizador.nextInt(9) + 1;
            	 while(posicoesDoJogador.contains(jogadaDoComputador) || posicoesDoComputador.contains(jogadaDoComputador)) {
     				jogadaDoComputador = randomizador.nextInt(9) + 1;
     			}
            	 dispararJogada(modeloDeTabuleiro, jogadaDoComputador, "computador");
            	 break;         	 
             default:
                 break; 
            }
            
            // Monta o tabuleiro com as jogadas da rodada.
            montarTabuleiro(modeloDeTabuleiro);
            
            // Verifica condicao de vitoria.
            resultado = verificaVitoria();
            if(resultado.length() > 0) {
            	System.out.println(resultado);
            	montarTabuleiro(modeloDeTabuleiro);
            	break;
            }
		}		
	}
	
	// Classe responsavel por renderizar o tabuleiro no console.
	public static void montarTabuleiro(char[][] modeloDeTabuleiro) {
		for(char[] linha : modeloDeTabuleiro) {
			for(char tile : linha) {
				System.out.print(tile);
			}
			System.out.println();
		}
	}
	
	// Classe responsavel por disparar a jogada no tabuleiro.
	public static void dispararJogada(char[][] modeloDeTabuleiro, int jogada, String jogador) {
		char chave = 'X';
		
		if(jogador.equals("computador")) {
			chave = 'O';
			posicoesDoComputador.add(jogada);
		} else if(jogador.equals("jogador")) {
			posicoesDoJogador.add(jogada);
		}
		
		switch(jogada) {
        case 1:
        	modeloDeTabuleiro[0][0] = chave;
            break;
        case 2:
        	modeloDeTabuleiro[0][2] = chave;
            break;
        case 3:
        	modeloDeTabuleiro[0][4] = chave;
            break;
        case 4:
        	modeloDeTabuleiro[2][0] = chave;
            break;
        case 5:
        	modeloDeTabuleiro[2][2] = chave;
            break;
        case 6:
        	modeloDeTabuleiro[2][4] = chave;
            break;
        case 7:
        	modeloDeTabuleiro[4][0] = chave;
            break;
        case 8:
        	modeloDeTabuleiro[4][2] = chave;
            break;
        case 9:
        	modeloDeTabuleiro[4][4] = chave;
            break;    
        default:
            break;                                           
    }
		
	
		
	}	
	
	
	// Verifica se uma condicao de vitoria foi alcancada.
	public static String verificaVitoria() {
		
        List linhaDeCima = Arrays.asList(1, 2, 3);
        List linhaDoMeio = Arrays.asList(4, 5, 6);
        List linhaDeBaixo = Arrays.asList(7, 8, 9);
        List colunaDaEsquerda = Arrays.asList(1, 4, 7);
        List ColunaDoMeio = Arrays.asList(2, 5, 8);
        List ColunaDaDireita = Arrays.asList(3, 6, 9);
        List linha1 = Arrays.asList(1, 5, 9);
        List linha2 = Arrays.asList(7, 5, 3);
        
        List<List> condicoesDeVitoria = new ArrayList<List>();
        condicoesDeVitoria.add(linhaDeCima);
        condicoesDeVitoria.add(linhaDoMeio);
        condicoesDeVitoria.add(linhaDeBaixo);
        condicoesDeVitoria.add(colunaDaEsquerda);
        condicoesDeVitoria.add(ColunaDoMeio);
        condicoesDeVitoria.add(ColunaDaDireita);
        condicoesDeVitoria.add(linha1);
        condicoesDeVitoria.add(linha2);       
        
        for(List lista : condicoesDeVitoria) {
        	if(posicoesDoJogador.containsAll(lista)) {
        		return "Parabens, voce ganhou";
        	} else if(posicoesDoComputador.containsAll(lista)) {
        	    return "Que pena, parece que você perdeu! =(";
        	} else if(posicoesDoJogador.size() + posicoesDoComputador.size() == 9) {
        		return "Empate!";
        	}
        }
        
        return "";
	}
}
