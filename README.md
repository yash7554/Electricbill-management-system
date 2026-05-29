#Electric Bill Management System

A Spring Boot REST API to manage customer meter readings and automated bill generation.

Setup Instructions
1. Database: Create a MySQL database named `eb_management`.
2. Table Setup: Run the following SQL in your workbench:

CREATE DATABASE eb_management;
USE eb_management;

CREATE TABLE customer_bill (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    meter_number VARCHAR(20) UNIQUE NOT NULL,
    customer_name VARCHAR(100),
    units_consumed INT DEFAULT 0,
    total_bill DOUBLE DEFAULT 0.0
);

-- Initial customers
INSERT INTO customer_bill (meter_number, customer_name) 
VALUES ('MET101', 'RAJ BADKHAL'), 
        ('MET102', 'Rahul Sharma');
        ('MET103', 'Ananya Iyer'),
        ('MET104', 'Vikram Malhotra'),
        ('MET105', 'Siddharth Joshi'),
        ('MET106', 'Priya Deshmukh'),
        ('MET107', 'Arjun Verma'),
        ('MET108', 'Sneha Kulkarni'),
        ('MET109', 'Ishaan Reddy'),
        ('MET110', 'Tanvi Sawant'),
        ('MET111', 'Rohan Mehra'),
        ('MET112', 'Kavita Nair');

TO DISPLAY INFO TYPE:
select*from customer_bill;

3.TO GENERATE/UPDATE BILL TYPE:(IN POSTMAN) 
http://localhost:8080/api/bill/update?meterNumber=MET101&units=150
(IT IS FOR METER NO 101 AND ITS UNIT IS 150,WE HAVE TO PROVIDE THIS DATA TO POSTMAN VIA LINK
FOR EXAMPLE:IF YOU WANT TO GENERATE BILL AMOUNT OF CUSTOMER WHOSE METER NO. IS 107 AND UNIT 200
SO THE LINK WILL BE LOOK LIKE:http://localhost:8080/api/bill/update?meterNumber=MET107&units=200)

4.LOGIC:
Rate: ₹7.0 per unit.

Formula: Total Bill = Units Consumed × 7

5.FINALLY:
AMOUNT WILL DISPLAYED ANS STORED IN DATABASE 
WE CAN SEE BY USING FOLLOWING QUERY:
select*from customer_bill;
