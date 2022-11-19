package com.example.clubservice.repositories;

import com.example.clubservice.entites.CLubMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubMembersRepository extends JpaRepository<CLubMembers, Long> {
}

