package demo.pv10springdatarepositories;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(
       name= "CAFEUSERS"
)
public class CafeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId=-1;

    private String username;

    public CafeUser(){

    }

    public CafeUser(long userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CafeUser cafeUser = (CafeUser) o;
        return userId == cafeUser.userId && Objects.equals(username, cafeUser.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username);
    }

    @Override
    public String toString() {
        return "CafeUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}
