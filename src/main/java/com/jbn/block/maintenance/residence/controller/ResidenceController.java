package com.jbn.block.maintenance.residence.controller;

import com.jbn.block.maintenance.residence.dto.ResidentDetailDto;
import com.jbn.block.maintenance.residence.service.ResidentDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/resident")
public class ResidenceController {

    private final ResidentDetailService residentDetailService;

    public ResidenceController(ResidentDetailService residentDetailService) {
        this.residentDetailService = residentDetailService;
    }

    @PostMapping
    public ResponseEntity<ResidentDetailDto> addHouseOwner(@Valid @RequestBody ResidentDetailDto postDTO){
        return new ResponseEntity<>(residentDetailService.addHouseOwner(postDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResidentDetailDto>> getAllHouseOwners(){
        return new ResponseEntity<>(residentDetailService.getAllHouseOwners(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResidentDetailDto> getHouseOwnerById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(residentDetailService.getHouseOwnerById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<ResidentDetailDto> updateHouseOwner(@Valid @RequestBody ResidentDetailDto postDTO, @PathVariable(name = "id") long id){
        return new ResponseEntity<>(residentDetailService.updateHouseOwner(postDTO,id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHouseOwner(@PathVariable long id){
        return new ResponseEntity<String>(residentDetailService.deleteHouseOwner(id), HttpStatus.ACCEPTED);

    }

}
