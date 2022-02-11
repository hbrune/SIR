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
    String lastName;
    String firstName;
    int function;

    public Login(String idLogin, String password, String lastName, String firstName, int function) {
        this.idLogin = idLogin;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.function = function;
    }

    
    public boolean isUserValid(){
        return (idLogin != null && password != null && lastName != null && firstName != null && function != 0);
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

    public String getLastName() {
        return lastName;
    }

    public void setName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getFunction() {
        return function;
    }

    public void setFunction(int function) {
        this.function = function;
    }
    
    
    
}
