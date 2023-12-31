package medisync.api.domain.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import medisync.api.domain.address.Address;

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

    private Boolean active;

    public Doctor(DoctorRegistrationData data) {
        this.active = true;
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.npi = data.npi();
        this.specialty = data.specialty();
        this.address = new Address(data.address());
    }

    public void updateInfo(DoctorUpdateData data) {
        if(data.name() != null){
            this.name = data.name();
        }
        if(data.phone() != null){
            this.phone = data.phone();
        }
        if(data.address() != null){
            this.address.updateInfo(data.address());
        }
    }

    public void exclude() {
        this.active = false;
    }
}
