package com.cjc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.entity.Contact;
import com.cjc.repository.ContactRepository;
import com.cjc.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	ContactRepository contactrepo;

	@Override
	public String addContact(Contact contact) {
		if (!contactrepo.existsById(contact.getContactId())) {
			contactrepo.save(contact);
			
		} else if (contactrepo.existsById(contact.getContactId())) {
			Contact dbcontact = getSingleUser(contact.getContactId());
			System.out.println(dbcontact);

			if (contact.getFirstname() != null) {
				dbcontact.setFirstname(contact.getFirstname());
			}
			if (contact.getLastname() != null) {
				dbcontact.setLastname(contact.getLastname());
			}
			if (contact.getMobNo() != null) {
				dbcontact.setMobNo(contact.getMobNo());
			}

			Contact savedcontact = contactrepo.save(dbcontact);
			System.out.println("update successfully.....");

			return "Update Contact Successfully...";

		}

		return "Contact Save Successfully....!";
	}

	@Override
	public Contact getSingleUser(Integer contactid) {
		if (contactrepo.existsById(contactid)) {
			Contact contact = contactrepo.findById(contactid).get();
			return contact;
		}
		return null;
	}

	@Override
	public List<Contact> getallcontact(boolean activesw) {
	
		if (activesw) {
			List<Contact> list = contactrepo.findAllByActivesw(activesw);
			return list;
		}
			List<Contact> list = contactrepo.findAllByActivesw(activesw);
			return list;

		}

	@Override
	public Contact updateContact(Contact contact, Integer contactid) {

		if (contactrepo.existsById(contactid)) {

			Contact dbcontact = getSingleUser(contactid);
			System.out.println(dbcontact);

			if (contact.getFirstname() != null) {
				dbcontact.setFirstname(contact.getFirstname());
			}
			if (contact.getLastname() != null) {
				dbcontact.setLastname(contact.getLastname());
			}
			if (contact.getMobNo() != null) {
				dbcontact.setMobNo(contact.getMobNo());
			}

			Contact savedcontact = contactrepo.save(dbcontact);
			System.out.println(savedcontact);
			return savedcontact;
		}

		return null;
	}
	
	@Override
	public String deleteContact(Integer contactid) {
		Contact contact = contactrepo.findById(contactid).get();
		contact.setActivesw(false);
		contactrepo.save(contact);
		return "Contact Deleted Successfully....";
	}

}
