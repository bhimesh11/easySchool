package com.school.easySchool.Repository;

import com.school.easySchool.domain.holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HolidaysRepository extends JpaRepository<holiday,String>
{
    //Migrating from Spring Jdbc to Spring Jpa
//    @Autowired
//    private final JdbcTemplate jdbcTemplate;
//
//    public HolidaysRepository(JdbcTemplate jdbcTemplate)
//    {
//        this.jdbcTemplate = jdbcTemplate;
//    }

//    public List<holiday> findAllHolidays()
//    {
//       String sql = "SELECT * FROM eazyschool.holidays";
//       var rowMapper = BeanPropertyRowMapper.newInstance(holiday.class);
//       return jdbcTemplate.query(sql,rowMapper);
//    }
    //Migrating from Spring Jdbc to Spring Jpa
}
