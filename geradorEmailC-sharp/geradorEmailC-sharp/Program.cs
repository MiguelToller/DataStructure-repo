using System;

namespace geradorEmailC_sharp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            List<Dictionary<string, string>> listDict = new List<Dictionary<string, string>>();
            Pessoa p = new Pessoa();

            while (true)
            {

                Console.WriteLine("\nInsira nome completo ('sair' para encerrar):");
                string nome = Console.ReadLine();
                nome = nome.ToLower();

                // Sair
                if(nome.Equals("sair"))
                    break;

                // Validar e gerar email
                string email = "";
                if (p.validarNome(nome))
                {
                    email = p.gerarEmail(nome);
                }
                else
                {
                    Console.WriteLine("Nome invalido!");
                    continue;
                }

                string emailFinal = email;
                int contador = 1;

                // Verificar se o email existe, se existir adiciona o indice
                while (emailExiste(listDict, emailFinal))
                {
                    emailFinal = adicionarIndiceEmail(email, contador);
                    contador++;
                }

                Console.WriteLine("Email gerado: " + emailFinal);

                // Cria o dicionario e adiciona na lista
                Dictionary<string, string> dict = new Dictionary<string, string>();
                dict.Add(emailFinal, nome);
                listDict.Add(dict);
            }

            // Exibir
            Console.WriteLine("\nLista de Pessoas Cadastradas:");
            foreach (Dictionary<string, string> dicionario in listDict)
            {
                foreach (KeyValuePair<string, string> entry in dicionario)
                {
                    Console.WriteLine(entry.Value + " - " + entry.Key);
                }
            }
        }
        public static Boolean emailExiste(List<Dictionary<string, string>> listDict, string email)
        {
            foreach (Dictionary<string, string> dicionario in listDict)
            {
                if (dicionario.ContainsKey(email))
                {
                    return true; // email existe
                }
            }
            return false; // email nao existe
        }

        public static String adicionarIndiceEmail(String email, int i)
        {
            return email.Substring(0, email.IndexOf("@")) + i + email.Substring(email.IndexOf("@"));
        }
    }
}