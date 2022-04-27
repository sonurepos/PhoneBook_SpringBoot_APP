package com.healthdomian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthdomian.entity.Contact;

@Repository
public interface ContactRepository  extends  JpaRepository<Contact, Integer>{

}
