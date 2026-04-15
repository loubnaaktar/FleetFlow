ALTER TABLE livraison ADD COLUMN vehicule_id BIGINT;
ALTER TABLE livraison ADD CONSTRAINT fk_vehicule FOREIGN KEY (vehicule_id) REFERENCES vehicule(id);