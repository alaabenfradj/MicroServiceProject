package com.esprit.microservice.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;


import com.esprit.microservice.entities.Reclamation;
import com.esprit.microservice.repositories.ReclamationRepositrory;


@Service
public  class ReclamationService implements IReclamationService {
    @Autowired
    ReclamationRepositrory reclamationRepositrory;
	@Override
	public Reclamation addReclamation(Reclamation reclamation) {
		// TODO Auto-generated method stub
		Date newDate = new Date();
		reclamation.setDate(newDate);
		return reclamationRepositrory.save(reclamation);
	}

	
	@Override
	public String deleteReclamation(int id) {
		// TODO Auto-generated method stub
		reclamationRepositrory.deleteById(id);
		return "Relamation deleted successfuly";
	}

	@Override
	public List<Reclamation> getReclamations() {
		
		return reclamationRepositrory.findAll();
	}

	@Override
	public Reclamation getReclamationById(int id) {
		
		return reclamationRepositrory.findById(id).get();
	}

	@Override
	public List<Reclamation> getReclamationsByTitle(String title) {
		// TODO Auto-generated method stub
		List<Reclamation>reclamations=reclamationRepositrory.findReclamationsByTitle(title);
		return reclamations;
	}

	@Override
	public List<Reclamation> getReclamationsByOwner(String ownerId) {
		List<Reclamation>reclamations=reclamationRepositrory.findReclamationsByOwnerId(ownerId);
		return reclamations;
	}

	@Override
	public List<Reclamation> getReclamationsByDate(Date date) {
		List<Reclamation>reclamations=reclamationRepositrory.findReclamationsByDate(date);
		return reclamations;
	}

	@Override
	public Reclamation updateReclamationByOwner(int id, Reclamation newreclamation) {
		// TODO Auto-generated method stub
		Reclamation r = reclamationRepositrory.findById(id).get();
		if(newreclamation.getTitle()!= null) {
			r.setTitle(newreclamation.getTitle());
		}
		if(newreclamation.getContent()!= null) {
			r.setContent(newreclamation.getContent());
		}
		if(newreclamation.getDate()!= null) {
			r.setDate(newreclamation.getDate());
		}
		if(newreclamation.getStatus()!= null) {
			r.setStatus(newreclamation.getStatus());
		}
		if(newreclamation.getEventId()!= null) {
			r.setEventId(r.getEventId());
		}
		
		return reclamationRepositrory.save(r);
	
			}




	@Override
	public List<Reclamation> getReclamationsBetweenTwoDate(Date startDate, Date endDate) {
		return reclamationRepositrory.findReclamationBetweentwoDates(startDate, endDate);
	}




	@Override
	public List<Reclamation> getfilterReclamations(String title, boolean status, String ownerId,Date startDate,Date endDate) {
		// TODO Auto-generated method stub
	  //Reclamation example=Reclamation.builder().title(title).ownerId(ownerId).build();
	//System.out.println(example);
		//return reclamationRepositrory.findAll(Example.of(example));
		return reclamationRepositrory.findFiltredReclamation(title, status, ownerId,startDate,endDate);
	}
	/*ExampleMatcher matcher = ExampleMatcher.matching()
			.withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains())
		      .withMatcher("content", ExampleMatcher.GenericPropertyMatchers.contains())
		      .withMatcher("ownerId", ExampleMatcher.GenericPropertyMatchers.contains());*/




	@Override
	public Reclamation verifyReclamationByAdmin(int id, boolean status) {
		// TODO Auto-generated method stub
		Reclamation reclamation = reclamationRepositrory.findById(id).get();
		reclamation.setStatus(status);
		return 	reclamationRepositrory.save(reclamation);
	}
	

	
}