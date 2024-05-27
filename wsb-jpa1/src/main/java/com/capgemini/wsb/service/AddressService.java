package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.AddressTO;
import java.util.List;

public interface AddressService {
    AddressTO getAddressById(Long id);
    List<AddressTO> getAllAddresses();
    AddressTO saveAddress(AddressTO addressTO);
    void deleteAddress(Long id);
}
