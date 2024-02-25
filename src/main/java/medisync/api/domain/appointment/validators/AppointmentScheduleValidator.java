package medisync.api.domain.appointment.validators;

import medisync.api.domain.appointment.AppointmentScheduleData;

public interface AppointmentScheduleValidator {

    void validate(AppointmentScheduleData data);
}
