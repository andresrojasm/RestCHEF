package RestServer.service;

import java.util.ArrayList;
import java.util.List;

import RestServer.model.Message;

public class MessageService {

	List<Message> list = new ArrayList<>();
	
	
	public MessageService(){
		Message m1 = new Message(1L, "Hello 1", "pablo");
		Message m2 = new Message(2L, "Hello 2", "pablo2");
		list.add(m1);
		list.add(m2);
	}
	
	public List<Message> getAllMessages(){
		
		
		return list;
		
	}

	public Message getMessage(long id) {
		
		return list.get((int) id -1);
	}
	
}
