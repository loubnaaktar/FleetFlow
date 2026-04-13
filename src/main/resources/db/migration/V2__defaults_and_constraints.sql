ALTER TABLE chauffeur
    MODIFY disponible BOOLEAN DEFAULT TRUE;

ALTER TABLE livraison
    MODIFY statut VARCHAR(50) DEFAULT 'EN_ATTENTE';


ALTER TABLE vehicule
    ADD CONSTRAINT chk_capacite CHECK (capacite > 0);


ALTER TABLE livraison
    ADD CONSTRAINT fk_chauffeur FOREIGN KEY (chauffeur_id) REFERENCES chauffeur(id),
    ADD CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES client(id);