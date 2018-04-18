package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.example.demo.serviceInterface.ServiceInterface;
import com.example.demo.model.Model;
import com.example.demo.repository.MyRepository;

@Service
@Validated
@Transactional
public class MyService implements ServiceInterface {
	@Autowired
	private MyRepository repository;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Model save(Model user) 
	{
		return repository.save(user);
	}

	@Override
	public Optional<Model> findById(int id) {
		return repository.findById(id);
	}
	
	@Override
	public List<Model> findAll() {
		return repository.findAll();
	}

	@Override
	public Model update(Model user) {
			user = entityManager.merge(user);
			return user;
	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);
	}
}