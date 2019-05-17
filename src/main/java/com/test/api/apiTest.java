package com.test.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/")

public class apiTest {

    @CrossOrigin(origins = {"http://localhost:8088", "*"})
    @RequestMapping(value = "/api/getuser",method = RequestMethod.POST)
    List<Data> getData(){
        Data data;
        List<Data> data1= new ArrayList<>();
        for (int i=0;i<5;i++){
            UserModel user=new UserModel();
            user.setId(i+4545);
            user.setName("Robert Donnery Jr"+i);
            user.setPassword("12345678"+i);

             data=new Data();
            data.setUser(user);
            data1.add(data);
        }




        return  data1;
    }



    @CrossOrigin(origins = {"http://localhost:8088", "*"})
    @RequestMapping(value = "/api/login",method = RequestMethod.POST)
     public Boolean Login(UserModel user){



        if (user.getName().equals("admin") && user.getPassword().equals("admin"))
        {     System.out.println(true+"");
            return  true;


        }else {
            System.out.println(user.getName()+"");
            return  false;
        }


    }


    public static void main(String[] args) {
        SpringApplication.run(apiTest.class, args);
    }
}
