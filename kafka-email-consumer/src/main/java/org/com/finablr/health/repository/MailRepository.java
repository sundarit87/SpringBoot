package org.com.finablr.health.repository;

import org.com.finablr.health.entity.Mail;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MailRepository extends JpaRepository<Mail, Long> {

}