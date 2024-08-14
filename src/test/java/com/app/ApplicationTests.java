package com.app;





import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.entities.JobPost;
import com.app.repository.JobPostRepository;



@SpringBootTest
class ApplicationTests {

	@Autowired
	JobPostRepository jobPostRepo;
	
	
	@Test
	void contextLoads() {
		
	}
	
	@Test
	void testSaveJobPost() throws Exception {
		JobPost newPost=new JobPost("Project Enginner","Cdac","pune","uvw",4,400000.40);
	    JobPost jobPost = jobPostRepo.save(newPost);
	    assertEquals(3, jobPost.getId());
	}

}

//Job title, company name, location, description, requirements, salary, and posting date.