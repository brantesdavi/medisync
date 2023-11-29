package medisync.api.domain.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import medisync.api.domain.address.Address;
import medisync.api.domain.doctor.DoctorRegistrationData;

@Table(name = "patients")
@Entity(name = "patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String ssn;
    @Embedded
    private Address address;
    private Boolean active;

    public Patient(PatientRegistrationData data){
        this.active=true;
        this.name = data.name();
        this.phone = data.phone();
        this.email = data.email();
        this.ssn = data.ssn();
        this.address = new Address(data.address());
    }

    public void updateInfo(PatientUpdateData data){
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

    public void exclude(){
        this.active = false;
    }

}
