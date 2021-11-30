package com.example.caveatemptorv2.repository;

import com.example.caveatemptorv2.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {
    @Query(value = "SELECT * FROM Bid WHERE bidder_id = ?1",nativeQuery = true)
    List<Bid> getBidsByBidder(Long bidderId);
}
