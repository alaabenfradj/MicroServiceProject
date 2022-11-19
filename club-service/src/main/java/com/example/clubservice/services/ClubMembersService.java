package com.example.clubservice.services;

import com.example.clubservice.entites.CLubMembers;
import com.example.clubservice.entites.Club;
import com.example.clubservice.repositories.ClubMembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubMembersService implements IClubMembersService {

    @Autowired
    private ClubMembersRepository clubMembersRepository;
    @Autowired
    private ClubService clubService;


    @Override
    public CLubMembers subscribe(Long idClub,Long idMember) {
        Club club = clubService.getClubById(idClub).get();
        CLubMembers clubMembers = new CLubMembers();
        clubMembers.setClub(club);
        return clubMembersRepository.save(clubMembers);
    }

    @Override
    public void unsubscribe(Long clubId, Long memberId) {
         List<CLubMembers> members = clubMembersRepository.findAll();
            for (CLubMembers member : members) {
                if (member.getClub().getId() == clubId && member.getMemberId() == memberId) {
                    clubMembersRepository.delete(member);
                }
            }
    }


}




