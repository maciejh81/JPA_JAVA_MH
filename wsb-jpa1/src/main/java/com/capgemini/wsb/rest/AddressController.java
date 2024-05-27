package com.capgemini.wsb.rest;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/{id}")
    public AddressTO getAddressById(@PathVariable Long id) {
        return addressService.getAddressById(id);
    }

    @GetMapping
    public List<AddressTO> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @PostMapping
    public AddressTO createAddress(@RequestBody AddressTO addressTO) {
        return addressService.saveAddress(addressTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }
}
