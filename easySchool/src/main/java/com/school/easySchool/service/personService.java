package com.school.easySchool.service;

import com.school.easySchool.Repository.PersonRepository;
import com.school.easySchool.constants.EazySchoolConstants;
import com.school.easySchool.domain.Person;
import com.school.easySchool.domain.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.school.easySchool.Repository.rolesRepository;

@Service
public class personService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private rolesRepository rolesRepository;

    public boolean createNewPerson(Person person) {
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);

        person.setRoles(role);

        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }

}