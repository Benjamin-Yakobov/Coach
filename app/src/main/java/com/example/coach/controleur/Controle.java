package com.example.coach.controleur;

import android.content.Context;

import com.example.coach.modele.Profil;
import com.example.coach.outils.Serializer;

/**
 * Classe singleton Controle : répond aux attentes de l'activity
 */
public final class Controle {

    // Propriétés
    private static Controle instance = null;
    private static Profil profil;
    private static String nomFic = "saveprofil";

    // Constructeur
    private Controle(Context context) {
        super();
        recupSerialize(context);
    }

    /**
     * Création d'une instance unique de la classe
     * @return l'instance unique
     */
    public final static Controle getInstance(Context context) {
        if(Controle.instance == null){
            Controle.instance = new Controle(context);
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
    public void creerProfil(Integer poids, Integer taille , Integer age, Integer sexe, Context context){
        profil = new Profil(poids, taille, age, sexe);
        Serializer.serialize(nomFic, profil, context);
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

    /**
     * Retourne le poids si le profil existe
     * @return
     */
    public Integer getPoids(){
        if(profil == null){
            return null;
        }else{
            return profil.getPoids();
        }
    }

    /**
     * Retourne la taille si le profil existe
     * @return
     */
    public Integer getTaille(){
        if(profil == null){
            return null;
        }else{
            return profil.getTaille();
        }
    }

    /**
     * Retourne l'âge si le profil existe
     * @return
     */
    public Integer getAge(){
        if(profil == null){
            return null;
        }else{
            return profil.getAge();
        }
    }

    /**
     * Retourne le sexe si le profil existe
     * @return
     */
    public Integer getSexe(){
        if(profil == null){
            return null;
        }else{
            return profil.getSexe();
        }
    }

    private static void  recupSerialize(Context context){
        profil = (Profil) Serializer.deSerialize(nomFic, context);
    }
}