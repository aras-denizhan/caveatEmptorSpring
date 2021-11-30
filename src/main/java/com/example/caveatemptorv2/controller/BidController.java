package com.example.caveatemptorv2.controller;

import com.example.caveatemptorv2.dto.BidDto;
import com.example.caveatemptorv2.model.Bid;
import com.example.caveatemptorv2.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/bid")
public class BidController {
    private BidService bidService;

    @Autowired
    public BidController(BidService bidService){
        this.bidService = bidService;
    }

    @PostMapping
    public Bid addNewBid(@RequestBody @Valid BidDto bidDto) {
        Objects.requireNonNull(bidDto,"User cannot be null.");
        return bidService.addNewBid(bidDto);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteBid(@PathVariable Long id) {
        return bidService.deleteBid(id);
    }

    @GetMapping("/{id}")
    public Bid getBidById(@PathVariable Long id) {
        return bidService.getBidById(id);
    }

    @GetMapping("/user/{id}")
    public List<Bid> getBidByBidderId(@PathVariable Long id){
        return bidService.getBidByBidderId(id);
    }

    @GetMapping("/all")
    public List<Bid> getAllBids() {
        return bidService.getAllBids();
    }
}
