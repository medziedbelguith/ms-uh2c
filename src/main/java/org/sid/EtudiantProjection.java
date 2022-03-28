package org.sid;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="p1",types= {Etudiant.class})
public interface EtudiantProjection {

	public String getNom();
	
	public Formation getFormation();

}
