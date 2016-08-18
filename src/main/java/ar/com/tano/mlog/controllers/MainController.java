package ar.com.tano.mlog.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.tano.mlog.domain.MLogDTO;
import ar.com.tano.mlog.services.MlogService;

@RestController
public class MainController {

	@Autowired
	public MlogService service;
	
	@RequestMapping(value="/api/mlog", method=RequestMethod.GET)
	public List<MLogDTO> getMlogs() throws IOException{
		
		return service.getMlogsDTO();
	}
	@RequestMapping(value="/api/mlog/{id}", method=RequestMethod.GET)
	public MLogDTO getMlog(@PathVariable Long id) throws IOException{
		
		return service.getMlog(id);
	}
	@RequestMapping(value="/api/mlog", method=RequestMethod.POST)
	public void addMlog(@RequestBody MLogDTO mlogDto) throws IOException{
		service.createMlog(mlogDto);
	}
	@RequestMapping(value="/api/mlog", method=PUT)
	public MLogDTO updateBook(@RequestBody MLogDTO mlogDto) throws IOException{
		return service.updateMlog(mlogDto);
	}
	
	@RequestMapping(value="/api/mlog/{id}",method=DELETE)
	public void deleteBook(@PathVariable Long id) throws IOException{
		service.removeMlog(id);
	}
}
