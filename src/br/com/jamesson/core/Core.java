package br.com.jamesson.core;

import br.com.jamesson.core.linux.ServiceLinux;

public class Core {
	
	public Boolean findServiceLinux(String serviceName) {
		return new ServiceLinux().findService(serviceName);	
	}
}
