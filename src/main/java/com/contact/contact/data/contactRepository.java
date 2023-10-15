package com.contact.contact.data;

import com.contact.contact.Contact;

import org.springframework.data.repository.CrudRepository;


public interface contactRepository
        extends CrudRepository<Contact, String> {
}
