CREATE TABLE IF NOT EXISTS messages2 (
    id                     VARCHAR(60)  DEFAULT RANDOM_UUID() PRIMARY KEY,
    text                   VARCHAR      NOT NULL
    );