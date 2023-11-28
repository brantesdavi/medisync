package medisync.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import medisync.api.address.Address;
import medisync.api.doctor.Doctor;
import medisync.api.doctor.DoctorRegistrationData;
import medisync.api.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DoctorRegistrationData data){
        repository.save(new Doctor(data));
    }



}
