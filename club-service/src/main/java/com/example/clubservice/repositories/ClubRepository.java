package com.example.clubservice.repositories;

import com.example.clubservice.entites.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    public Optional<Club> findByName(String name);

}

