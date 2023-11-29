package medisync.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import medisync.api.address.Address;
import medisync.api.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid DoctorRegistrationData data, UriComponentsBuilder uriBuilder){
        var doctor = new Doctor(data);
        repository.save(doctor);

        var uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();

        //Devolve cod 201, cabeçalho com a uri e no coprpo da resposta o recurso criado
        return ResponseEntity.created(uri).body(new DoctorDetailData(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorListData>> list(Pageable pageable) {
        var page =  repository.findAllByActiveTrue(pageable).map(DoctorListData::new);
        return ResponseEntity.ok(page);
    }

    /*@GetMapping
    public Page<DoctorListData> list(@PageableDefault(size = 10, page=0, sort = {"name"}) Pageable pageable) {
        return repository.findAll(pageable).map(DoctorListData::new);
    }*/

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DoctorUpdateData data){
        var doctor = repository.getReferenceById(data.id());
        doctor.updateInfo(data);

        //Retorna cod 200 e objeto corpo da resposta com os dados atualizados
        return ResponseEntity.ok(new DoctorDetailData(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var doctor = repository.getReferenceById(id);
        doctor.exclude();

        //retorna cod 204
        return ResponseEntity.noContent().build();
    }





}
