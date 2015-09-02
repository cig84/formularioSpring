package controller;
 
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
 
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;
 
public class Alumno {
 
    @NotEmpty
    @Size(min = 3)
    private String firstName;
 
    @Min(value = 18)
    private int edad;
    
    private MultipartFile foto;
    
    @NotEmpty
    private String dni;
 
    @NotEmpty
    private String descripcion;
 
    public MultipartFile getFoto() {
		return foto;
	}

	public void setFoto(MultipartFile foto) {
		this.foto = foto;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    @Override
    public String toString() {
        return (firstName + " " + dni);
    }
 
}