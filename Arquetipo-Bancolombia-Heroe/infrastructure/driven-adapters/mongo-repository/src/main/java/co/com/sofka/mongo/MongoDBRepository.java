package co.com.sofka.mongo;

import co.com.sofka.model.game.Tablero;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import reactor.core.publisher.Flux;

public interface MongoDBRepository extends ReactiveMongoRepository<PetDocument, String>, ReactiveQueryByExampleExecutor<PetDocument> {
  //  @Query(value = "{ 'userId' : ?0, 'questions.questionID' : ?1 }", fields = "{ 'questions.questionID' : 1 }")
    //List<PracticeQuestion> findByUserIdAndQuestionsQuestionID(int userId, int questionID);
    Flux<Tablero> findByName(String name);
}
