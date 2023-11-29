package medisync.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import medisync.api.domain.patient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid PatientRegistrationData data, UriComponentsBuilder uriBuilder){
        var patient = new Patient(data);
        repository.save(patient);

        var uri = uriBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();
        return ResponseEntity.created(uri).body(new PatientDetailData(patient));
    }

    @GetMapping
    public ResponseEntity<Page<PatientListData>> list(Pageable pageable){
        var page = repository.findAllByActiveTrue(pageable).map(PatientListData::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("{id}")
    public ResponseEntity detail(@PathVariable Long id){
        var patient = repository.getReferenceById(id);
        return ResponseEntity.ok(new PatientDetailData(patient));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid PatientUpdateData data){
        var patient = repository.getReferenceById(data.id());
        patient.updateInfo(data);
        return ResponseEntity.ok(new PatientDetailData(patient));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var patient = repository.getReferenceById(id);
        patient.exclude();
        return ResponseEntity.noContent().build();
    }


}
