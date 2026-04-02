package org.example.fleetflow.controller;

import lombok.RequiredArgsConstructor;
import org.example.fleetflow.service.LivraisonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/livraison")
@RequiredArgsConstructor
public class LivraisonController {
    private final LivraisonService livraisonService;
}
