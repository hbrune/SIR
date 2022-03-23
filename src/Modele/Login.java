/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

import static Securite.Encryption.hashPassword;
import Securite.Salt;

/**
 *
 * @author Brune
 */
public class Login {
    // A voir si on laisse le password ici
    String idLogin;
    String password;
    String lastName;
    String firstName;
    int function;

    /**
    *Créer une nouveau utilisateur
    *@param idLogin : identifiant du professionnel de santé
    *@param password : mot de passe du professionnel de santé 
    *@param lastName : nom du professionnel de santé
    *@param firstName : prénom du professionnel de santé
    *@param function : métier du professionnel de santé
    */
    public Login(String idLogin, String password, String lastName, String firstName, int function) {
        this.idLogin = idLogin;
        String key = hashPassword(password, Salt.salt).get();
        this.password = key;
        this.lastName = lastName;
        this.firstName = firstName;
        this.function = function;
    }

    /**
    *Vérifier si l'utilisateur est bien défini
    *@return : true si l'utilisateur est valide et false si l'utilisateur n'est pas valide
    */
    public boolean isUserValid(){
        return (idLogin != null && password != null && lastName != null && firstName != null && function != 0);
    }
    
    /**
    *Récupérer l'id d'un professionnel de santé
    *@return : id du professionnel de santé
    */
    public String getIdLogin() {
        return idLogin;
    }

    /**
    *Modifier l'id d'un professionnel de santé
    *@param idLogin : id du professionnel de santé que l'on veut mettre
    */
    public void setIdLogin(String idLogin) {
        this.idLogin = idLogin;
    }

    /**
    *Récupérer le mot de passe d'un professionnel de santé
    *@return : mot de passe du professionnel de santé
    */
    public String getPassword() {
        return password;
    }

    /**
    *Récupérer le nom d'un professionnel de santé
    *@return : nom du professionnel de santé
    */
    public String getLastName() {
        return lastName;
    }

    /**
    *Modifier le nom d'un professionnel de santé
    *@param lastName : nom du professionnel de santé que l'on veut mettre
    */
    public void setName(String lastName) {
        this.lastName = lastName;
    }

    /**
    *Récupérer le prénom d'un professionnel de santé
    *@return : prénom du professionnel de santé
    */
    public String getFirstName() {
        return firstName;
    }
    
    /**
    *Modifier le prénom d'un professionnel de santé
    *@param firstName : prénom du professionnel de santé que l'on veut mettre
    */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
    *Récupérer le métier d'un professionnel de santé
    *@return : métier du professionnel de santé
    */
    public int getFunction() {
        return function;
    }

    /**
    *Modifier le métier d'un professionnel de santé
    *@param function : métier du professionnel de santé que l'on veut mettre
    */
    public void setFunction(int function) {
        this.function = function;
    }
    
    
    
}
