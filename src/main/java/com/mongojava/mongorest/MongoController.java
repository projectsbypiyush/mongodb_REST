package com.mongojava.mongorest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongojava.mongorest.models.ApplicantsModel;
import com.mongojava.mongorest.services.ApplicantServices;

@RestController
public class MongoController {

 @Autowired
 private ApplicantServices appserv;
 
 @GetMapping("/allapps")
 public List<ApplicantsModel> getAllApps()
 {
  return appserv.getAllApplicants();
 }
 
 @PostMapping("/addapp")
 public ApplicantsModel addApp(@RequestBody ApplicantsModel a)
 {
  return appserv.addNewApplicant(a);
 }
 
 @GetMapping("/app/search/skill/{skill}")
 public List<ApplicantsModel> getBySkill(@PathVariable String skill)
 {
  return appserv.getApplicants(skill);
 }
 
 @GetMapping("/removeapp/{id}")
 public ApplicantsModel deleteApp(@PathVariable int id)
 {
  return appserv.removeApplicant(id);
 }
 
}
