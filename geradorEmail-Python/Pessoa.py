class Pessoa:

    def __init__(self, nome = None, email = None):
        self.nome = nome
        self.email = email

    def get_nome(self):
        return self.nome
    
    def set_nome(self, nome):
        self.nome = nome
    
    def get_email(self):
        return self.email
    
    def validar_nome(self, nome):
        parte = nome.split(" ")
        return len(parte) >= 2
    
    def gerar_email(self, nome):
        parte = nome.split(" ")
        primeiro_nome = parte[0].lower()
        ultimo_nome = parte[-1].lower()
        return f"{primeiro_nome}.{ultimo_nome}@ufn.edu.br"
    
    def email_existe(self, list_dict, email):
        for dicionario in list_dict:
            if email in dicionario:
                return True # email existe
        return False # email nao existe
    
    def adicionar_indice_email(self, email, i):
        return email.split('@')[0] + str(i) + '@' + email.split('@')[1]