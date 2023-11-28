package medisync.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String district;
    private String zip;
    private String city;
    private String state;
    private String complement;
    private String number;

    public Address(AddressData address) {
        this.street = address.street();
        this.district = address.district();
        this.zip = address.zip();
        this.city = address.city();
        this.state = address.state();
        this.complement = address.complement();
        this.number = address.number();
    }

    public void updateInfo(AddressData data) {
        if(data.street() != null){
            this.street = data.street();
        }
        if(data.district() != null){
            this.district = data.district();
        }
        if(data.zip() != null){
            this.zip = data.zip();
        }
        if(data.city() != null){
            this.city = data.city();
        }
        if(data.state() != null){
            this.state = data.state();
        }
        if(data.complement() != null){
            this.complement = data.complement();
        }
        if(data.number() != null){
            this.number = data.number();
        }
    }
}
