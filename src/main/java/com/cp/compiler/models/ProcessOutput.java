package com.cp.compiler.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Process output.
 */
@Builder
@Getter
public class ProcessOutput {
    
    private String stdOut;
    
    @Setter
    private String stdErr;

    private int executionDuration;
    
    private int status;
}
