package com.jbn.block.maintenance.Controller;

import com.jbn.block.maintenance.DTO.HouseOwnerDTO;
import com.jbn.block.maintenance.Service.HouseOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/owner")
public class HouseOwnerController {

    private final HouseOwnerService houseOwnerService;

    public HouseOwnerController(HouseOwnerService houseOwnerService) {
        this.houseOwnerService = houseOwnerService;
    }

    @PostMapping
    public ResponseEntity<HouseOwnerDTO> addHouseOwner(@Valid @RequestBody HouseOwnerDTO postDTO){
        return new ResponseEntity<>(houseOwnerService.addHouseOwner(postDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<HouseOwnerDTO>> getAllHouseOwners(){
        return new ResponseEntity<>(houseOwnerService.getAllHouseOwners(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HouseOwnerDTO> getHouseOwnerById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(houseOwnerService.getHouseOwnerById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<HouseOwnerDTO> updateHouseOwner(@Valid @RequestBody HouseOwnerDTO postDTO, @PathVariable(name = "id") long id){
        return new ResponseEntity<>(houseOwnerService.updateHouseOwner(postDTO,id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHouseOwner(@PathVariable long id){
        return new ResponseEntity<String>(houseOwnerService.deleteHouseOwner(id), HttpStatus.ACCEPTED);

    }

}
