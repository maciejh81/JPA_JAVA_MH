package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.mapper.AddressMapper;
import com.capgemini.wsb.repository.AddressRepository;
import com.capgemini.wsb.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressTO getAddressById(Long id) {
        AddressEntity addressEntity = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id " + id));
        return AddressMapper.toAddressTO(addressEntity);
    }

    @Override
    public List<AddressTO> getAllAddresses() {
        return addressRepository.findAll().stream()
                .map(AddressMapper::toAddressTO)
                .collect(Collectors.toList());
    }

    @Override
    public AddressTO saveAddress(AddressTO addressTO) {
        AddressEntity addressEntity = AddressMapper.toAddressEntity(addressTO);
        addressEntity = addressRepository.save(addressEntity);
        return AddressMapper.toAddressTO(addressEntity);
    }

    @Override
    public void deleteAddress(Long id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Address not found with id " + id);
        }
    }
}
