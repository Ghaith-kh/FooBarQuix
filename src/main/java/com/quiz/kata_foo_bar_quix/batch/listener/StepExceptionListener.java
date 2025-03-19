package com.quiz.kata_foo_bar_quix.batch.listener;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class StepExceptionListener implements StepExecutionListener {
    private static final Logger logger = LoggerFactory.getLogger(StepExceptionListener.class);


    @Override
    public void beforeStep(StepExecution stepExecution) {
        // Initialization before step execution if needed
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        if (!stepExecution.getFailureExceptions().isEmpty() ) {
            stepExecution.getFailureExceptions().forEach(ex ->
                    logger.error("Error during batch execution: " + ex.getMessage())
            );
            return ExitStatus.FAILED;
        }
        return ExitStatus.COMPLETED;
    }
}
