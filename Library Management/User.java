public class User {
    String name,email,password;
    User(String name,String email,String password){
        this.name=name;
        this.email=email;
        this.password=password;
    }
    boolean login(String e,String p){
        return email.equals(e) && password.equals(p);
    }
    
}
