package com.contact;

import java.util.ArrayList;

@Service
public class ContactManagement {
	
	Map<Long, Contact> database = HashMap<>();
	
	public Contact findById(Long id) {
		return database.get(id);
	}
	
	public List<Contact> getAll(){
		return new ArrayList<>(database.value());
	}
	
	public void create(Contact account) {
		database.put(Contact.getId(), contact);
	}
	
	public void update(Contact updatedContact) {
		Contact contact ToBeUpdated = database.get(updatedContact.getId());
		contactToBeUpdated.setName(updatedContact.getName());
		contactToBeupdated.setEmail(updatedContact.getEmail());
	}
	
	public void delete(Long id) {
		database.remove(id);
	}
	
}
