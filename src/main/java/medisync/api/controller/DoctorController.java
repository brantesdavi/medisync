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

/**
 * Controlador para manipulação de dados de médicos
 */

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    /**
     * Registra novo médico
     * @param data dados necessarios para registro de médico.
     * @param uriBuilder construtor de URIs.
     * @return ResponseEntity com detalhes do médico registrado no corpo da requisição.
     */
    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid DoctorRegistrationData data, UriComponentsBuilder uriBuilder){
        var doctor = new Doctor(data);
        repository.save(doctor);

        var uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DoctorDetailData(doctor));
    }

    /**
     * Lista os médicos de forma paginada
     * @param pageable informação de paginação.
     * @return ResposeEntity com a pagina de médicos
     */
    @GetMapping
    public ResponseEntity<Page<DoctorListData>> list(Pageable pageable) {
        var page =  repository.findAllByActiveTrue(pageable).map(DoctorListData::new);
        return ResponseEntity.ok(page);
    }

    /*@GetMapping
    public Page<DoctorListData> list(@PageableDefault(size = 10, page=0, sort = {"name"}) Pageable pageable) {
        return repository.findAll(pageable).map(DoctorListData::new);
    }*/

    /**
     * Atualiza médico
     * @param data com o id do médico para atualizar e informação a ser atualizada.
     * @return ResponseEntity com os detalhes do médico atualizado.
     */
    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DoctorUpdateData data){
        var doctor = repository.getReferenceById(data.id());
        doctor.updateInfo(data);

        return ResponseEntity.ok(new DoctorDetailData(doctor));
    }

    /**
     * Inativa um médico especifico
     * @param id do médico a ser inativado
     * @return  ResponseEntity no content
     */
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var doctor = repository.getReferenceById(id);
        doctor.exclude();
        return ResponseEntity.noContent().build();
    }

    /**
     * Retorna detalhes de um médico especifico
     * @param id do médico a ser procura.
     * @return ResponseEntity com os detalhes do médico especifico.
     */
    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id){
        var doctor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DoctorDetailData(doctor));
    }





}
