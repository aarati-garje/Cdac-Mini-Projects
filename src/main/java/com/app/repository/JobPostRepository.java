package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.JobPost;

public interface JobPostRepository extends JpaRepository<JobPost, Long> {

}
