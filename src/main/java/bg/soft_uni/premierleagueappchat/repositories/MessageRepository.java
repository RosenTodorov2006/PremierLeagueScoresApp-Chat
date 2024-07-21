package bg.soft_uni.premierleagueappchat.repositories;

import bg.soft_uni.premierleagueappchat.models.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
