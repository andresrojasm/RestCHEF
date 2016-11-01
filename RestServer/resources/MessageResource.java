package RestServer.RestServer;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import RestServer.model.Message;
import RestServer.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService msgService = new MessageService();
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		return msgService.getAllMessages();
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String addMessage(){
		return "Post Works!";
	}
	
	
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long id){
		
		return msgService.getMessage(id);
	}
	
}
