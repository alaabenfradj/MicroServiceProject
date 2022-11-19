package com.esprit.microservices.contollers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.microservices.bean.ReclamationResponse;
import com.esprit.microservices.client.ReclamationClient;
import com.esprit.microservices.entities.Event;
import com.esprit.microservices.services.IServiceEvent;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "http://localhost:3000")
public class EventController {

	@Autowired
	IServiceEvent serviceEvent ;

	
	@Autowired
    com.esprit.microservices.client.UserClient userClient;
	@Autowired
	ReclamationClient reclamationClient ;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/add")
	public ResponseEntity<Event> addEvent (@RequestBody Event event,HttpServletRequest request){
	    return new ResponseEntity<Event>(serviceEvent.addEvent(event),HttpStatus.CREATED);		
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/update/{id}")
	public ResponseEntity<Event> updateEvent (@PathVariable("id") int id,@RequestBody Event event){
		return new ResponseEntity<Event>(serviceEvent.updateEvent(id, event),HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEvent (@PathVariable("id") int id){
		return new ResponseEntity<String>(serviceEvent.deleteEvent(id),HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/all")
	public ResponseEntity<List<Event>>getEvents(){
		return new ResponseEntity<List<Event>>(serviceEvent.getEvents(),HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/{id}")
	public ResponseEntity<Event>getEvent(@PathVariable("id")int id){
		return new ResponseEntity<Event>(serviceEvent.getEvent(id),HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/title")
	public ResponseEntity<List<Event>>getEventsByTitle(@RequestParam("title")String title){
		return new ResponseEntity<List<Event>>(serviceEvent.getEventByTitle(title),HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/date")
	public ResponseEntity<List<Event>>getEventsByDate(@RequestParam("date1")@DateTimeFormat(pattern = "dd-MM-yyyy") Date date1,@RequestParam("date2")@DateTimeFormat(pattern = "dd-MM-yyyy") Date date2){
		return new ResponseEntity<List<Event>>(serviceEvent.getEventByDate(date1,date2),HttpStatus.OK);
	}
	@PostMapping("/assign")
    public ResponseEntity<Event>assignRecs(@RequestParam(required = false,name = "eventId")int Evid,@RequestParam(required = false,name = "reclamationId")String recId){
        return new ResponseEntity<Event>(serviceEvent.assignRecToEvent(Evid, recId),HttpStatus.OK);
    }
	
	@GetMapping("/reclamations/{id}")
	public ResponseEntity<List<ReclamationResponse>>getRecsByEvent(@PathVariable("id")int id){
	    Event event = serviceEvent.getEvent(id);
	    List<ReclamationResponse> reclamations = new ArrayList<>();
	    event.getReclamations().stream().forEach(r->{
	        reclamations.add(reclamationClient.getReclamationById(r));
	    });
        return new ResponseEntity<List<ReclamationResponse>>(reclamations ,HttpStatus.OK);
    }
	@GetMapping("/eventsAndRecs")
	public ResponseEntity<Map<String, Integer>>getEventsAndRecs(){
	    return new ResponseEntity<Map<String,Integer>>(serviceEvent.getEventsAndnumberOfRecs(),HttpStatus.OK);
	}
}
