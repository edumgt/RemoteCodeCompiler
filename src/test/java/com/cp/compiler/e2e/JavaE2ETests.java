package com.cp.compiler.e2e;

import com.cp.compiler.controller.CompilerController;
import com.cp.compiler.model.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;

@SpringBootTest
public class JavaE2ETests {
	
	@Autowired
	private CompilerController compilerController;
	private static final String ACCEPTED_VERDICT = "Accepted";
	private static final String TIME_LIMIT_EXCEEDED_VERDICT = "Time Limit Exceeded";
	private static final String COMPILATION_ERROR_VERDICT = "Compilation Error";
	private static final String WRONG_ANSWER_VERDICT = "Wrong Answer";
	private static final String OUT_OF_MEMORY_VERDICT = "Out Of Memory";
	private static final String RUNTIME_ERROR_VERDICT = "Runtime Error";
	
	@DisplayName("Java Accepted Verdict")
	@Test
	void shouldReturnAcceptedVerdict() throws Exception {
		// Given
		File sourceCodeFile = new File("src/test/resources/sources/java/Test1.java");
		MultipartFile sourceCode = new MockMultipartFile("Test1.java", "Test1.java", (String)null ,new FileInputStream(sourceCodeFile));
		
		File expectedOutputFile = new File("src/test/resources/outputs/Test1.txt");
		MultipartFile expectedOutput = new MockMultipartFile("Test1.txt", "Test1.txt", (String)null, new FileInputStream(expectedOutputFile));
		
		// When
		ResponseEntity<Object> responseEntity = compilerController.compileJava(expectedOutput, sourceCode, null, 10, 500);
	
		// Then
		Assertions.assertEquals(ACCEPTED_VERDICT, ((Response)responseEntity.getBody()).getStatus());
	}
	
	@DisplayName("Java Time Limit Exceeded")
	@Test
	void shouldReturnTimeLimitExceededVerdict() throws Exception {
		// Given
		File sourceCodeFile = new File("src/test/resources/sources/java/Test2.java");
		MultipartFile sourceCode = new MockMultipartFile("Test2.java", "Test2.java", (String)null ,new FileInputStream(sourceCodeFile));
		
		File expectedOutputFile = new File("src/test/resources/outputs/Test1.txt");
		MultipartFile expectedOutput = new MockMultipartFile("Test1.txt", "Test1.txt", (String)null, new FileInputStream(expectedOutputFile));
		
		// When
		ResponseEntity<Object> responseEntity = compilerController.compileJava(expectedOutput, sourceCode, null, 10, 500);
		
		// Then
		Assertions.assertEquals(TIME_LIMIT_EXCEEDED_VERDICT, ((Response)responseEntity.getBody()).getStatus());
	}
	
	@DisplayName("Java Compilation Error")
	@Test
	void shouldReturnCompilationErrorVerdict() throws Exception {
		// Given
		File sourceCodeFile = new File("src/test/resources/sources/java/Test3.java");
		MultipartFile sourceCode = new MockMultipartFile("Test3.java", "Test3.java", (String)null ,new FileInputStream(sourceCodeFile));
		
		File expectedOutputFile = new File("src/test/resources/outputs/Test1.txt");
		MultipartFile expectedOutput = new MockMultipartFile("Test1.txt", "Test1.txt", (String)null, new FileInputStream(expectedOutputFile));
		
		// When
		ResponseEntity<Object> responseEntity = compilerController.compileJava(expectedOutput, sourceCode, null, 10, 500);
		
		// Then
		Assertions.assertEquals(COMPILATION_ERROR_VERDICT, ((Response)responseEntity.getBody()).getStatus());
	}
	
	@DisplayName("Java Wrong Answer")
	@Test
	void shouldReturnWrongAnswerVerdict() throws Exception {
		// Given
		File sourceCodeFile = new File("src/test/resources/sources/java/Test4.java");
		MultipartFile sourceCode = new MockMultipartFile("Test4.java", "Test4.java", (String)null ,new FileInputStream(sourceCodeFile));
		
		File expectedOutputFile = new File("src/test/resources/outputs/Test1.txt");
		MultipartFile expectedOutput = new MockMultipartFile("Test1.txt", "Test1.txt", (String)null, new FileInputStream(expectedOutputFile));
		
		// When
		ResponseEntity<Object> responseEntity = compilerController.compileJava(expectedOutput, sourceCode, null, 10, 500);
		
		// Then
		Assertions.assertEquals(WRONG_ANSWER_VERDICT, ((Response)responseEntity.getBody()).getStatus());
	}
	
	@DisplayName("Java Out Of Memory Error")
	@Test
	void shouldReturnOutOfMemoryVerdict() throws Exception {
		// Given
		File sourceCodeFile = new File("src/test/resources/sources/java/Test5.java");
		MultipartFile sourceCode = new MockMultipartFile("Test5.java", "Test5.java", (String)null ,new FileInputStream(sourceCodeFile));
		
		File expectedOutputFile = new File("src/test/resources/outputs/Test1.txt");
		MultipartFile expectedOutput = new MockMultipartFile("Test1.txt", "Test1.txt", (String)null, new FileInputStream(expectedOutputFile));
		
		// When
		ResponseEntity<Object> responseEntity = compilerController.compileJava(expectedOutput, sourceCode, null, 10, 1);
		
		// Then
		Assertions.assertEquals(OUT_OF_MEMORY_VERDICT, ((Response)responseEntity.getBody()).getStatus());
	}
	
	@DisplayName("Java Runtime Error")
	@Test
	void shouldReturnRuntimeErrorVerdict() throws Exception {
		// Given
		File sourceCodeFile = new File("src/test/resources/sources/java/Test6.java");
		MultipartFile sourceCode = new MockMultipartFile("Test6.java", "Test6.java", (String)null ,new FileInputStream(sourceCodeFile));
		
		File expectedOutputFile = new File("src/test/resources/outputs/Test1.txt");
		MultipartFile expectedOutput = new MockMultipartFile("Test1.txt", "Test1.txt", (String)null, new FileInputStream(expectedOutputFile));
		
		// When
		ResponseEntity<Object> responseEntity = compilerController.compileJava(expectedOutput, sourceCode, null, 10, 500);
		
		// Then
		Assertions.assertEquals(RUNTIME_ERROR_VERDICT, ((Response)responseEntity.getBody()).getStatus());
	}
	

}