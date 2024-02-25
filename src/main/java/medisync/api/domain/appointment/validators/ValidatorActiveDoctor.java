package medisync.api.domain.appointment.validators;

import jakarta.validation.ValidationException;
import medisync.api.domain.appointment.AppointmentScheduleData;
import medisync.api.domain.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorActiveDoctor implements AppointmentScheduleValidator {

    @Autowired
    private DoctorRepository repository;

    public void validate(AppointmentScheduleData data){
        if(data.idDoctor() == null) return;

        var isDoctorActive = repository.findActiveById(data.idDoctor());

        if(!isDoctorActive) throw new ValidationException("The doctor must be active to schedule");
    }
}
