package com.example.project5.Service;

import com.example.project5.DTO.LocationStoreDTO;
import com.example.project5.Exception.ApiException;
import com.example.project5.Model.Book;
import com.example.project5.Model.Customer;
import com.example.project5.Model.Location;
import com.example.project5.Model.Store;
import com.example.project5.Repositary.CustomerRepositary;
import com.example.project5.Repositary.LocationRepositary;
import com.example.project5.Repositary.StroreRepositary;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StroreRepositary stroreRepositary;
    private final CustomerRepositary customerRepositary;
    private LocationRepositary locationRepositary;

    public List<Store> getAllStore(){
        return stroreRepositary.findAll();

    }

    public void addNewStore(Store store){
        stroreRepositary.save(store);
    }

    public void updateStore(Integer id,Store store)
    {
        Store oldStore=stroreRepositary.getById(id);
        if(oldStore==null){
            throw new ApiException("store Not found !");
        }
        else{
        oldStore.setName(store.getName());
        stroreRepositary.save(oldStore);}


    }



    public void deleteStore(Integer id)
    {
        Store oldStore=stroreRepositary.getById(id);
        if(oldStore==null){
            throw new ApiException("store Not found !");
        }
        else
            stroreRepositary.deleteById(id);


    }







        public void assignStoreToCustomer(Integer store_id,Integer customer_id )
        {
            Store store=stroreRepositary.findStoreById(store_id);
            Customer customer=customerRepositary.findCustomerById(customer_id);
            if(store ==null || customer==null){
                throw new ApiException("not found");

            }
            else{
                store.getCustomers().add(customer);
                customer.getStores().add(store);
                stroreRepositary.save(store);
                customerRepositary.save(customer);

            }

        }


public Set<Book> ReturnAllBooksByStoreid(Integer id) {
    Store store = stroreRepositary.findStoreById(id);
    Set<Book> books = store.getBooks();
    return books;


}


public Set<Customer> ReturnAllCustomerById(Integer id)
{
    Store store=stroreRepositary.findStoreById(id);
    Set<Customer>customers=store.getCustomers();
    return customers;
}



}
