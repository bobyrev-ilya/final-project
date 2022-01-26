package com.example.server.repository;


import com.example.server.entity.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardCrudRepository extends CrudRepository<Card,Long> {

    Optional<Card> getCardByNumber(String cardNumber);
}
