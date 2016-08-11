package net.viralpatel.spring3.form;

import java.util.List;

public class ContactForm {
	
	private List<Contact> contacts;

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "ContactForm{" + "contacts=" + contacts.size() + '}';
	}
}
