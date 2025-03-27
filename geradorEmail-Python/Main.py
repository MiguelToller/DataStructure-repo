from Pessoa import Pessoa

list_dict = []
p = Pessoa()

class Main:

    def run(self):

        global list_dict, p

        while True:
            nome = input("\nInsira nome completo ('sair' para encerrar): ")

            # Sair
            if nome.lower() == "sair":
                break

            # Validar e gerar email
            email = ""
            if p.validar_nome(nome):
                email = p.gerar_email(nome)
            else:
                print("Nome inválido!")
                continue

            email_final = email
            contador = 1

            # Verificar se o email existe, se existir adiciona o índice
            while p.email_existe(list_dict, email_final):
                email_final = p.adicionar_indice_email(email, contador)
                contador += 1

            print("Email gerado: ", email_final)

            # Cria o dicionário e adiciona na lista
            dict_entry = {email_final: nome}
            list_dict.append(dict_entry)

        # Exibir
        print("\nLista de Pessoas Cadastradas:")
        for dicionario in list_dict:
            for email, nome in dicionario.items():
                print(f"{nome} - {email}")

if __name__ == "__main__":
    app = Main()
    app.run()