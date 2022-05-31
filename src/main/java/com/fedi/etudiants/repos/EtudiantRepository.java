package com.fedi.etudiants.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fedi.etudiants.entities.Parcours;
import com.fedi.etudiants.entities.Etudiant;
@RepositoryRestResource(path = "rest")
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	List<Etudiant> findByNomEtudiant(String nom);
	List<Etudiant> findByNomEtudiantContains(String nom);
	@Query("select p from Etudiant p where p.nomEtudiant like %?1 and p.cinEtudiant > ?2")
	List<Etudiant> findByNomCin (String nom, int cin);
	/*@Query("select p from Etudiant p where p.nomEtudiant like %:nom and p.cinEtudiant > :cin")
	List<Etudiant> findByNomCin (@Param("nom") String nom,@Param("cin") Double cin);
*/
	@Query("select p from Etudiant p where p.parcours = ?1")
	List<Etudiant> findByParcours (Parcours parcours);
	List<Etudiant> findByParcoursIdParc(Long id);
	List<Etudiant> findByOrderByNomEtudiantAsc();
	@Query("select p from Etudiant p order by p.nomEtudiant ASC, p.cinEtudiant DESC")
	List<Etudiant> trierEtudiantsNomsCin ();
	 @Query("select p from Etudiant p where p.parcours.nomParc like ?1")
	 List<Etudiant> findByNomParcoursContains(String nom);

}