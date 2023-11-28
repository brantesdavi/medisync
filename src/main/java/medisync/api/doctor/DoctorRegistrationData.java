package medisync.api.doctor;

import medisync.api.address.AddressData;

public record DoctorRegistrationData(String name, String email, String npi, Specialty specialty, AddressData address) {

}
