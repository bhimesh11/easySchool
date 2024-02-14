package com.school.easySchool.service;

import com.school.easySchool.Repository.contactRepository;
import com.school.easySchool.constants.EazySchoolConstants;
import com.school.easySchool.domain.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Slf4j
public class contactService {

    // private static Logger log = LoggerFactory.getLogger(contactService.class);

    @Autowired
    private contactRepository contactRepository;


    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = false;
        log.info(contact.toString());
        contact.setStatus(EazySchoolConstants.open);
        //will update with help of jpa auditing
//        contact.setCreatedBy(EazySchoolConstants.open);
//        contact.setCreatedAt(LocalDateTime.now());
//        Random random = new Random();
//        int randomNumber = random.nextInt();
//        contact.setContactId(randomNumber);
//        contact.setUpdateBy(contact.getCreatedBy());
//        contact.setUpdateAt(LocalDate.now().atStartOfDay());

   //     int result = contactRepository.saveContactMsg(contact);
        Contact savedContact = contactRepository.save(contact);

        if (savedContact !=null && savedContact.getContactId()>0) {
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findMsgwithOpenStatus() {
    List<Contact> contactMsg = contactRepository.findByStatus(EazySchoolConstants.open);
//
//        contactRepository.findMsgsWithStatus(EazySchoolConstants.open);
        return contactMsg;
    }

    public boolean updateMsgStatus(int contactId) {
        boolean isUpdate = false;
        Optional<Contact> result = contactRepository.findById(contactId);
        result.ifPresent( contact ->
                {
                    contact.setStatus(EazySchoolConstants.close);
//                    contact.setUpdateBy(updateBy);
//                    contact.setUpdateAt(LocalDateTime.now());
                });
        Contact updateContact = contactRepository.save(result.get());
        if(null!=updateContact && updateContact.getUpdateBy()!=null)
        {
            isUpdate = true;
        }
        return isUpdate;

//        int result = contactRepository.updateMsgStatus(contactId, EazySchoolConstants.close, updateBy);
//        if(result>0)
//        {
//            isUpdate = true;
//        }
//        return isUpdate;
    }


}
