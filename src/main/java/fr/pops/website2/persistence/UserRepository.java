package fr.pops.website2.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pops.website2.business.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findOneByUsername(String username);
}
