package com.example.caveatemptorv2.service.impl;

import com.example.caveatemptorv2.dto.BidDto;
import com.example.caveatemptorv2.model.Bid;
import com.example.caveatemptorv2.model.Item;
import com.example.caveatemptorv2.model.User;
import com.example.caveatemptorv2.repository.BidRepository;
import com.example.caveatemptorv2.service.BidService;
import com.example.caveatemptorv2.service.ItemService;
import com.example.caveatemptorv2.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidServiceImpl implements BidService {
    private final BidRepository bidRepository;
    private final ItemService itemService;
    private final UserService userService;

    public BidServiceImpl(BidRepository bidRepository, ItemService itemService, UserService userService) {
        this.bidRepository = bidRepository;
        this.itemService = itemService;
        this.userService = userService;
    }

    @Override
    public Bid addNewBid(BidDto bidDto) {
        Item item = itemService.getItemByName(bidDto.getItemName());
        User user = userService.getUserByName(bidDto.getUserName());
        Bid bid = new Bid(bidDto.getAmount(), bidDto.getCreatedOn(),user,item);
        item.getBids().add(bid);
        user.getBids().add(bid);
        return bidRepository.save(bid);
    }

    @Override
    public void updateBid(Bid bid) {
        if(bidRepository.existsById(bid.getId())){
            bidRepository.save(bid);
        }
    }

    @Override
    public boolean deleteBid(Long id) {
        if(bidRepository.existsById(id)){
            bidRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Bid getBidById(Long id) {
        return bidRepository.getById(id);
    }

    @Override
    public List<Bid> getBidByBidderId(Long bidderId) {
        return bidRepository.getBidsByBidder(bidderId);
    }

    @Override
    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }
}
