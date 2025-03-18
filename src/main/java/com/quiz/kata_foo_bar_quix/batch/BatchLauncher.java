package com.quiz.kata_foo_bar_quix.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Component;

@Component
public class BatchLauncher {

    private final JobLauncher jobLauncher;
    private final Job fooBarQuixJob;

    public BatchLauncher(JobLauncher jobLauncher, Job fooBarQuixJob) {
        this.jobLauncher = jobLauncher;
        this.fooBarQuixJob = fooBarQuixJob;
    }

    public void runBatch() {
        try {
            JobExecution execution = jobLauncher.run(fooBarQuixJob, new org.springframework.batch.core.JobParameters());
            System.out.println("Batch terminé avec statut : " + execution.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}