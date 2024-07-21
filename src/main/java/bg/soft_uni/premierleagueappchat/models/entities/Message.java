package bg.soft_uni.premierleagueappchat.models.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "messages")
@Entity
public class Message{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String message;
    @Column
    private long userId;
    @Column(nullable = false)
    private LocalDateTime created;

    public Message(String message, LocalDateTime created, long userId) {
        this.message = message;
        this.created=created;
        this.userId=userId;
    }

    public Message() {

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
