package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
 
/**
 * Clase controller para subir ficheros
 */
@Controller
@RequestMapping
public class MiControllerFicheros {
 
    /**
     * Usamos este método para subir un fichero
     */
	@RequestMapping(value="/subirUnFichero", method = RequestMethod.POST)
    @ResponseBody
    public String guardarFichero(@RequestParam("file") MultipartFile file) {
    	
		String mensaje = null;
    	String fileName = null;
 
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                fileName = file.getOriginalFilename(); 
 
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
        return mensaje;
    }
 
  
}