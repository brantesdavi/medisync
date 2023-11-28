package medisync.api.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import medisync.api.address.Address;

@Table(name = "doctors")
@Entity(name = "doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String npi;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    public Doctor(DoctorRegistrationData data) {
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.npi = data.npi();
        this.specialty = data.specialty();
        this.address = new Address(data.address());
    }
}
