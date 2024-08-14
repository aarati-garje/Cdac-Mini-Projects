package com.app.service;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dtos.ApiResponse;
import com.app.dtos.JobPostDto;
import com.app.entities.JobPost;
import com.app.exceptions.ResourceNotFoundException;
import com.app.repository.JobPostRepository;

@Service
@Transactional
public class JobPostServiceImpl implements JobPostService {

	@Autowired
	JobPostRepository jobPostRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<JobPostDto> getAllJobPosts(){
		return jobPostRepo.findAll()  //entity to dto
				.stream()
				.map(entity->mapper.map(entity, JobPostDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public JobPostDto addNewJobPost(JobPostDto newPostDto) {
		//dto to entity
		
		JobPost entity = mapper.map(newPostDto, JobPost.class);
		return mapper.map(jobPostRepo.save(entity), JobPostDto.class);
				
	}

	public JobPostDto getJobPostById(Long id) {
		JobPost entity = jobPostRepo.findById(id)
		    .orElseThrow(()->new ResourceNotFoundException("Invalid Category Id"));
		return mapper.map(entity,JobPostDto.class);
	}

	@Override
	public ApiResponse updateJobPost(Long id, JobPost job) {
		String msg = "Updation failed";
		if(jobPostRepo.existsById(id)) {
			JobPost existingJobPost = jobPostRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Invalid ID!!!"));
			existingJobPost.setCompanyName(job.getCompanyName());
			existingJobPost.setDescription(job.getDescription());
			existingJobPost.setLocation(job.getLocation());
			existingJobPost.setRequirments(job.getRequirments());
			existingJobPost.setSalary(job.getSalary());
			existingJobPost.setTitle(job.getTitle());
			jobPostRepo.save(existingJobPost);
			msg="Updated successfully";
		}else
			throw new ResourceNotFoundException("Invalid ID");
		return new ApiResponse(msg);
	}

	@Override
	public ApiResponse deleteJobPost(Long id) {
		String msg = "Deletion failed";
		if(jobPostRepo.existsById(id)) {
			jobPostRepo.deleteById(id);
			msg = "Deleted successfully";
		}else
			throw new ResourceNotFoundException("Invalid ID!!!");
		return new ApiResponse(msg);
	}

}
