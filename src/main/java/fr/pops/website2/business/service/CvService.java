package fr.pops.website2.business.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pops.website2.business.entity.CvItem;
import fr.pops.website2.persistence.CvRepository;

@Service
public class CvService {

	@Autowired
	private CvRepository cvRep;
	
	public List<CvItem> getCv(){
		return this.cvRep.findAll().stream()
				.sorted(Comparator.comparing(CvItem::getId))
				.collect(Collectors.toList());
	}
	
}