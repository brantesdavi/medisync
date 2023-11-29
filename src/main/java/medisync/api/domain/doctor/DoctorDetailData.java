package medisync.api.domain.doctor;

import medisync.api.domain.address.Address;

public record DoctorDetailData(Long id, String name, String email, String phone, String npi, Specialty specialty, Address address) {

    public DoctorDetailData(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getPhone(), doctor.getNpi(), doctor.getSpecialty(), doctor.getAddress());
    }
}
