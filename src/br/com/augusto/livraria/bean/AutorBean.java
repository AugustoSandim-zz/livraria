package br.com.augusto.livraria.bean;

import javax.faces.bean.ManagedBean;

import br.com.augusto.livraria.dao.DAO;
import br.com.augusto.livraria.model.Autor;

@ManagedBean
public class AutorBean {
	Autor autor = new Autor();
	
	public Autor getAutor() {
		return autor;
	}
	
	public void gravar() {
		System.out.println("Gravando auto " + this.autor.getNome());
		
		new DAO<Autor>(Autor.class).adicionar(this.autor);
	}
}
