package medisync.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import medisync.api.domain.appointment.AppointmentSchdule;
import medisync.api.domain.appointment.AppointmentScheduleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appointments")
public class AppointmentController {

    @Autowired
    private AppointmentSchdule schedule;

    @PostMapping
    @Transactional
    public ResponseEntity schedule(@RequestBody @Valid AppointmentScheduleData data){
        var dto = schedule.schedule(data);
        return ResponseEntity.ok(dto);
    }

}
