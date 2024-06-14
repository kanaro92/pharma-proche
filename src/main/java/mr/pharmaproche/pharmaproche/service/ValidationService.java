package mr.pharmaproche.pharmaproche.service;


import lombok.AllArgsConstructor;
import mr.pharmaproche.pharmaproche.model.AppUser;
import mr.pharmaproche.pharmaproche.model.Validation;
import mr.pharmaproche.pharmaproche.repository.ValidationRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Random;

import static java.time.temporal.ChronoUnit.MINUTES;

@AllArgsConstructor
@Service
public class ValidationService {

    private ValidationRepository validationRepository;
    private NotificationService notificationService;

    public void save(AppUser user) {
        Validation validation = new Validation();
        validation.setUser(user);
        Instant creationDate = Instant.now();
        validation.setCreationDate(creationDate);
        Instant expirationDate = creationDate.plus(10, MINUTES);
        validation.setExpirationDate(expirationDate);
        Random random = new Random();
        int randomInteger = random.nextInt(999999);
        String code = String.format("%06d", randomInteger);

        validation.setCode(code);
        this.validationRepository.save(validation);
        this.notificationService.sendMail(validation);
    }

    public Validation findByCode(String code) {
        return this.validationRepository.findByCode(code).orElseThrow(() -> new RuntimeException("Votre code est invalide"));
    }
}