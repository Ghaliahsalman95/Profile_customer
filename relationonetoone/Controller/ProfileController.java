package com.example.relationonetoone.Controller;

import com.example.relationonetoone.API.APIResponse;
import com.example.relationonetoone.DTO.ProfileDTO;
import com.example.relationonetoone.Service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController@RequestMapping("api/v1/profile")
public class ProfileController {
Logger logger= LoggerFactory.getLogger(ProfileController.class);
    private final ProfileService profileService;
    @PostMapping("/add-profile")
    public ResponseEntity add(@RequestBody @Valid ProfileDTO profileDTO){
        logger.info("inside add ");

        profileService.add(profileDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("link with customer successfully"));
    }
    @GetMapping("get-all")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(profileService.get());
    }

    @PutMapping("/update-profile")
    public ResponseEntity update(@RequestBody @Valid ProfileDTO profileDTO){
        logger.info("inside update ");

        profileService.update(profileDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("update successfully"));
    }
    @DeleteMapping("/delete-profile/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        logger.info("inside delete ");

        profileService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("delete successfully"));
    }


}
