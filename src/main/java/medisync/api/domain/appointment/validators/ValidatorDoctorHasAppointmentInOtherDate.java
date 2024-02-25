package medisync.api.domain.appointment.validators;

import jakarta.validation.ValidationException;
import medisync.api.domain.appointment.AppointmentRepository;
import medisync.api.domain.appointment.AppointmentScheduleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorDoctorHasAppointmentInOtherDate implements AppointmentScheduleValidator {
    @Autowired
    private AppointmentRepository repository;

    public void validate(AppointmentScheduleData data){
        var doctorHasAppointmentInOtherDateValidator = repository.existsByDoctorIdAndDate(data.idDoctor(), data.date());
        if(doctorHasAppointmentInOtherDateValidator){
            throw new ValidationException("Doctor já possui outra consulta nesse horario");
        }
    }
}
