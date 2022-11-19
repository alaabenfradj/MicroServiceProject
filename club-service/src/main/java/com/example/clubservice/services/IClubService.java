package com.example.clubservice.services;

import com.example.clubservice.entites.Club;

import java.util.List;
import java.util.Optional;

public interface IClubService {
    public List<Club> getClubs();

    public Optional<Club> getClubById(Long id);

    public Club addClub(Club club);

    public Club updateClub(Club club);

    public void deleteClub(Long id);

    public Optional<Club> getClubByName(String name);

}
