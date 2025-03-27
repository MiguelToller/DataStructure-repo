using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace geradorEmailC_sharp
{
    internal class Pessoa
    {
        private String nome;
        private String email;

        public Pessoa() { }

        public Pessoa(String nome, String email)
        {
            this.nome = nome;
            this.email = email;
        }

        public String getNome()
        {
            return nome;
        }

        public void setNome(String nome)
        {
            this.nome = nome;
        }

        public String getEmail()
        {
            return email;
        }

        public Boolean validarNome(String nome)
        {
            String[] parte = nome.Split(" ");
            return parte.Length >= 2;
        }

        public String gerarEmail(String nome)
        {
            String[] parte = nome.Split(" ");
            String primeiroNome = parte[0].ToLower();
            String ultimoNome = parte[parte.Length - 1].ToLower();
            return primeiroNome + "." + ultimoNome + "@ufn.edu.br";
        }
    }
}
