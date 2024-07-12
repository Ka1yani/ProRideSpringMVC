/*Create database ProRideMVC;*/
Use ProRideMVC; 

CREATE TABLE User (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    phone_number VARCHAR(20),
    password VARCHAR(255),
    registration_date DATETIME
);

CREATE TABLE Driver (
    driver_id INT PRIMARY KEY,
    license_number VARCHAR(255),
    background_check_status BOOLEAN,
    FOREIGN KEY (driver_id) REFERENCES User(user_id)
);

CREATE TABLE Vehicle (
    vehicle_id INT AUTO_INCREMENT PRIMARY KEY,
    driver_id INT,
    make VARCHAR(255),
    model VARCHAR(255),
    year INT,
    license_plate VARCHAR(255),
    color VARCHAR(255),
    capacity INT,
    FOREIGN KEY (driver_id) REFERENCES Driver(driver_id)
);

CREATE TABLE Address (
    address_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    driver_id INT NULL,
    address_line_1 VARCHAR(255),
    address_line_2 VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    postal_code VARCHAR(20),
    country VARCHAR(255),
    location_type VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (driver_id) REFERENCES Driver(driver_id)
);

CREATE TABLE Vehicle_Type (
    vehicle_type_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    capacity INT,
    image_url VARCHAR(255)
);

CREATE TABLE Promotion (
    promotion_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    discount_type ENUM('PERCENTAGE', 'FIXED_AMOUNT'),
    start_date DATETIME,
    end_date DATETIME,
    minimum_fare DECIMAL(10,2)
);

CREATE TABLE Notification (
    notification_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    driver_id INT NULL,
    title VARCHAR(255),
    message TEXT,
    type VARCHAR(255),
    sent_date DATETIME,
    read_status BOOLEAN,
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (driver_id) REFERENCES Driver(driver_id)
);

CREATE TABLE Document (
    document_id INT AUTO_INCREMENT PRIMARY KEY,
    driver_id INT,
    document_type VARCHAR(255),
    document_url VARCHAR(255),
    verification_status ENUM('PENDING', 'VERIFIED', 'REJECTED'),
    FOREIGN KEY (driver_id) REFERENCES Driver(driver_id)
);

CREATE TABLE Support_Ticket (
    support_ticket_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    driver_id INT NULL,
    subject VARCHAR(255),
    description TEXT,
    created_date DATETIME,
    status ENUM('OPEN', 'CLOSED'),
    assigned_admin_id INT NULL,
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (driver_id) REFERENCES Driver(driver_id)
);

CREATE TABLE Ride (
    ride_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    driver_id INT,
    vehicle_id INT,
    pickup_location_id INT,
    drop_off_location_id INT,
    pickup_time DATETIME,
    drop_off_time DATETIME,
    status ENUM('REQUESTED', 'ACCEPTED', 'ONGOING', 'COMPLETED', 'CANCELLED'),
    fare DECIMAL(10,2),
    payment_method VARCHAR(255),
    rating INT CHECK (rating BETWEEN 0 AND 5),
    created_date DATETIME,
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (driver_id) REFERENCES Driver(driver_id),
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(vehicle_id),
    FOREIGN KEY (pickup_location_id) REFERENCES Address(address_id),
    FOREIGN KEY (drop_off_location_id) REFERENCES Address(address_id)
);

CREATE TABLE Payment (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    ride_id INT,
    user_id INT,
    amount DECIMAL(10,2),
    payment_method VARCHAR(255),
    status ENUM('PENDING', 'SUCCESSFUL', 'FAILED'),
    timestamp DATETIME,
    FOREIGN KEY (ride_id) REFERENCES Ride(ride_id),
    FOREIGN KEY (user_id) REFERENCES User(user_id)
);

CREATE TABLE Rating (
    rating_id INT AUTO_INCREMENT PRIMARY KEY,
    ride_id INT,
    user_id INT,
    driver_id INT,
    rating_value INT CHECK (rating_value BETWEEN 0 AND 5),
    FOREIGN KEY (ride_id) REFERENCES Ride(ride_id),
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (driver_id) REFERENCES Driver(driver_id)
);

CREATE TABLE Package (
    package_id INT AUTO_INCREMENT PRIMARY KEY,
    description TEXT,
    weight DECIMAL(10,2),
    dimensions VARCHAR(255)
);

CREATE TABLE Group_Ride (
    group_ride_id INT AUTO_INCREMENT PRIMARY KEY,
    main_ride_id INT,
    additional_rider_id INT,
    FOREIGN KEY (main_ride_id) REFERENCES Ride(ride_id),
    FOREIGN KEY (additional_rider_id) REFERENCES User(user_id)
);

CREATE TABLE Intercity_Ride (
    intercity_ride_id INT AUTO_INCREMENT PRIMARY KEY,
    ride_id INT,
    origin_city VARCHAR(255),
    destination_city VARCHAR(255),
    FOREIGN KEY (ride_id) REFERENCES Ride(ride_id)
);

CREATE TABLE User_History (
    user_history_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    ride_id INT,
    type ENUM('RIDE', 'RENTAL', 'PACKAGE_DELIVERY'),
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (ride_id) REFERENCES Ride(ride_id)
);

CREATE TABLE Driver_History (
    driver_history_id INT AUTO_INCREMENT PRIMARY KEY,
    driver_id INT,
    ride_id INT,
    type ENUM('RIDE', 'RENTAL', 'PACKAGE_DELIVERY'),
    FOREIGN KEY (driver_id) REFERENCES Driver(driver_id),
    FOREIGN KEY (ride_id) REFERENCES Ride(ride_id)
);

CREATE TABLE Wallet (
    wallet_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    balance DECIMAL(10,2),
    FOREIGN KEY (user_id) REFERENCES User(user_id)
);

CREATE TABLE Advanced_Ride_Booking (
    advanced_booking_id INT AUTO_INCREMENT PRIMARY KEY,
    ride_id INT,
    scheduled_date DATETIME,
    route_preferences TEXT,
    FOREIGN KEY (ride_id) REFERENCES Ride(ride_id)
);

CREATE TABLE Car_Rental (
    car_rental_id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_id INT,
    rental_start_date DATETIME,
    rental_end_date DATETIME,
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(vehicle_id)
);

CREATE TABLE Invoice (
    invoice_id INT AUTO_INCREMENT PRIMARY KEY,
    ride_id INT,
    user_id INT,
    driver_id INT,
    fare DECIMAL(10,2),
    payment_method VARCHAR(255),
    issued_date DATETIME,
    FOREIGN KEY (ride_id) REFERENCES Ride(ride_id),
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (driver_id) REFERENCES Driver(driver_id)
);

CREATE TABLE Lost_Item (
    lost_item_id INT AUTO_INCREMENT PRIMARY KEY,
    ride_id INT,
    description TEXT,
    location TEXT,
    FOREIGN KEY (ride_id) REFERENCES Ride(ride_id)
);

CREATE TABLE Issue_Report (
    issue_report_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    driver_id INT NULL,
    ride_id INT,
    subject VARCHAR(255),
    description TEXT,
    created_date DATETIME,
    status ENUM('PENDING', 'INVESTIGATING', 'RESOLVED'),
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (driver_id) REFERENCES Driver(driver_id),
    FOREIGN KEY (ride_id) REFERENCES Ride(ride_id)
);

CREATE TABLE Trip (
    trip_id INT PRIMARY KEY,
    package_id INT NULL,
    FOREIGN KEY (trip_id) REFERENCES Ride(ride_id),
    FOREIGN KEY (package_id) REFERENCES Package(package_id)
);
