package com.example.clubservice.controllers;

import com.example.clubservice.entites.CLubMembers;
import com.example.clubservice.entites.Club;
import com.example.clubservice.services.IClubMembersService;
import com.example.clubservice.services.IClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/clubs")
public class ClubController {
    @Autowired
    private IClubService clubService;
    @Autowired
    private IClubMembersService clubMembersService;

    @GetMapping
    public ResponseEntity<List<Club>> getClubs() {
        try {
            List<Club> clubs = clubService.getClubs();
            if (clubs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(clubs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Club> getClubById(@PathVariable("id") Long id) {
        try {
            Club club = clubService.getClubById(id).get();
            if (club == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(club, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Club> addClub(@RequestBody Club club) {
        try {
            Club newClub = clubService.addClub(club);
            return new ResponseEntity<>(newClub, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Club> updateClub(@RequestBody Club club) {
        try {
            Club newClub = clubService.updateClub(club);
            return new ResponseEntity<>(newClub, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteClub(@PathVariable("id") Long id) {
        try {
            clubService.deleteClub(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Club> getClubByName(@PathVariable("name") String name) {
        try {
            Club club = clubService.getClubByName(name).get();
            if (club == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(club, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/subscribe/{clubId}/{userId}")
    public ResponseEntity<CLubMembers> subscribe(@PathVariable("clubId") Long clubId, @PathVariable("userId") Long userId) {
        try {
            CLubMembers clubMembers = clubMembersService.subscribe(clubId, userId);
            return new ResponseEntity<>(clubMembers, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/unsubscribe/{clubId}/{userId}")
    public ResponseEntity<HttpStatus> unsubscribe(@PathVariable("clubId") Long clubId, @PathVariable("userId") Long userId) {
        try {
            clubMembersService.unsubscribe(clubId, userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

