package com.mongojava.mongorest.services;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongojava.mongorest.models.ApplicantsModel;
import com.mongojava.mongorest.repositories.ApplicantRepository;

@Service
public class ApplicantServices {
 
 @Autowired
 private ApplicantRepository apprepo;
 
 public List<ApplicantsModel> getAllApplicants()
 {
  return apprepo.findAll();
 }
 
 public ApplicantsModel addNewApplicant(ApplicantsModel a)
 {
  Calendar cal=Calendar.getInstance();
  a.setApplydate(cal.getTime().toString());
  return apprepo.save(a);
 }
 
 public List<ApplicantsModel> getApplicants(String skill)
 {
  return apprepo.findBySkills(skill);
 }

public ApplicantsModel removeApplicant(int id) {
	ApplicantsModel app = apprepo.findById(id);
	apprepo.deleteById(id);
	return app;
}

}
