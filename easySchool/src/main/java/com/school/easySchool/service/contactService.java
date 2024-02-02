package com.school.easySchool.service;

import com.school.easySchool.Repository.contactRepository;
import com.school.easySchool.constants.EazySchoolConstants;
import com.school.easySchool.domain.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@Service
@Slf4j
public class contactService {

   // private static Logger log = LoggerFactory.getLogger(contactService.class);

    @Autowired
    private contactRepository contactRepository;



    public boolean saveMessageDetails(Contact contact)
    {
        boolean isSaved = false;
        log.info(contact.toString());
        contact.setStatus(EazySchoolConstants.open);
        contact.setCreatedBy(EazySchoolConstants.Anonymous);
        contact.setCreateAt(LocalDate.now());
        Random random = new Random();
        int randomNumber = random.nextInt();
        contact.setContactId(randomNumber);
        contact.setUpdateBy(contact.getCreatedBy());
     contact.setUpdateAt(LocalDate.now().atStartOfDay());

        int result = contactRepository.saveContactMsg(contact);
        if (result > 0) {
            isSaved = true;
        }
        return isSaved;
    }
}
