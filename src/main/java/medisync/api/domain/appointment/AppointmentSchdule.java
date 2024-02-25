package medisync.api.domain.appointment;

import jakarta.validation.ValidationException;
import medisync.api.domain.appointment.validators.AppointmentScheduleValidator;
import medisync.api.domain.doctor.Doctor;
import medisync.api.domain.doctor.DoctorRepository;
import medisync.api.domain.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AppointmentSchdule {

    @Autowired
    public AppointmentRepository appointmentRepository;
    @Autowired
    public DoctorRepository doctorRepository;
    @Autowired
    public PatientRepository patientRepository;

    @Autowired
    private List<AppointmentScheduleValidator> validatorList;
    public void schedule(AppointmentScheduleData data) {
        if (!patientRepository.existsById(data.idPatient())) {
            throw new ValidationException("Id do paciente informado não existe!");
        }

        if (data.idDoctor() != null && !doctorRepository.existsById(data.idDoctor())) {
            throw new ValidationException("Id do médico informado não existe!");
        }

        validatorList.forEach(v -> v.validate(data));

        var patient = patientRepository.getReferenceById(data.idPatient());
        var doctor = chooseDoctor(data);
        var appointment = new Appointment(null, doctor, patient, data.date());
        appointmentRepository.save(appointment);
    }

    private Doctor chooseDoctor(AppointmentScheduleData data) {
        if (data.idDoctor() != null) {
            return doctorRepository.getReferenceById(data.idDoctor());
        }

        if (data.specialty() == null) {
            throw new ValidationException("Especialidade é obrigatória quando médico não for escolhido!");
        }

        return doctorRepository.chooseRandomDoctor(data.specialty(), data.date());
    }
}
