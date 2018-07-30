package br.com.jamesson.spring.services;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jamesson.core.Core;


@RestController
@RequestMapping("/api")
public class ServicesController {	
	
    @RequestMapping(value ="/findService/{serviceName}",  method = {RequestMethod.GET})
    Boolean findService(@PathVariable String serviceName) {
    	return	new Core().findServiceLinux(serviceName);
     }
}
