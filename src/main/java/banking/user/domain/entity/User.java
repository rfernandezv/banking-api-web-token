package banking.user.domain.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private long id;
    private String username;
    private String password;
    private String email;
    private List<Role> roles;

    public User() {
        roles = new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN));
    }    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
    
}
