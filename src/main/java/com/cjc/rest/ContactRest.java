package com.cjc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.entity.Contact;
import com.cjc.service.ContactService;

@RestController
public class ContactRest {

	@Autowired
	private ContactService contactservice;

	@PostMapping(value = "/contacts")
	public String savestudent(@RequestBody Contact contact) {

		String msg = contactservice.addContact(contact);

		return msg;

	}

	@GetMapping(value = "/contacts/{contactid}")
	public Contact getSingleUser(@PathVariable Integer contactid) {
		Contact con = contactservice.getSingleUser(contactid);
		return con;
	}

	@GetMapping(value = "/contacts1/{activesw}")
	public List<Contact> getAllContact(@PathVariable boolean activesw) {
		List<Contact> allContact = contactservice.getallcontact(activesw);
		return allContact;
	}

	@PatchMapping(value = "contacts/{contactid}")
	public Contact updateContact(@RequestBody Contact contact, @PathVariable Integer contactid) {
		Contact UpdatedContact = contactservice.updateContact(contact, contactid);
		return UpdatedContact;
	}

	@DeleteMapping("contacts/{contactid}")
	public String deleteContact(@PathVariable Integer contactid) {
		String msg = contactservice.deleteContact(contactid);

		return msg;
	}

}
