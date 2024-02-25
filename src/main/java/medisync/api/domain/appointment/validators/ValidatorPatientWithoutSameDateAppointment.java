package medisync.api.domain.appointment.validators;

import jakarta.validation.ValidationException;
import medisync.api.domain.appointment.AppointmentRepository;
import medisync.api.domain.appointment.AppointmentScheduleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorPatientWithoutSameDateAppointment implements AppointmentScheduleValidator {
    @Autowired
    public AppointmentRepository repository;

    public void validate(AppointmentScheduleData data){
        var firstAvalibleSlot = data.date().withHour(7);
        var lastAvalibleSlot = data.date().withHour(18);
        var patientHasSameDayAppointment = repository.existsByPatientIdAndDateBetween(data.idPatient(), firstAvalibleSlot, lastAvalibleSlot);
         if(patientHasSameDayAppointment) throw new ValidationException("Patient já possui uma consulta agendada nesse dia");
    }
}
