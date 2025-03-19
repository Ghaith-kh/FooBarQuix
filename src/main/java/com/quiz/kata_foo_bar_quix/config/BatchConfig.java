package com.quiz.kata_foo_bar_quix.config;

import com.quiz.kata_foo_bar_quix.batch.FooBarQuixProcessor;
import com.quiz.kata_foo_bar_quix.service.IFooBarQuixService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.mapping.PassThroughLineMapper;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import java.io.File;

@Configuration
@EnableBatchProcessing
public class BatchConfig extends DefaultBatchConfiguration {


    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";
    private final IFooBarQuixService fooBarQuixService;

    public BatchConfig(IFooBarQuixService fooBarQuixService) {
        this.fooBarQuixService = fooBarQuixService;
    }

    @Bean
    public FlatFileItemReader<String> reader() {
        FlatFileItemReader<String> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource(new File(INPUT_FILE_PATH)));
        reader.setLineMapper(new PassThroughLineMapper());
        return reader;
    }

    @Bean
    public FlatFileItemWriter<String> writer() {
        FlatFileItemWriter<String> writer = new FlatFileItemWriter<>();
        writer.setResource(new FileSystemResource(new File(OUTPUT_FILE_PATH)));
<<<<<<< HEAD
        writer.setAppendAllowed(true);
=======
>>>>>>> c80873572db01defafc85be73a3c2cf4d8afb726
        writer.setLineAggregator((LineAggregator<String>) item -> item);
        return writer;
    }

    @Bean
    public Job fooBarQuixJob(JobRepository jobRepository, Step step) {
        return new JobBuilder("fooBarQuixJob", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    public Step step(JobRepository jobRepository,
                     FooBarQuixProcessor processor,
                     PlatformTransactionManager transactionManager) {
        return new StepBuilder("step", jobRepository)
                .<String, String>chunk(5, transactionManager)
                .reader(reader())
                .processor(processor)
                .writer(writer())
                .build();
    }

    @Bean
    public FooBarQuixProcessor processor() {
        return new FooBarQuixProcessor(fooBarQuixService);
    }

}