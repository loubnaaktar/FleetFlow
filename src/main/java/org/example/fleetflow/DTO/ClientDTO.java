package org.example.fleetflow.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

    public class ClientDTO {
    @Positive
    private Long id;
    @NotBlank(message ="nom est obligatoire" )
        private String nom;
    @Email(message = "email invalide")
    @NotBlank(message = "email obligatoire")
        private String email;
    @NotBlank(message ="ville est obligatoire" )
        private String ville;
    @NotBlank(message ="telephone est obligatoire" )
        private String  telephone;
        private Long nombre;
    }

