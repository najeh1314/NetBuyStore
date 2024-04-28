package com.pi;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
/*On n'a rein à ajouter dans cette class par ce que son role est de lancer le serveur Tomcat*/
public class jerseyConfig extends ResourceConfig  {
 
	public jerseyConfig() {
		register(RestApi.class);
	}
}