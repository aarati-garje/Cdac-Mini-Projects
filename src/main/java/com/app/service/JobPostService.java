package com.app.service;

import java.util.List;

import com.app.dtos.ApiResponse;
import com.app.dtos.JobPostDto;
import com.app.entities.JobPost;


public interface JobPostService {

	List<JobPostDto> getAllJobPosts();
	JobPostDto addNewJobPost(JobPostDto newPostDto);
	JobPostDto getJobPostById(Long id);
	ApiResponse updateJobPost(Long id, JobPost job);
	ApiResponse deleteJobPost(Long id);
}
