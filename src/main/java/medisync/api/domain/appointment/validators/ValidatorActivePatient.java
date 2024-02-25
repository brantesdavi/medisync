package medisync.api.domain.appointment.validators;

import jakarta.validation.ValidationException;
import medisync.api.domain.appointment.AppointmentScheduleData;
import medisync.api.domain.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorActivePatient implements AppointmentScheduleValidator {

    @Autowired
    public PatientRepository repository;

    public void validate(AppointmentScheduleData data){
        var isPatientActive = repository.findActiveById(data.idPatient());

        if(!isPatientActive) throw new ValidationException("The doctor must be active to schedule");
    }

}
