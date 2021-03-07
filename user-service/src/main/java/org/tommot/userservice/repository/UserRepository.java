package org.tommot.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tommot.userservice.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    User findUserById(Long userId);
}
