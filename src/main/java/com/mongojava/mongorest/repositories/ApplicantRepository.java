package com.mongojava.mongorest.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongojava.mongorest.models.ApplicantsModel;

public interface ApplicantRepository extends MongoRepository<ApplicantsModel, Integer> {
	public List<ApplicantsModel> findBySkills(String skill);
	public ApplicantsModel findById(int id);
}
