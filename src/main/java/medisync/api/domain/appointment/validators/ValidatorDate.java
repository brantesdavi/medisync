package medisync.api.domain.appointment.validators;

import jakarta.validation.ValidationException;
import medisync.api.domain.appointment.AppointmentScheduleData;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
@Component
public class ValidatorDate implements AppointmentScheduleValidator {

    public void validate(AppointmentScheduleData data){
        var appointmentDate = data.date();

        var sun = appointmentDate.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var beforeOpening = appointmentDate.getHour() < 7;
        var afterClosing = appointmentDate.getHour() > 18;

        if(sun || beforeOpening || afterClosing){
            throw new ValidationException("We are closed");
        }
    }
}
