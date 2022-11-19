package com.example.clubservice.services;

import com.example.clubservice.entites.Club;
import com.example.clubservice.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService implements IClubService {


    @Autowired
    private ClubRepository clubRepository;

    @Override
    public List<Club> getClubs() {
        return clubRepository.findAll();

    }

    @Override
    public Optional<Club> getClubById(Long id) {
        return clubRepository.findById(id);
    }

    @Override
    public Club addClub(Club club) {
        return clubRepository.save(club);
    }

    @Override
    public Club updateClub(Club club) {
        return clubRepository.save(club);
    }

    @Override
    public void deleteClub(Long id) {
        clubRepository.deleteById(id);
    }

    @Override
    public Optional<Club> getClubByName(String name) {
        return clubRepository.findByName(name);
    }
}

