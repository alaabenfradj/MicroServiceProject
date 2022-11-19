package com.esprit.microservice.services;

import java.util.Date;
import java.util.List;

import com.esprit.microservice.entities.Reclamation;



public interface IReclamationService {
	public Reclamation addReclamation(Reclamation reclamation);
	public Reclamation updateReclamationByOwner(int id , Reclamation reclamation);
	public Reclamation verifyReclamationByAdmin(int id , boolean status);
	public String deleteReclamation(int id);
	public List<Reclamation> getReclamations ();
	public Reclamation getReclamationById(int id);
	public List<Reclamation> getReclamationsByTitle(String title);
	public List<Reclamation> getReclamationsByOwner(String ownerId);
	public List<Reclamation> getReclamationsByDate(Date date);
	public List<Reclamation> getReclamationsBetweenTwoDate(Date startDate,Date endDate);
	public List<Reclamation> getfilterReclamations(String title,boolean status,String ownerId,Date startDate,Date endDate);
	
}