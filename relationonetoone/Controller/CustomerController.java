package com.example.relationonetoone.Controller;

import com.example.relationonetoone.API.APIResponse;
import com.example.relationonetoone.Model.Customer;
import com.example.relationonetoone.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor@RestController@RequestMapping("api/v1/customer")
public class CustomerController {
    Logger logger =LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;
@GetMapping("/get-all")
    public ResponseEntity get(){
    logger.info("inside get all");
       return ResponseEntity.status(HttpStatus.OK).body(customerService.getall());
    }

    @PostMapping("add-customer")
    public ResponseEntity add(@RequestBody @Valid Customer customer){
        logger.info("inside add ");

        customerService.add(customer);
    return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Added successfully"));
    }

    @PutMapping("update-customer/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid Customer customer){
        logger.info("inside update");

        customerService.update(id,customer);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("updated successfully"));
    }

    @DeleteMapping("delete-customer/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        logger.info("inside delete ");

        customerService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Deleted successfully"));
    }
}
