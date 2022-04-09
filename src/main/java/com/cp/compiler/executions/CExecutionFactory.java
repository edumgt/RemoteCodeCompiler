package com.cp.compiler.executions;

import org.springframework.web.multipart.MultipartFile;

/**
 * The type C execution factory.
 */
public class CExecutionFactory implements AbstractExecutionFactory {
    
    @Override
    public Execution createExecution(MultipartFile sourceCode,
                                     MultipartFile inputFile,
                                     MultipartFile expectedOutputFile,
                                     int timeLimit,
                                     int memoryLimit) {
        return new CPPExecution(sourceCode, inputFile, expectedOutputFile, timeLimit, memoryLimit);
    }
}
