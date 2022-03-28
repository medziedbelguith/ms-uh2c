package org.sid;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
	
  public List<Etudiant> findByNomContains(String nom);
}
