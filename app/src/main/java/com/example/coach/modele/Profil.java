package com.example.coach.modele;

import java.io.Serializable;

/**
 * Classe métier Profil
 * Contient les informations du profil
 */
public class Profil implements Serializable {

    // Constantes
    private static final Integer minFemme = 15;
    private static final Integer maxFemme = 30;
    private static final Integer minHomme = 10;
    private static final Integer maxHomme = 25;

    // Propriétés
    private Integer poids;
    private Integer taille;
    private Integer age;
    private Integer sexe;
    private float img = 0;
    private String message = "";

    /**
     * Constructeur : valorise les propriétés poids, taille, age, sex lors de la création d'un objet
     * @param poids
     * @param taille
     * @param age
     * @param sexe 1 = homme, 0 = femme
     */
    public Profil(Integer poids, Integer taille, Integer age, Integer sexe) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
    }

    // Les getters
    public Integer getPoids() {
        return poids;
    }

    public Integer getTaille() {
        return taille;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSexe() {
        return sexe;
    }

    /**
     * Retourne l'IMG
     * @return img
     */
    public float getImg() {
        if(img == 0){
            float tailleCm = ((float)taille)/100;
            img = (float)((1.2 * poids/(tailleCm*tailleCm)) + (0.23 * age) - (10.83 * sexe) - 5.4);
        }
        return img;
    }

    /**
     * Retourne le message correspondant à l'img
     * @return message "normal", "trop faible", "trop élevé"
     */
    public String getMessage() {
        if(message.equals("")){
            message = "normal";
            Integer min = minFemme, max = maxFemme;
            if(sexe == 1){
                min = minHomme;
                max = maxHomme;
            }
            img = getImg();
            if(img<min){
                message = "trop faible";
            }else{
                if(img>max){
                    message = "trop élevé";
                }
            }
        }
        return message;
    }
}
