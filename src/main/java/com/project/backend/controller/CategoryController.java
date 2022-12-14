package com.project.backend.controller;

import com.project.backend.entity.ApartmentApplicationEntity;
import com.project.backend.entity.ApartmentEntity;
import com.project.backend.entity.CarEntity;
import com.project.backend.entity.BillEntity;
import com.project.backend.entity.ServiceApplicationEntity;
import com.project.backend.entity.UserEntity;
import com.project.backend.repository.ApartmentApplicationRepository;
import com.project.backend.repository.ApartmentRepository;
import com.project.backend.repository.BillRepository;
import com.project.backend.repository.CarRepository;
import com.project.backend.repository.ServiceApplicationRepository;
import com.project.backend.repository.UserRepository;
import com.project.backend.response.Login;
import com.project.backend.response.LoginReponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
public class CategoryController {
    @Autowired
    private ApartmentApplicationRepository apartmentApplicationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ServiceApplicationRepository serviceApplicationRepository;

    @PostMapping("/login")
    public LoginReponse login(@RequestBody Login login){
        UserEntity user = userRepository.getUser(login.getPhone());
        if(user == null)
            return new LoginReponse("Account doesnt exist",0);
        if(user.getPhone().equals(login.getPassword()))
            return new LoginReponse("Success",user.getId());
        return new LoginReponse("Failed",0);
    }

    @PostMapping("/checkPhone")
    public LoginReponse checkPhone(@RequestBody Login login){
        UserEntity user = userRepository.getUser(login.getPhone());
        if(user == null)
        return new LoginReponse("Account exist",0);
        else
        return new LoginReponse("Account doesnt exist",0); 
    }

    @GetMapping("/getAllApartment")
    public List<ApartmentEntity> getAll(){
        return apartmentRepository.getAll();
    }

    @GetMapping("/getAllApartmentControll")
    public List<ApartmentEntity> getAllControl(@RequestParam long id){
        UserEntity user = userRepository.getUserFID(id);
        return apartmentRepository.getAllControll(user);
    }

    @GetMapping("/getAllApartmentApp")
    public List<ApartmentApplicationEntity> getAllAppRoom(@RequestParam long id){
        ApartmentEntity user = apartmentRepository.getOne(id);
        return apartmentApplicationRepository.getAllControll(user);
    }

    @GetMapping("/getAllAprtmentUser")
    public List<ApartmentApplicationEntity> getAllUser(@RequestParam long id){
        UserEntity user = userRepository.getUserFID(id);
        return apartmentApplicationRepository.getUserApp(user);
    }
    
    @GetMapping("/getAllCar")
    public List<CarEntity> getAllcar(@RequestParam long id){
        return carRepository.getAll(userRepository.getUserFID(id));
    }

    @GetMapping("/getAllbill")
    public List<BillEntity> getAllBill(@RequestParam long id){
        return billRepository.getAllProductByCategoryId(userRepository.getUserFID(id));
    }

    @GetMapping("/singleuser")
    public UserEntity getOne(@RequestParam long id){
        return userRepository.getUserFID(id);
    }

    @PostMapping("/deleteCar")
    public String deleteCar(@RequestParam long id){
        CarEntity car = carRepository.getUserFID(id);
        carRepository.delete(car);
        return "Success";
    }

    @PostMapping("/user")
    public String updateUser(@RequestBody UserEntity user,@RequestParam Long roomid){
        if(roomid != null)  
            user.setApartment(apartmentRepository.getOne(roomid));
        userRepository.save(user);
        return "Success";
    }
    @PostMapping("/apartment")
    public String updateApartment(@RequestBody ApartmentEntity user,@RequestParam Long userid){
        if(userid != null)  
            user.setOwner(userRepository.getUserFID(userid));
        apartmentRepository.save(user);
        return "Success";
    }
    @PostMapping("/apartmentapp")
    public String updateApp(@RequestBody ApartmentApplicationEntity user,@RequestParam Long roomid,@RequestParam Long userid){
        if(userid != null)  
            user.setUser(userRepository.getUserFID(userid));
        if(roomid != null)  
            user.setApartment(apartmentRepository.getOne(roomid));
        apartmentApplicationRepository.save(user);
        return "Success";
    }
    @PostMapping("/car")
    public String updateCar(@RequestBody CarEntity user,@RequestParam Long userid){
        if(userid != null)  
            user.setUser(userRepository.getUserFID(userid));
        carRepository.save(user);
        return "Success";
    }
    @PostMapping("/service")
    public String updateService(@RequestBody ServiceApplicationEntity user,@RequestParam Long roomid,@RequestParam Long userid,@RequestParam Long carid){
        if(userid != null)  
            user.setUser(userRepository.getUserFID(userid));
        if(roomid != null)  
            user.setApartment(apartmentRepository.getOne(roomid));
        if(carid != null)  
            user.setCar(carRepository.getUserFID(roomid));
        serviceApplicationRepository.save(user);
        return "Success";
    }
    @PostMapping("/bill")
    public String updateBill(@RequestBody BillEntity user,@RequestParam Long userid){
        if(userid != null)  
            user.setUser(userRepository.getUserFID(userid));
        billRepository.save(user);
        return "Success";
    }
    
}
