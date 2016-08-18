package ar.com.tano.mlog.controllers;

import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.tano.mlog.services.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService catServ;
	
	@RequestMapping(value="/cat", method=RequestMethod.GET)
	public Set<String> getCategories() throws IOException{
		return catServ.getCategories();
	}
}
