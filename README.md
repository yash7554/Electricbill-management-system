# Parking Management System

A Spring Boot REST API for managing real-time parking slot assignments.

Setup Instructions
1. Database: Create a MySQL database named `parking_db`.
2. Table: Run the following SQL:
USE parking_db;
CREATE TABLE parking_slot (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    slot_number VARCHAR(10),
    is_occupied BOOLEAN,
    vehicle_number VARCHAR(20),
    entry_time DATETIME
);
INSERT INTO parking_slot (slot_number, is_occupied) VALUES ('A1', false);
INSERT INTO parking_slot (slot_number, is_occupied) VALUES ('A2', false);
INSERT INTO parking_slot (slot_number, is_occupied) VALUES ('A3', false);
INSERT INTO parking_slot (slot_number, is_occupied) VALUES ('A4', false);
INSERT INTO parking_slot (slot_number, is_occupied) VALUES ('A5', false);

select*from parking_slot(To Check the parking)


3.To Park a Vehicle(using POSTMAN)
URL: /api/parking/park

Method: POST

Params: vehicleNumber (String)

Example: http://localhost:8080/api/parking/park?vehicleNumber=MH12AB1234

4.To Unpark a Vehicle
URL: /api/parking/unpark/{vehicleNumber}

Method: POST

Example: http://localhost:8080/api/parking/unpark/MH12AB1234

5.Output:
you can see database updated in mysqlworkbench by using query:
select*from parking_slot

