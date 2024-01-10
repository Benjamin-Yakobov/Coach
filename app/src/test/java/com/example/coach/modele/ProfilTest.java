package com.example.coach.modele;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Date;

public class ProfilTest {

    // Creéation d'un profil
    private Profil profil = new Profil(new Date(), 165, 35, 0, 67);
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