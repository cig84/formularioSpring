package controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class MyController {
	
	@RequestMapping("/bienvenido2")
    public String holaMundo2(@RequestParam(value="name", required=false, defaultValue="Mundo") String name, Model model) {
        model.addAttribute("name", name);
        return "salida";
    }
	
	@RequestMapping(path = "/personaction", method = RequestMethod.POST)
	public String formularioPersona (@ModelAttribute Persona persona,
	Model model) {
	 
	System.out.println("Edad = "+ persona.getEdad());
	System.out.println("Nombre = "+ persona.getNombre());
	System.out.println("Descripcion = "+ persona.getDescripcion());
	model.addAttribute("personita", persona);
	return "datosPersona";
	}
	
	@RequestMapping("/rajoy")
	public String rajao() {
		
		return "rajoy";
	}
	
	@RequestMapping("/rajoyi")
	public String rajaoDefecto(HttpServletRequest request, HttpServletResponse response) {
		
		Locale locale = RequestContextUtils.getLocale(request);
		System.out.println("Locale antes = "+locale); //imprime en consola el valor actual del atributo defaultLocale
		RequestContextUtils.getLocaleResolver(request).setLocale(request, response, new Locale("es", "VE")); //esto es lo que hace el interceptor
		locale = RequestContextUtils.getLocale(request);
		System.out.println("Locale despues = "+locale); //imprime en consola el valor actual del atributo defaultLocale
		return "rajoyi";
	}

}
