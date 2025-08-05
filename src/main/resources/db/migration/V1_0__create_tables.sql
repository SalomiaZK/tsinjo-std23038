CREATE TABLE donors (
                        id VARCHAR(50) PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        email VARCHAR(255) NOT NULL
);

CREATE TABLE beneficiaries (
                               id VARCHAR(50) PRIMARY KEY,
                               name VARCHAR(255) NOT NULL,
                               email VARCHAR(255) NOT NULL
);

CREATE TABLE payments (
                          id VARCHAR(50) PRIMARY KEY,
                          date DATE NOT NULL,
                          amount BIGINT NOT NULL,
                          payment_type VARCHAR(50) NOT NULL
);

CREATE TABLE donations (
                           id VARCHAR(50) PRIMARY KEY,
                           donor_id VARCHAR(50) NOT NULL,
                           payment_id VARCHAR(50) NOT NULL,
                           CONSTRAINT fk_donor FOREIGN KEY (donor_id) REFERENCES donors(id),
                           CONSTRAINT fk_payment_donation FOREIGN KEY (payment_id) REFERENCES payments(id)
);

CREATE TABLE helps (
                       id VARCHAR(50) PRIMARY KEY,
                       beneficiary_id VARCHAR(50) NOT NULL,
                       payment_id VARCHAR(50) NOT NULL,
                       accident_description TEXT,
                       CONSTRAINT fk_beneficiary FOREIGN KEY (beneficiary_id) REFERENCES beneficiaries(id),
                       CONSTRAINT fk_payment_help FOREIGN KEY (payment_id) REFERENCES payments(id)
);
