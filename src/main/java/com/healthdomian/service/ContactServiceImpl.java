package com.healthdomian.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.healthdomian.entity.Contact;
import com.healthdomian.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;

	@Override
	public boolean saveContact(Contact contact) {

		contact.setActiveSw("Y");
		Contact cont = contactRepo.save(contact);

		if (cont.getContactId() != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Contact> getAllContacts() {

		Contact contact = new Contact();
		contact.setActiveSw("Y");
		Example<Contact> filterActiveSwitch = Example.of(contact);
		return contactRepo.findAll(filterActiveSwitch);
	}

	@Override
	public Contact getContactById(Integer contactId) {

		Optional<Contact> con = contactRepo.findById(contactId);

		if (con.isPresent()) {
			return con.get();
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {

		Optional<Contact> con = contactRepo.findById(contactId);

		if (con.isPresent()) {
			Contact contact = con.get();
			contact.setActiveSw("N");
			contactRepo.save(contact);

			return true;

		} else {
			return false;
		}
	}

}
