package com.example.clubservice.services;
import com.example.clubservice.entites.CLubMembers;
public interface IClubMembersService {
    public CLubMembers subscribe(Long clubId, Long memberId);
    public void unsubscribe(Long clubId, Long memberId);


}
