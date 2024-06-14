package mr.pharmaproche.pharmaproche.registration;

import mr.pharmaproche.pharmaproche.model.Role;
import mr.pharmaproche.pharmaproche.model.enums.UserRole;

import java.util.Set;

public record RegistrationRequest(String firstName, String lastName, String email, String phone, String password, Role role) {
}
