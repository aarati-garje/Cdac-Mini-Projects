package com.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.ApiResponse;
import com.app.dtos.JobPostDto;
import com.app.entities.JobPost;
import com.app.service.JobPostService;



@RestController
@RequestMapping("/jobs")
public class JobPostController {

	@Autowired
	private JobPostService jobPostService;
		
	//GET all job posts
	@GetMapping
	public ResponseEntity<?> getAllJobPosts(){
	   return ResponseEntity.ok(jobPostService.getAllJobPosts());	
	}
	
	//POST new job post
	@PostMapping
	public ResponseEntity<?> addNewJobPost(@RequestBody JobPostDto jobPost){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(jobPostService.addNewJobPost(jobPost));
	}
	   
	
//	//Get by specific id
	@GetMapping("/{id}")
	public ResponseEntity<?> getJobPostById(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(jobPostService.getJobPostById(id));
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateJobPost(@PathVariable Long id, @RequestBody JobPost job){
		return ResponseEntity.status(HttpStatus.OK).body(jobPostService.updateJobPost(id, job));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteJobPost(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(jobPostService.deleteJobPost(id));
	}
	

}
