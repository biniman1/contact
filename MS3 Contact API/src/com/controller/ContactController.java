package com.controller;

import java.util.List;

@RestController
public class ContactController {
	
	@Autowired
	ContactService service;
	
	@RequestMapping(value="/contact/{id}",method=RequestMethod.GET)
	public ResponseEntity<Contact>getContactById(@PathVariable Long id){
		return new ResponseEntity<Contact>(service.findById(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/contact/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<Contact>>getContacts(){
		return new ResponseEntity<List<Contact>>(service.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/contact/",method=RequestMethod.POST)
	public ResponseEntity<String>createContact(@RequestBody Contact contact){
		return new ResponseEntity<String>("Contact Created Successfully", HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/contact/{id}",method=RequestMethod.PUT)
	public ResponseEntity<String> updateContact (@PathVariable Long id, @RequestBody Contact updatedContact){		
		if (service.findById(id) == null) {
			return new ResponseEntity<String>("Contact not found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<String>("Contact updated successfully", HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/contact/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteContact (@PathVariable Long id) {
		if (service.findById(id) == null) {
		return new ResponseEntity<String>("Contact not found", HttpStatus.NOT_FOUND);
	} else {
		return new ResponseEntity<String>("Contact deleted successfully", HttpStatus.OK);
	}
	
	
	
	
}
