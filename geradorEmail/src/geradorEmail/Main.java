package geradorEmail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Map<String, String>> listDict = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Pessoa p = new Pessoa();

        while (true) {

            System.out.println("\nInsira nome completo ('sair' para encerrar):");
            String nome = sc.nextLine();

            // Sair
            if (nome.equalsIgnoreCase("sair"))
                break;

            // Validar e gerar email
            String email = "";
            if (p.validarNome(nome)) {
                email = p.gerarEmail(nome);
            } else {
                System.out.println("Nome invalido!");
                continue;
            }

            String emailFinal = email;
            int contador = 1;

            // Verificar se o email existe, se existir adiciona o indice
            while (emailExiste(listDict, emailFinal)) {
                emailFinal = adicionarIndiceEmail(email, contador);
                contador++;
            }

            System.out.println("Email gerado: " + emailFinal);

            // Cria o dicionario e adiciona na lista
            Map<String, String> dict = new HashMap<>();
            dict.put(emailFinal, nome);
            listDict.add(dict);
        }

        // Exibir
        System.out.println("\nLista de Pessoas Cadastradas:");
        for (Map<String, String> dicionario : listDict) {
            for (Map.Entry<String, String> entry : dicionario.entrySet()) {
                System.out.println(entry.getValue() + " - " + entry.getKey());
            }
        }
        sc.close();
    }

    public static boolean emailExiste(ArrayList<Map<String, String>> listDict, String email) {
        for (Map<String, String> dicionario : listDict) {
            if (dicionario.containsKey(email)) {
                return true; // email existe
            }
        }
        return false; // email nao existe
    }

    public static String adicionarIndiceEmail(String email, int i) {
        return email.substring(0, email.indexOf("@")) + i + email.substring(email.indexOf("@"));
    }
}
