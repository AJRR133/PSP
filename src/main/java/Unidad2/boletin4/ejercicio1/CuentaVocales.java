package Unidad2.boletin4.ejercicio1;

import java.util.Objects;

public class CuentaVocales {

	public String texto;
	public int numtotalvo;

	public int getNumtotalvo() {
		return numtotalvo;
	}

	public void setNumtotalvo(int numtotalvo) {
		this.numtotalvo = numtotalvo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(texto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaVocales other = (CuentaVocales) obj;
		return Objects.equals(texto, other.texto);
	}

	public CuentaVocales(String texto) {
		super();
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "CuentaVocales [texto=" + texto + "]";
	}
	
	
	
	
	
}
