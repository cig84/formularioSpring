<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="./css/estilo.css">
    <title>Formulario</title>
    
    <script type="text/javascript">
    
    	var xmlHttp = new XMLHttpRequest();
    	var dni="";
    	
    	function sacarDNI(){
    		dni = document.getElementById("dni").value;
    		xmlHttp.onreadystatechange = procesarEventos; // llama a procesarEventos cada vez que cambia el estado.
    		xmlHttp.open('GET', 'http://172.16.1.209:8090/Spring/calculaLetraDni?dni=' + dni, true); //indicamos como vamos a enviar los datos, en este caso con el metodo GET a la clase Servlet GenerarColores
    		xmlHttp.send(null);
    		
    	}
    	
    	function procesarEventos(){
    		//Obtenemos el control del TAG que contendrá la respuesta
    		if (xmlHttp.readyState == 4) { //ya hemos recibido respuesta del servidor
    		
    			if (xmlHttp.status == 200) { // y el código de la cabecera http es bueno
    				
    				letraDNI(xmlHttp.responseText);
    				
    	          }
    	      else
    	      {
    	          alert("Ha ocurrido un error"+ xmlHttp.status +":"+ xmlHttp.statusText);
    	      }
    		}
    	}
    	
    	function letraDNI(texto){
    		
    		document.getElementById("dni").value = dni +"-"+ texto;
    		
    		
    	}


	</script>
</head>
 
<body>
     
    <h1>Formulario</h1>
    
    <a href="formulario?idioma=es"><img alt="Bandera española" src="imagenes/Spain.jpg"></a>
	<a href="formulario?idioma=it"><img alt="Bandera italiana" src="imagenes/Italy.jpg"></a>
	<a href="formulario?idioma=en"><img alt="Bandera kingdoner" src="imagenes/UK.jpg"></a>
     
    <form:form action="formulario" method="POST" modelAttribute="alumno" enctype="multipart/form-data" >
 
				<spring:message code="formnombre"></spring:message>
                <form:input type="text" path="firstName" id="firstName"/>
                <form:errors path="firstName" class="errorsp"/><br><br>            
				
				<spring:message code="formedad"></spring:message>
				<form:input type="text" path="edad" id="edad"/>
				<form:errors path="edad" class="errorsp"/><br><br>
				
				<spring:message code="formdesc"></spring:message>
				<form:input type="textarea" path="descripcion" rows="3" cols="8" id="descripcion"/>
				<form:errors path="descripcion" class="errorsp"/><br><br>
				
				<spring:message code="formdni"></spring:message>
                <form:input type="text" path="dni" id="dni" onblur="sacarDNI();"/>
                <form:errors path="dni" class="errorsp"/><br><br>
                
                <spring:message code="formfoto"></spring:message>
       			<form:input type="file" path="foto"/><br><br>
       			<input type="submit" value="Registra"/>
       			<form:errors path="foto" class="errorsp"/>
 
		
    </form:form>
    
</body>
</html>