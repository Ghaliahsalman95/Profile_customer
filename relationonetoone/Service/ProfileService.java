package com.example.relationonetoone.Service;

import com.example.relationonetoone.API.APIException;
import com.example.relationonetoone.DTO.ProfileDTO;
import com.example.relationonetoone.Model.Customer;
import com.example.relationonetoone.Model.Profile;
import com.example.relationonetoone.Repositry.CustomerRepositry;
import com.example.relationonetoone.Repositry.ProfileRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepositry profileRepositry;
    private final CustomerRepositry customerRepositry;



    public List<Profile>get(){
        return profileRepositry.findAll();
    }
    public void add(ProfileDTO profileDTO){
        Customer customer=customerRepositry.findCustomerById(profileDTO.getCustomer_id());
        if (customer!=null){
        Profile profile=new Profile(null,profileDTO.getEmail(),profileDTO.getPhone(),profileDTO.getAge(),customer);
        profileRepositry.save(profile);
        }
        else throw  new APIException("Not found customer id");
    }

    public void update(ProfileDTO profileDTO){
        Profile profile=profileRepositry.findProfileById(profileDTO.getCustomer_id());
        if (profile!=null){
          profile.setEmail(profileDTO.getEmail());
          profile.setAge(profileDTO.getAge());
          profile.setPhone(profileDTO.getPhone());
          profile.setCustomer(customerRepositry.findCustomerById(profileDTO.getCustomer_id()));
            profileRepositry.save(profile);
        }
        else throw  new APIException("Not found customer id");
    }

public void delete(Integer id){
        Profile profile=profileRepositry.findProfileById(id);
        if (profile!=null){
            profileRepositry.delete(profile);
        }else throw  new APIException("Not found customer id");
}

}
