/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele;

/**
 *
 * @author Brune
 */
public class Login {
    // A voir si on laisse le password ici
    String idLogin;
    String password;
    String name;
    String surname;
    int function;

    public Login(String idLogin, String password, String name, String surname, int function) {
        this.idLogin = idLogin;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.function = function;
    }

    
    public boolean isUserValid(){
        return (idLogin != null && password != null && name != null && surname != null && function != 0);
    }
            
    public String getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(String idLogin) {
        this.idLogin = idLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getFunction() {
        return function;
    }

    public void setFunction(int function) {
        this.function = function;
    }
    
    
    
}
