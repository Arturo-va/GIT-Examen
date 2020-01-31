package app.modelo;

import java.io.Serializable;

public class Contacto implements Serializable {
	private int idContacto;
	private String nombre;
	private String correoElectronico;
	private String telefono;
	
	public Contacto() {
		super();
	}

	public Contacto(int idContacto, String nombre, String correoElectronico, String telefono) {
		super();
		this.idContacto = idContacto;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.telefono = telefono;
	}

	public int getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Contacto [idContacto=" + idContacto + ", nombre=" + nombre + ", correoElectronico=" + correoElectronico
				+ ", telefono=" + telefono + "]";
	}
	
	
	


}
