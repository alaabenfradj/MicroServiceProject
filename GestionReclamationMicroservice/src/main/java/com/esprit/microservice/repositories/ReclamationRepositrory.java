package com.esprit.microservice.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.microservice.entities.Reclamation;



@Repository
public interface ReclamationRepositrory extends JpaRepository<Reclamation, Integer>  {
	@Query("select r from Reclamation r where r.title = :title")
	public List<Reclamation> findReclamationsByTitle(@Param("title")String title);
	@Query("select r from Reclamation r where r.date = :date")
	public List<Reclamation> findReclamationsByDate(@Param("date")Date date);
	@Query("select r from Reclamation r where r.ownerId = :id")
	public List<Reclamation> findReclamationsByOwnerId(@Param("id")String id);
	@Query("select r from Reclamation r where r.date between :startDate and :endDate")
	public List<Reclamation> findReclamationBetweentwoDates( @Param("startDate")Date startDate , @Param("endDate")Date endDate);
	@Query("select a from Reclamation a where (?1 is null or a.title = ?1) and (?2 is null or a.status= ?2) and (?3 is null or a.ownerId = ?3)and (?4 is null or a.date between ?4 and ?5)")
	 public List<Reclamation> findFiltredReclamation( @Param("title")String title , @Param("status")boolean status,@Param("ownerId")String ownerId,@Param("startDate")Date startDate,@Param("endDate")Date endDate);
}