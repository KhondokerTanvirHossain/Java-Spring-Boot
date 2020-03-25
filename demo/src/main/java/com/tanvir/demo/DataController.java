package com.tanvir.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class DataController {
    @Autowired
    private DataService dataService;

    @RequestMapping(method = RequestMethod.GET, value = "/data")
    public ArrayList<DataModel> getAll(){
        return dataService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/data/{id}")
    public DataModel getOne(@PathVariable int id){
        return dataService.getOne(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/name/{id}")
    public String getName(@PathVariable int id){
        return dataService.getName(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/job/{id}")
    public String getJobDescription(@PathVariable int id){
        return dataService.getJobDescription(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/data")
    public void addData(@RequestBody DataModel model){
        dataService.addOne(model);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/data")
    public void updateOne(@RequestBody DataModel model){
        dataService.updateOne(model);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/name/{id}")
    public void updateName(@PathVariable int id,@RequestBody String name){
        dataService.updateName(id, name);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/job/{id}")
    public void updateJobDescription(@PathVariable int id,@RequestBody String job){
        dataService.updateJobDescription(id, job);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/data")
    public void deleteOne(@RequestBody DataModel model){
        dataService.deleteOne(model);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/data/{id}")
    public void deleteById(@PathVariable int id){
        dataService.deleteById(id);
    }
}
