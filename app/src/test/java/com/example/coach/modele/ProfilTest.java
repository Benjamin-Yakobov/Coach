package com.example.coach.modele;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProfilTest {

    // Creéation d'un profil
    private Profil profil = new Profil(67, 165, 35, 0);
    // Résultat de l'IMG correspondant au profil
    private float img = (float) 32.2;
    private String message = "Trop élevé";

    @Test
    public void getImg() {
        assertEquals(img, profil.getImg(), (float) 0.1);
    }

    @Test
    public void getMessage() {
        assertEquals(message, profil.getMessage());
    }
}