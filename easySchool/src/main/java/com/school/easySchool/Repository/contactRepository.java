package com.school.easySchool.Repository;


import com.school.easySchool.Mapper.ContactMapper;
import com.school.easySchool.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface contactRepository extends JpaRepository<Contact,Integer> {

    List<Contact> findByStatus(String status);

//    private final JdbcTemplate jdbcTemplate;
//
//
//    public contactRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public int saveContactMsg(Contact contact) {
//        String sql = "INSERT INTO eazyschool.contact_msg (NAME,MOBILE_NUM,EMAIL,SUBJECT,MESSAGE,STATUS," +
//                "CREATED_AT,CREATED_BY) VALUES (?,?,?,?,?,?,?,?)";
//
//        return jdbcTemplate.update(sql, contact.getName(),
//                contact.getMobileNum(),
//                contact.getEmail(),
//                contact.getSubject(),
//                contact.getMessage(),
//                contact.getStatus(),
//                contact.getCreateAt(),
//                contact.getCreatedBy());
//
//    }
//
//    public List<Contact> findMsgsWithStatus(String status) {
//        String sql = "select * from eazyschool.contact_msg where status = ?";
//        return jdbcTemplate.query(sql,new PreparedStatementSetter() {
//            public void setValues(PreparedStatement preparedStatement) throws SQLException {
//                preparedStatement.setString(1, status);
//            }
//        },new ContactMapper());
//    }
//
//    public int updateMsgStatus(int id, String updatedby, String status) {
//        String sql =  "update eazyschool.contact_msg set status = ?, updated_by = ?,updated_at =? where contact_id = ?";
//
//        return jdbcTemplate.update(sql, new PreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement ps) throws SQLException {
//                ps.setString(1,status);
//                ps.setString(2,updatedby);
//                ps.setString(3, String.valueOf(Timestamp.valueOf(LocalDateTime.now())));
//                ps.setInt(4,id);
//
//            }
//        });
//
//
//    }
}
