package controller;
 
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
 
import javax.validation.Valid;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
 
@Controller
@RequestMapping("/formulario")
public class AlumnoController {
   
    @RequestMapping(method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
    	Alumno student = new Alumno();
        model.addAttribute("alumno", student);
        return "formularioalumno";
    }
 
    @RequestMapping(method = RequestMethod.POST)
    public String saveRegistration(@Valid Alumno student, BindingResult result, ModelMap model){
    	
    	String fileName = null;
		String mensaje = null;

    	if (!student.getFoto().isEmpty()) {
            try {
                byte[] bytes = student.getFoto().getBytes();
                fileName = student.getFoto().getOriginalFilename(); 
 
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                {
                	dir.mkdirs();
                }  
 
                File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
 
                System.out.println(serverFile.getAbsolutePath());
 
            } catch (Exception e) {
            	mensaje = "Se ha liado parda " + fileName + " => " + e.getMessage();
            }
        } else {
        	mensaje = "No me traigas ficheros vacíos gañan";
        }
    	String msj = "exito";
    	
        if(result.hasErrors()) //si hay errores, volvemos al formulario
        	{
                msj = "formularioalumno";
        	}
        else {
        	model.addAttribute("msjconfirmacion", "Señor/a "+ student.getFirstName()+" , su registro se ha completado!");
            System.out.println(student.toString());
        	
        }

        return msj;
    }
 
 
}