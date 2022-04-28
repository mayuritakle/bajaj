package com.bajajFinserv.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(boolean message, List<Integer> numbers, List<String> alphabets,HttpStatus status) {
        Map<String, Object> map = new HashMap<String, Object>();
        
        List<String> number = numbers.stream().map(Object::toString).collect(Collectors.toList());
        
            map.put("is_success", message);
            map.put("user_id", "john_doe_17091999");
            map.put("email", "john@xyz.com");
            map.put("roll_number", "ABCD123");
            map.put("numbers", number);
            map.put("alphabets", alphabets);
            

            return new ResponseEntity<Object>(map, status);
    }

	public static ResponseEntity<Object> generateResponse(String string) {
		System.out.println(string);
		return null;
	}
}