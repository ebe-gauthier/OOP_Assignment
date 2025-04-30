package exo3;

import java.time.LocalDate;

public class Person {
    private String personId;
    private String fullName;
    private LocalDate dob;
    private String email;
    private String phone;

    public Person(String personId, String fullName, LocalDate dob, String email, String phone) {
        if (!email.contains("@") || phone.length() < 10)
            throw new IllegalArgumentException("Invalid email or phone.");
        this.personId = personId;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
    }

    public String getFullName() { return fullName; }

    public String toString() {
        return fullName + " (" + email + ")";
    }
}

