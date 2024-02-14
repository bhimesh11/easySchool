package com.school.easySchool.Repository;

import com.school.easySchool.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface rolesRepository extends JpaRepository<Roles,Integer> {
   Roles getByRoleName(String roleName);
}
