package com.school.easySchool.Repository;

import com.school.easySchool.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface addressRepository extends JpaRepository<Address,String> {


}
