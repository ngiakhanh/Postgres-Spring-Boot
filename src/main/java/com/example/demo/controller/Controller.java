package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mess.CustomeMessReceive;
import com.example.demo.model.Model;
import com.example.demo.serviceInterface.ServiceInterface;

@RestController
@RequestMapping(value = "/")
public class Controller {

	@Autowired
	private ServiceInterface service;

	@RequestMapping(value = "/dashboard",method = RequestMethod.DELETE)
    public ResponseEntity<?> showAllModels(@RequestHeader HttpHeaders header)
    {
		return new ResponseEntity<>(null, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/users",
            method = RequestMethod.POST)
    public ResponseEntity<?> addModel(@RequestHeader HttpHeaders header, @RequestBody Model model) {
		Optional<Model> result = service.findById(model.getId());
		if (result.isPresent() ) 
		{
			return new ResponseEntity<>(new CustomeMessReceive("Fail", "This user existed in database", result), HttpStatus.OK);
		}
		else
		{
			service.save(model);
			return new ResponseEntity<>(new CustomeMessReceive("Success", "Added " +model.getName() + " successfully", result), HttpStatus.CREATED);
		}
	}
	
	
    @RequestMapping(value = {"/users"},
            method = RequestMethod.GET)
    public ResponseEntity<?> getAllModels(@RequestHeader HttpHeaders header) {
    	List<Model> result = service.findAll();
    	if (result.isEmpty()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
	
    @RequestMapping(
            value = "/users/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<?> getModelWithId(@RequestHeader HttpHeaders header, @PathVariable("id") int id) {
    	Optional<Model> result = service.findById(id);
		if (!result.isPresent() )
		{
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }

	
    @RequestMapping(
            value = "/users/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<?> updateModelFromDB(@RequestHeader HttpHeaders header, @PathVariable("id") int id, @RequestBody Model model) {
    	
    	model.setId(id);
    	Optional<Model> result = service.findById(id);
		if (result.isPresent() )
		{
    	return new ResponseEntity<>(new CustomeMessReceive("Success", "Update info successfully!", service.update(model)), HttpStatus.OK);    	
    	}
    	else
    	{
    	return new ResponseEntity<>(new CustomeMessReceive("Fail", "User not found", null), HttpStatus.OK);
    	}
   }
	
	
    @RequestMapping(
            value = "/users/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteModelWithId(@RequestHeader HttpHeaders header, @PathVariable int id) {
    	Optional<Model> result = service.findById(id);
    	if (result.isPresent() ) 
		{
    		service.delete(id);
    		return new ResponseEntity<>(new CustomeMessReceive("Success", "Delete successfully!", result), HttpStatus.OK);
    	}
    	return new ResponseEntity<>(new CustomeMessReceive("Fail", "User not found", result), HttpStatus.OK);
    }
    /*
    
    @RequestMapping(
    		value = "/users",
            method = RequestMethod.DELETE)
    public void deleteAllModels() {
        repository.deleteAll();;
    }*/
}
