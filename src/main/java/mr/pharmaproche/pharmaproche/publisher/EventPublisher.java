package mr.pharmaproche.pharmaproche.publisher;

import mr.pharmaproche.pharmaproche.collection.dto.UserRequestDTO;

public interface EventPublisher<T> {
    void publish(T t);
}
