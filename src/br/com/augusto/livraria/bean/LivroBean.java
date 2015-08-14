package br.com.augusto.livraria.bean;

import javax.faces.bean.ManagedBean;

import br.com.augusto.livraria.dao.DAO;
import br.com.augusto.livraria.model.Livro;

@ManagedBean
public class LivroBean {
	private Livro livro = new Livro();

	public Livro getLivro() {
		return livro;
	}
	
	public void gravar() {
		System.out.println("Gravando livro " + this.livro.getTitulo());
		
		new DAO<Livro>(Livro.class).adicionar(livro);
	}
}
