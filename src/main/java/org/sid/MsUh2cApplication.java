package org.sid;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;




@SpringBootApplication
public class MsUh2cApplication implements CommandLineRunner {
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private FormationRepository formationRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
   
	public static void main(String[] args) {
		SpringApplication.run(MsUh2cApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	//	Etudiant et=new Etudiant(null,"Hassan","Hassan",new Date());
	//	etudiantRepository.save(et);
		repositoryRestConfiguration.exposeIdsFor(Formation.class,Etudiant.class);
		
		
		    	
		   	
		
		Formation f1=formationRepository.save(new Formation(null,"PHP",30,null));
		Formation f2=formationRepository.save(new Formation(null,"Oracle",30,null));
		Formation f3=formationRepository.save(new Formation(null,"Java",30,null));
		etudiantRepository.save(new Etudiant(null,"Hassan","Hassan",new Date(),f1));
		etudiantRepository.save(new Etudiant(null,"Mohamed","Mohamed",new Date(),f1));
		etudiantRepository.save(new Etudiant(null,"Nabila","Nabila",new Date(),f2));
		etudiantRepository.save(new Etudiant(null,"Hannan","Hannan",new Date(),f3));
	}
	
	@Bean
	public WebMvcConfigurer configure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://localhost:4200")
		.allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowedHeaders("*");;
			}
			
		};
	}

}
