package medisync.api.domain.appointment;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import medisync.api.domain.doctor.Specialty;

import java.time.LocalDateTime;

public record AppointmentScheduleData(
        Long idDoctor,

        @NotNull
        Long idPatient,

        @NotNull
        @Future
        LocalDateTime date,

        Specialty specialty
) {
}
