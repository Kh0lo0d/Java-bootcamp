package com.example.homwork21.Servier;

import com.example.homwork21.Model.Teatcher;
import com.example.homwork21.Repositry.TeatcherRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class TeatcherServir {

    private final TeatcherRepositry teatcherRepositry;

    public List getAllTeatchers() {

        return teatcherRepositry.findAll();
    }

    public void addTeatcher(Teatcher teatcher) {
        teatcherRepositry.save(teatcher);}

        public boolean updateTeatcher(Integer id,Teatcher teatcher){

            Teatcher oldTeatcher=teatcherRepositry.getById(id);
            if(oldTeatcher==null){
                return false;}
            oldTeatcher.setName(teatcher.getName());
            oldTeatcher.setAge(teatcher.getAge());
            oldTeatcher.setEmail(teatcher.getEmail());
            oldTeatcher.setSalary(teatcher.getSalary());

           teatcherRepositry.save(oldTeatcher);
            return true;
        }

        public boolean deleteTeatcher(Integer id) {
            Teatcher oldTeatcher=teatcherRepositry.getById(id);

            if (oldTeatcher == null) {
                return false;
            } else
                teatcherRepositry.deleteById(id);

            return true;

        }



    }


