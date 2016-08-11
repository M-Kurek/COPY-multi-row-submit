package net.viralpatel.spring3.controller;

import java.util.ArrayList;
import java.util.List;

import net.viralpatel.spring3.form.Contact;
import net.viralpatel.spring3.form.ContactForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

	private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);
	
	private static List<Contact> contacts = new ArrayList<Contact>();

	static {
		contacts.add(new Contact("Maniek", "Kowal", "mk@poczta.pl",  "1111111111"));
		contacts.add(new Contact("Stasiek", "Nowak", "sn@poczta.pl", "2222222222"));
		contacts.add(new Contact("Zuza", "Wójcik", "zw@poczta.pl",   "3333333333"));
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ModelAndView get() {
		
		ContactForm contactForm = new ContactForm();
		contactForm.setContacts(contacts);
		
		return new ModelAndView("add_contact" , "contactForm", contactForm);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("contactForm") ContactForm contactForm) {


		LOG.info(contactForm.toString());
		List<Contact> contacts = contactForm.getContacts();
		
		if(null != contacts && contacts.size() > 0) {
			ContactController.contacts = contacts;
			for (Contact contact : contacts) {
                LOG.info("{}\t{}", contact.getFirstname(), contact.getLastname());
			}
		}
		
		return new ModelAndView("show_contact", "contactForm", contactForm);
	}
}
