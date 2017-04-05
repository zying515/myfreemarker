package com.myfreemarker;


import com.myfreemarker.bean.City;
import com.myfreemarker.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public String  findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        System.out.println("cityName="+cityName);
        City city= cityService.findCityByName(cityName);
        Map map=new HashMap();
        map.put("name",city.getDescription());
        return "aa";
    }
    @RequestMapping(value = "/api/city/add", method = RequestMethod.GET)
    public String  findOneCity() {
       // System.out.println("cityName="+cityName);
       // City city= cityService.findCityByName();
        Map map=new HashMap();
       // map.put("name",city.getDescription());
        return "aa";
    }
    /*public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        return cityService.findCityByName(cityName);
    }*/

}
