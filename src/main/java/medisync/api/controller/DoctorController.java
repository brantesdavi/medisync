package medisync.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import medisync.api.address.Address;
import medisync.api.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public Page<DoctorListData> list(Pageable pageable) {
        return repository.findAllByActiveTrue(pageable).map(DoctorListData::new);
    }

    /*@GetMapping
    public Page<DoctorListData> list(@PageableDefault(size = 10, page=0, sort = {"name"}) Pageable pageable) {
        return repository.findAll(pageable).map(DoctorListData::new);
    }*/

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DoctorUpdateData data){
        var doctor = repository.getReferenceById(data.id());
        doctor.updateInfo(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id){
        var doctor = repository.getReferenceById(id);
        doctor.exclude();
    }





}
