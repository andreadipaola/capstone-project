package main.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {

}