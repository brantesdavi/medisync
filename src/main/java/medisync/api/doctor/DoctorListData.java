package medisync.api.doctor;

public record DoctorListData(Long id, String name, String email, String npi, Specialty specialty) {

    public DoctorListData(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getNpi(), doctor.getSpecialty());
    }
}
