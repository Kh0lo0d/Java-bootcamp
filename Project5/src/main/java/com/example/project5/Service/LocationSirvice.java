package com.example.project5.Service;

import com.example.project5.DTO.LocationStoreDTO;
import com.example.project5.Exception.ApiException;
import com.example.project5.Model.Book;
import com.example.project5.Model.Location;
import com.example.project5.Model.Store;
import com.example.project5.Repositary.LocationRepositary;
import com.example.project5.Repositary.StroreRepositary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationSirvice {
    private final LocationRepositary locationRepositary;
private final StroreRepositary stroreRepositary;
    public List getAllLocation(){
        return locationRepositary.findAll();
    }

    public void addNewLocation(Location location){
        locationRepositary.save(location);
    }

    public void updateLocation(Integer id,Location location)
    {
        Location oldLocation=locationRepositary.getById(id);
        if(oldLocation==null){
            throw new ApiException("Location Not found !");
        }
        else{
            oldLocation.setArea(location.getArea());
            oldLocation.setStreet(location.getStreet());
          locationRepositary.save(oldLocation);
           }}

    public void deleteLocation(Integer id)
    {
        Location oldLocation=locationRepositary.getById(id);


        if(oldLocation==null){
            throw new ApiException("location Not found !");
        }
        else
            locationRepositary.deleteById(id);

    }

    public LocationStoreDTO AllLocationById(Integer id){
        Location location=locationRepositary.findLocationById(id);
        LocationStoreDTO locationStoreDTO=new LocationStoreDTO(id,location.getArea(),location.getStreet());
        return  locationStoreDTO;
    }




    public void addLocationStore(LocationStoreDTO locationStoreDTO)
    {
        Store store=stroreRepositary.findStoreById(locationStoreDTO.getStore_Id());
        if(store==null){
            throw new ApiException("store not fpund");}
        Location location =new Location(null,locationStoreDTO.getArea(), locationStoreDTO.getStreet(), store);
locationRepositary.save(location);
        }


        public void updateStoreLocation(LocationStoreDTO locationStoreDTO){
        Location location=locationRepositary.findLocationById(locationStoreDTO.getStore_Id());
            if(location==null)
                throw new ApiException("store not found");
            location.setArea(locationStoreDTO.getArea());
            locationStoreDTO.setStreet(location.getStreet());
            locationRepositary.save(location);

        }


    public void deleteStoreLocation(Integer id)
    {
        Location location=locationRepositary.findLocationById(id);
        if(location==null){
            throw new ApiException("Store not found");
        }
        locationRepositary.delete(location);
    }







    }



