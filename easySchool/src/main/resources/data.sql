INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
 VALUES (' Jan 1 ','New Year''s Day','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
 VALUES (' Oct 31 ','Halloween','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
 VALUES (' Nov 24 ','Thanksgiving Day','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
 VALUES (' Dec 25 ','Christmas','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
 VALUES (' Jan 17 ','Martin Luther King Jr. Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
 VALUES (' July 4 ','Independence Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
 VALUES (' Sep 5 ','Labor Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
  VALUES (' Nov 11 ','Veterans Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `contact_msg` (`name`, `mobile_num`, `email`, `subject`, `message`, `status`, `created_at`, `created_by`)
VALUES
    ('John Doe', '1234567890', 'john.doe@example.com', 'Inquiry', 'This is a test message.', 'Pending', CURRENT_TIMESTAMP, 'admin'),
    ('Jane Smith', '9876543210', 'jane.smith@example.com', 'Feedback', 'Another test message.', 'Completed', CURRENT_TIMESTAMP, 'user'),
    ('Alice Johnson', '5551234567', 'alice.johnson@example.com', 'Support', 'Help needed with a product.', 'Open', CURRENT_TIMESTAMP, 'admin'),
    ('Bob Williams', '4449876543', 'bob.williams@example.com', 'Question', 'Query regarding your services.', 'Pending', CURRENT_TIMESTAMP, 'user'),
    ('Charlie Brown', '9998887777', 'charlie.brown@example.com', 'Complaint', 'Unsatisfactory experience, need assistance.', 'Pending', CURRENT_TIMESTAMP, 'admin');
