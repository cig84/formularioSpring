package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DNIController {
	
	@RequestMapping(path = "/dni", method = RequestMethod.GET)
	@ResponseBody
    public String getDNI(@RequestParam(value="dni") String dni) {
    	
        return "formularioalumno";
    }

}
