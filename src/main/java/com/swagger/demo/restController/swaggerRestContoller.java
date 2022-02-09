package com.swagger.demo.restController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.demo.pojo.Contact;

@RestController
@RequestMapping("/api")
public class swaggerRestContoller {
	
	ConcurrentHashMap<String,Contact> hash=new ConcurrentHashMap<String,Contact>();
	
	@GetMapping("/{id}")
	public Contact getContactById(@PathVariable String id)
	{
		Contact temp=hash.get(id);
		return temp;
	}
	
	@PostMapping("/")
	public String postContactInfo(@RequestBody Contact contact)
	{
		if(contact==null) return null;
		hash.put(contact.getId(), contact);
		return "Done";
	}
	
	@GetMapping("/")
	public List<Contact> getListOfAllContact()
	{
	  ArrayList<Contact> result=new ArrayList<Contact>();
	  for(String s:hash.keySet())
	  {
		  result.add(hash.get(s));
	  }
	  return result;
	}

}
