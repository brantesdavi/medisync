package medisync.api.domain.appointment.validators;

import jakarta.validation.ValidationException;
import medisync.api.domain.appointment.AppointmentScheduleData;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
@Component
public class ValidatorHour implements AppointmentScheduleValidator {

    public void validate(AppointmentScheduleData data){
        var appointmentDate = data.date();
        var now = LocalDateTime.now();

        var difInMinutes = Duration.between(now, appointmentDate).toMinutes();

        if(difInMinutes < 30){
            throw new ValidationException("Appoint has to be schedule more than 30 minutes before");
        }
    }
}
