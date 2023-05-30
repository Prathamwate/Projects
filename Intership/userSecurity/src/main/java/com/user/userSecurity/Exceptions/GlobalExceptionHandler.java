package com.user.userSecurity.Exceptions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> methodArgumentNotValidException(MethodArgumentNotValidException ex) {

		BindingResult result = ex.getBindingResult();
		List<ObjectError> errors = result.getAllErrors();
		Map<String, String> erroersMap = new HashMap<>();
		for (ObjectError e1 : errors) {
			String message1 = e1.getDefaultMessage();
			String field = ((FieldError) e1).getField();
			erroersMap.put(field, message1);
		}
		return erroersMap;
	}

	@ExceptionHandler(NotValid.class)
	public String notValid(NotValid ex) {
		System.out.println(ex.getMessage());
		return ex.getMessage();
	}

}
