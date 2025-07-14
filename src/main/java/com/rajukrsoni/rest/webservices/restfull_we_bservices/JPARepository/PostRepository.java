package com.rajukrsoni.rest.webservices.restfull_we_bservices.JPARepository;

import com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.request.Post;
import com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.request.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    Optional<Post> findByIdAndUserId(int postId, int id);
}
