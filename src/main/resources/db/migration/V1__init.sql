CREATE TABLE vehicule(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    matricule VARCHAR(50) NOT NULL UNIQUE,
    type VARCHAR(50) NOT NULL,
    capacite INT NOT NULL,
    statut VARCHAR(50) NOT NULL
);
CREATE TABLE livraison(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date_livraison DATETIME,
    adresse_depart VARCHAR(255) NOT NULL,
    adresse_destination VARCHAR(255) NOT NULL,
    statut VARCHAR(50),

    chauffeur_id BIGINT,
    client_id BIGINT
);
