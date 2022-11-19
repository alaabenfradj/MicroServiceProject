package com.esprit.microservices.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservices.entities.Event;
import com.esprit.microservices.repositories.EventRepo;

@Service
@Transactional
public class ServiceEventImp implements IServiceEvent {

	@Autowired
	EventRepo repo;

	@Override
	public List<Event> getEvents() {

		return repo.findAll();
	}

	@Override
	public Event getEvent(int id) {

		return repo.findById(id).get();
	}

	@Override
	public Event addEvent(Event event) {
		return repo.save(event);
	}

	@Override
	public Event updateEvent(int id, Event newEvent) {
	    newEvent.setId(id);
		return repo.save(newEvent);
	}

	@Override
	public String deleteEvent(int id) {
		repo.deleteById(id);
		return "Event deleted successfully !" ;
	}

	@Override
	public List<Event> getEventByTitle(String name) {
		List<Event> events= repo.findEventByTitle(name);
		return events;
	}

	@Override
	public List<Event> getEventByDate(Date date1,Date date2) {
		List<Event> events= repo.findEventByDate(date1,date2);
		return events;
	}

    @Override
    public Event assignRecToEvent(Integer eventId,String recId) {
        Event e = repo.findById(eventId).get();
        e.getReclamations().add(recId);
        return e;
    }

    @Override
    public Map<String, Integer> getEventsAndnumberOfRecs() {
        List<Event> events = repo.findAll() ;
        Map<String, Integer> eventsMap = new HashMap<>();
        events.stream().forEach(e -> {
            eventsMap.put(e.getTitle(), e.getReclamations().size());
        });
        return eventsMap;
    }

    
}
