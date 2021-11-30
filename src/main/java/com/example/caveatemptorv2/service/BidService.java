package com.example.caveatemptorv2.service;

import com.example.caveatemptorv2.dto.BidDto;
import com.example.caveatemptorv2.model.Bid;

import java.util.List;

public interface BidService {
    public Bid addNewBid(BidDto bidDto);
    public void updateBid(Bid bid);
    public boolean deleteBid(Long id);
    public Bid getBidById(Long id);
    public List<Bid> getBidByBidderId(Long bidderId);
    public List<Bid> getAllBids();
}
