package com.example.demo.serviceInterface;

import java.util.Optional;

import com.example.demo.model.Model;

public interface ServiceInterface {

		Model save(Model user);

		Optional<Model> findById(int id);

		java.util.List<Model> findAll();

		Model update(Model user);

		void delete(int id);

}
