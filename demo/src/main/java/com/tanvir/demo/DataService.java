package com.tanvir.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DataService {

    @Autowired
    private DataRepository dataRepository;

    public ArrayList<DataModel> getAll(){
        ArrayList<DataModel> dataModels = new ArrayList<DataModel>();
        dataRepository.findAll().forEach(dataModels::add);
        return dataModels;
    }

    public DataModel getOne(int id){
        return dataRepository.
                findById(id).
                get();
    }

    public String getName(int id){
        return dataRepository
                .findById(id)
                .get()
                .getName();
    }

    public String getJobDescription(int id){
        return dataRepository
                .findById(id)
                .get()
                .getJobDescription();
    }

    public void addOne(DataModel model){
        dataRepository.save(model);
    }

    public void updateOne(DataModel model){
        dataRepository.save(model);
    }

    public void updateName(int id, String name){
        DataModel model = dataRepository.findById(id).get();
        dataRepository.save(new DataModel(id, name, model.getJobDescription()));
    }

    public void updateJobDescription(int id, String jobDescription){
        DataModel model = dataRepository.findById(id).get();
        dataRepository.save(new DataModel(id, model.getName(), jobDescription));
    }

    public void deleteOne(DataModel model){
        dataRepository.delete(model);
    }

    public void deleteById(int id){
        dataRepository.delete(dataRepository.findById(id).get());
    }
}
