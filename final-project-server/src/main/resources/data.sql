DROP TABLE IF EXISTS Accounts;
DROP TABLE IF EXISTS Cards;

CREATE TABLE Accounts (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  balance DECIMAL DEFAULT 0.0
);

CREATE TABLE Cards (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  pin VARCHAR NOT NULL,
  number VARCHAR NOT NULL,
  expire_date DATE NOT NULL,
  account_id INT NOT NULL,
    foreign key (account_id) references Accounts(id)
);

INSERT INTO Accounts (balance) VALUES
  (450.2),
  (600000),
  (771.23);

INSERT INTO Cards (number,pin,expire_date,account_id) VALUES
  ('59263303996','1234','2030-11-11',1),
  ('65623023251','0000','2030-11-11',2),
  ('58965251551','1663','2020-11-11',1);