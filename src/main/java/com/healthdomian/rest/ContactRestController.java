package com.healthdomian.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthdomian.constants.AppConstants;
import com.healthdomian.entity.Contact;
import com.healthdomian.prop.AppProperties;
import com.healthdomian.service.ContactServiceImpl;

@RestController
@CrossOrigin
public class ContactRestController {

	@Autowired
	private ContactServiceImpl contactService;

	@Autowired
	private AppProperties appProperties;

	@PostMapping("/contact/save")
	public String saveContactRest(@RequestBody Contact contact) {

		boolean saveContactFlag = contactService.saveContact(contact);

		Map<String, String> map = appProperties.getMessages();

		if (saveContactFlag) {
			return map.get(AppConstants.CONTACT_SAVE_SUCC);
		} else {
			return map.get(AppConstants.CONTACT_SAVE_FAIL);
		}
	}

	@GetMapping("/contact/get")
	public List<Contact> getAllContactDetailsRest() {
		List<Contact> allContacts = contactService.getAllContacts();

		return allContacts;
	}

	@GetMapping("/edit/{contactId}")
	public Contact editContactDetailsRest(@PathVariable("contactId") Integer contactId) {

		Contact contact = contactService.getContactById(contactId);
		return contact;
	}

	@DeleteMapping("/delete/{contactId}")
	public String deleteContactDetails(@PathVariable("contactId") Integer contactId) {

		boolean deleteFlag = contactService.deleteContactById(contactId);
		
		Map<String , String> map=appProperties.getMessages();

		if (deleteFlag) {
			return map.get(AppConstants.CONTACT_DEL_SUCC);
		} else {
			return  map.get(AppConstants.CONTACT_DEL_FAIL);
		}
	}
}
