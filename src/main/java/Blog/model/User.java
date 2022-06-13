package Blog.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="user")
//@SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq", initialValue = 10, allocationSize = 1)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    @NotNull
    private String username;
    @Column(name = "password", nullable = false)
    @NotNull
    private String password;

    public User(){}

    public User(Long id, String username, String password) {
        this.id = id;
       this.username = username;
       this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
} 