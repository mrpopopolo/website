package fr.pops.website2.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pops.website2.business.entity.CvItem;

@Repository
public interface CvRepository extends JpaRepository<CvItem, Integer> {

}
