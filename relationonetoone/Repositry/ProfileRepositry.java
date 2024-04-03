package com.example.relationonetoone.Repositry;

import com.example.relationonetoone.Model.Customer;
import com.example.relationonetoone.Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepositry extends JpaRepository<Profile,Integer> {
Profile findProfileById(Integer id);
}
