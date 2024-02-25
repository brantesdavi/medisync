package medisync.api.domain.appointment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    boolean existsByPatientIdAndDateBetween(
            Long idPatient,
            LocalDateTime firstAvalibleSlot,
            LocalDateTime lastAvalibleSlot
    );

    boolean existsByDoctorIdAndDate(Long idMedico, LocalDateTime date);
}
