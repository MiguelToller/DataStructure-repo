package ex5;

public class Cidade {
	
	private String nome;
	private String sigla;
	
	public Cidade() {}

	public Cidade(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
    @Override
    public String toString() {
        return nome + " - " + sigla;
    }  
	
    @Override
    public boolean equals(Object obj) {
        Cidade other = (Cidade) obj;
        if (!nome.equals(other.nome)) return false;
        return true;
    }
}
