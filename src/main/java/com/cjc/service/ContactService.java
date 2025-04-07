package com.cjc.service;

import java.util.List;

import com.cjc.entity.Contact;

public interface ContactService {

	String addContact(Contact contact);

	List<Contact> getallcontact(boolean activesw);

	Contact getSingleUser(Integer contactid);

	Contact updateContact(Contact contact, Integer contactid);

	String deleteContact(Integer contactid);

}
