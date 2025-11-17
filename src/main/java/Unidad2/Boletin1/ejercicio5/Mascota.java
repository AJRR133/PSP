package Unidad2.Boletin1.ejercicio5;

import java.util.Objects;

public class Mascota implements Runnable{

	private String nombre;
	private int numcome;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumcome() {
		return numcome;
	}
	public void setNumcome(int numcome) {
		this.numcome = numcome;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombre, numcome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mascota other = (Mascota) obj;
		return Objects.equals(nombre, other.nombre) && numcome == other.numcome;
	}
	@Override
	public String toString() {
		return "Mascota [nombre=" + nombre + ", numcome=" + numcome + "]";
	}
	public Mascota(String nombre, int numcome) {
		super();
		this.nombre = nombre;
		this.numcome = numcome;
	}
	public Mascota() {
		super();
	}
	@Override
	public void run() {
		try {
			System.out.println(this.getNombre()+" ha comenzado a comer "+Thread.currentThread().getName()+" "+Thread.currentThread().getPriority());
			this.comer();
			Thread.sleep(1000);
			System.out.println(this.getNombre()+" ha terminado a comer "+Thread.currentThread().getName()+" " +Thread.currentThread().getPriority());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void comer() {
		numcome++;
	}
}
