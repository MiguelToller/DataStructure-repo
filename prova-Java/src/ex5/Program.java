package ex5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		List<Cidade> cidades = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int opcao;
		
		do {
			
			System.out.println("\nInsira uma opcao:\n");
			System.out.println("1.Cadastrar Cidade\n2.Listar Cidades\n3.Pesquisar Cidade\n4.Remover Cidade\n5.Finalizar");
			opcao = sc.nextInt();
			sc.nextLine();
			
			switch(opcao) {
			case 1:
				System.out.println("Insira o nome da cidade: ");
				String nomeCidade = sc.nextLine().toUpperCase();
				System.out.println("Insira a sigla da cidade: ");
				String siglaCidade = sc.nextLine().toUpperCase();
				
				Cidade cidade = new Cidade(nomeCidade, siglaCidade);
				cidades.add(cidade);
				break;
				
			case 2:
				cidades.sort((cidade1, cidade2) -> cidade1.getNome().compareTo(cidade2.getNome()));
				for(Cidade city : cidades) 
					System.out.println(city);
				break;
				
			case 3:
				System.out.println("Insira o nome da cidade para pesquisar: ");
				String cidadeDesejada = sc.nextLine().toUpperCase();
				for (Cidade city : cidades) {
					if(city.getNome().equals(cidadeDesejada)) 
						System.out.println("Sigla da cidade = " + city.getSigla());
					else
						System.out.println("Cidade nao encontrada.");
				}
				break;
				
			case 4:
				System.out.println("Insira o nome da cidade para remover: ");
				String cidadeRemover = sc.nextLine().toUpperCase();
				Cidade cidadeTemp = new Cidade(cidadeRemover, null);
				
				if(cidades.contains(cidadeTemp)) {
					cidades.remove(cidadeTemp);
					System.out.println("Cidade Removida!");
				}
				else {
					System.out.println("Cidade nao encontrada.");
				}
				break;
				
			case 5:
				System.out.println("Finalizando o programa...");
				break;
				
			default:
				System.out.println("Opcao invalida!");
				break;
			}
		} while(opcao != 5);
		
		sc.close();
	}
}
