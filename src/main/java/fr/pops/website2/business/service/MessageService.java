package fr.pops.website2.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pops.website2.business.entity.Message;
import fr.pops.website2.persistence.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRep;
	
	public List<Message> messageList(){
		return messageRep.findAll();
	}
	
	public void createMessage(Message message) {
		this.messageRep.save(message);
	}
	
}