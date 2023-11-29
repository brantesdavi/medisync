package medisync.api.domain.patient;

import medisync.api.domain.address.Address;

public record PatientDetailData(Long id, String name, String phone, String nss, String email, Address address) {

    public PatientDetailData(Patient patient){
        this(patient.getId(), patient.getName(), patient.getSsn(), patient.getPhone(), patient.getEmail(), patient.getAddress());
    }

}
