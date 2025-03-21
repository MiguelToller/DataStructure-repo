package geradorEmail;

public class Pessoa {
	
	private String nome;
	private String email;
	
	public Pessoa() {}
	
	public Pessoa(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}
	
	public boolean validarNome(String nome) {
		
		String parte[] = nome.split(" ");
		return parte.length >= 2;
	}
	
	public String gerarEmail(String nome) {
		
		String parte[] = nome.split(" ");
		String primeiroNome = parte[0].toLowerCase();
		String ultimoNome = parte[parte.length - 1].toLowerCase();
		return primeiroNome + "." + ultimoNome + "@ufn.edu.br";
	}
}
