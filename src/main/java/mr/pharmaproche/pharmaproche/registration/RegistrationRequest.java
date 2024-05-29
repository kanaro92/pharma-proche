package mr.pharmaproche.pharmaproche.registration;

import mr.pharmaproche.pharmaproche.collection.enums.UserRole;

public record RegistrationRequest(String firstName, String lastName, String email, String phone, String password, UserRole role) {
}
