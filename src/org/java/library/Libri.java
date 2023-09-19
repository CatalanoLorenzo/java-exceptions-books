package org.java.library;
//Vogliamo gestire il catalogo di libri di una biblioteca.

//
//La class `Libro` è composta da:
//- `titolo`
//- `numero pagine`
//- `autore`
//- `editore`

//------------------------
public class Libri {
	private String titolo;
	private int numeroPagine;
	private String autore;
	private String editore;

//------------------------
	public Libri(String _titolo, int _numeroPagine, String _autore, String _editore) throws Exception {

		this.setTitolo(_titolo);
		this.setNumeroPagine(_numeroPagine);
		this.setAutore(_autore);
		this.setEditore(_editore);
	}

//------------------------
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) throws Exception {

		if (titolo.isBlank()) {

			throw new Exception("titolo non puo essere vuoto");
		}

		this.titolo = titolo;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) throws Exception {

		if (numeroPagine <= 0) {

			throw new Exception("le pagine non possono essere uguali o minori di zero!!");

		}
		this.numeroPagine = numeroPagine;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) throws Exception {

		if (autore.isBlank()) {

			throw new Exception("L'autore non puo essere vuoto");
		}
		this.autore = autore;
	}

	public String getEditore() {
		return editore;
	}

	public void setEditore(String editore) throws Exception {

		if (editore.isBlank()) {

			throw new Exception("L'editore non puo essere vuoto");
		}
		this.editore = editore;
	}

//------------------------
	@Override
	public String toString() {

		return "Il Libro ha come Autore: " + this.getAutore() + " come Editore : " + this.getEditore()
				+ " come Titolo : " + this.getTitolo() + " e avrà " + this.getNumeroPagine() + " pagine";
	}
}
