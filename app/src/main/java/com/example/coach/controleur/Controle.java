package com.example.coach.controleur;

import com.example.coach.modele.Profil;

/**
 * Classe singleton Controle : répond aux attentes de l'activity
 */
public final class Controle {

    // Propriétés
    private static Controle instance = null;
    private static Profil profil;

    // Constructeur
    private Controle() {
        super();
    }

    /**
     * Création d'une instance unique de la classe
     * @return l'instance unique
     */
    public final static Controle getInstance() {
        if(Controle.instance == null){
            Controle.instance = new Controle();
        }
        return Controle.instance;

    }

    /**
     * Création du profil par rapport aux information saisies
     * @param poids
     * @param taille
     * @param age
     * @param sexe 1 = homme, 0 = femme
     */
    public void creerProfil(Integer poids, Integer taille , Integer age, Integer sexe ){
        profil = new Profil(poids, taille, age, sexe);
    }

    /**
     * Getter sur le résultat du calcul de l'IMG pour le profil
     * @return IMG du profil
     */
    public float getImg(){
        if(profil != null){
            return profil.getImg();
        }else {
            return 0;
        }
    }

    /**
     * getter sur le message correspondant à l'img du profil
     * @return message du profil
     */
    public String getMessage() {
        if(profil != null) {
            return profil.getMessage();
        }else{
            return "";
        }
    }
}