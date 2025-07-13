package com.rajukrsoni.rest.webservices.restfull_we_bservices.JPARepository;

import com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.request.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserRequest, Integer> {
}
