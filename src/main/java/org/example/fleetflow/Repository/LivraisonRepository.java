package org.example.fleetflow.Repository;

import org.example.fleetflow.model.Client;
import org.example.fleetflow.model.Livraison;
import org.example.fleetflow.model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LivraisonRepository extends JpaRepository<Livraison, Long> {
    List<Livraison> findByStatut(String statut);

    List<Livraison> findByClientId(Long id);

    @Query("select l from Livraison l where l.dateLivraison BETWEEN :date1 AND :date2")
    List<Livraison> findLivraisonBetweenTwoDate(LocalDateTime date1, LocalDateTime date2);

    @Query("select l from Livraison l where l.adresseDestination = :ville")
    List<Livraison> findLivraisonByVille(String ville);


    // fonctions challenge

    List<Livraison> findAllByAdresseDepart(String ville);

    List<Livraison> findAllByAdresseDestinationLike(String mot);

    List<Livraison> findAllByOrderByDateLivraisonDesc();

    List<Livraison> findByClientIdAndStatut(Long clientId, Livraison.StatutLivraison statut);

    @Query(value = "SELECT l FROM Livraison JOIN Chauffeur c ON l.chauffuer_id = c.id WHERE c.disponible = true ", nativeQuery = true)
    List<Livraison> findLivraisonsAvecChauffeurDisponibleNative();

    @Query(value = "SELECT l FROM Livraison l JOIN Vehicule v ON l.vehicule_id = v.id WHERE v.dispo = true", nativeQuery = true)
    List<Livraison> findLivraisonsAvecVehiculeDispoNative();

    @Query(value = "SELECT l FROM Livraison l JOIN Client c ON l.client_id = c.id WHER c.ville = ?1",nativeQuery = true)
    List<Livraison> findLivraisonsByVille(String ville);

    @Query(value = "SELECT l FROM Livraison l WHERE l.dateLivraison < CURRENT_DATE", nativeQuery = true)
    List<Livraison> findLivraisonsFuture();

    @Query(value ="SELECT COUNT(*) FROM Livraison l WHERE l.Statut = ?1 ",nativeQuery = true)
    Long countByStatut(Livraison.StatutLivraison statut);

    @Query(value = "SELECT COUNT(*) FROM Livraison l WHERE l.adresseDestination = ?1", nativeQuery = true)
    Long countByVille(String ville);

    //15
    @Query(value = "        SELECT l.*\n" +
            "        FROM livraisons l\n" +
            "        INNER JOIN (\n" +
            "            SELECT client_id, MAX(date_livraison) AS last_date\n" +
            "            FROM livraisons\n" +
            "            GROUP BY client_id\n" +
            "        ) sub ON l.client_id = sub.client_id AND l.date_livraison = sub.last_date\n" +
            "        ", nativeQuery = true)
    Livraison findLastLivraison();
}
