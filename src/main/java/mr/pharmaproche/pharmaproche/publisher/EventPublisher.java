package mr.pharmaproche.pharmaproche.publisher;

public interface EventPublisher<T> {
    void publish(T t);
}
