package br.com.augusto.livraria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.augusto.livraria.dao.DAO;
import br.com.augusto.livraria.model.Autor;
import br.com.augusto.livraria.model.Livro;

@ManagedBean
@ViewScoped
public class LivroBean {
	private Livro livro = new Livro();
	private Integer autorId;
	
	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public Livro getLivro() {
		return livro;
	}
	
	public List<Autor> getAutoresDoLivro(){
		return this.livro.getAutores();
	}
	
	public List<Autor> getAutores() {
		return new DAO<Autor>(Autor.class).listaTodos();
	}
	
	public void gravarAutor() {
		Autor autor = new DAO<Autor>(Autor.class).buscaPorId(this.autorId);
		this.livro.adicionaAutor(autor);
	}
	
	public void gravar() {
		System.out.println("Gravando livro " + this.livro.getTitulo());
		if(livro.getAutores().isEmpty()) {
			throw new RuntimeException("Livro deve conter pelo menos um autor");
		}
		new DAO<Livro>(Livro.class).adicionar(livro);
	}
}
