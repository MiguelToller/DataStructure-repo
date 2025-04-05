package ex4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> equipes = new HashMap<>();
		
		int indice = 1;
		
		while(true) {
			
			System.out.println("Insira o nome da equipe: ('sair' para encerrar)");
			String nomeEquipe = sc.nextLine().toUpperCase();
			
			if(nomeEquipe.equalsIgnoreCase("sair"))
				break;
			
			if(!equipes.containsKey(nomeEquipe)) {
				equipes.put(nomeEquipe, indice);
				System.out.println("Equipe Adicionada!");
				indice++;
			}
			else {
				System.out.println("Equipe ja Cadastrada!");
			}
		}
		equipes.entrySet().stream()
			.sorted(Map.Entry.comparingByKey())
			.forEach(entry -> System.out.println
					("Equipe: " + entry.getKey() + " - Numero: " + entry.getValue()));
		System.out.println("\nTotal de equipes = " + indice);
		
		sc.close();
	}
}
