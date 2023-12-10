CREATE TABLE Member (
    MemberID SERIAL PRIMARY KEY,
    Name VARCHAR(100),
    Email VARCHAR(100),
    PhoneNumber VARCHAR(20),
    Address VARCHAR(255),
    MembershipType VARCHAR(50),
    FitnessGoals VARCHAR(255),
    HealthMetrics VARCHAR(255),
    Password VARCHAR(100) 
);

CREATE TABLE Trainer (
    TrainerID SERIAL PRIMARY KEY,
    Name VARCHAR(100),
    Email VARCHAR(100),
    PhoneNumber VARCHAR(20),
    Specialization VARCHAR(100),
    Password VARCHAR(100)
);

CREATE TABLE Admin (
    StaffID SERIAL PRIMARY KEY,
    Name VARCHAR(100),
    Email VARCHAR(100),
    PhoneNumber VARCHAR(20),
    Position VARCHAR(100),
	Password VARCHAR(100)
);

CREATE TABLE LoyaltyProgram (
    LoyaltyID SERIAL PRIMARY KEY,
    MemberID INT REFERENCES Member(MemberID),
    PointsEarned INT,
    PointsRedeemed INT,
    RedeemableServices VARCHAR(255)
);

CREATE TABLE PersonalTrainingSession (
    SessionID SERIAL PRIMARY KEY,
    TrainerID INT REFERENCES Trainer(TrainerID),
    MemberID INT REFERENCES Member(MemberID),
    Date DATE,
    Time TIME,
    Notes VARCHAR(255)
);

CREATE TABLE GroupFitnessClass (
    ClassID SERIAL PRIMARY KEY,
    ClassName VARCHAR(100),
    Date DATE,
    Time TIME,
    TrainerID INT REFERENCES Trainer(TrainerID)
);

CREATE TABLE Event (
    EventID SERIAL PRIMARY KEY,
    EventName VARCHAR(100),
    Date DATE,
    Time TIME
);

CREATE TABLE Billing (
    BillingID SERIAL PRIMARY KEY,
    MemberID INT REFERENCES Member(MemberID),
    Amount DECIMAL(10, 2),
    Date DATE,
    PaymentStatus VARCHAR(50)
);

CREATE TABLE Equipment (
    EquipmentID SERIAL PRIMARY KEY,
    EquipmentName VARCHAR(100),
    MaintenanceStatus VARCHAR(20)
);

CREATE TABLE Room (
    RoomID SERIAL PRIMARY KEY,
    RoomName VARCHAR(100),
    Availability VARCHAR(20)
);