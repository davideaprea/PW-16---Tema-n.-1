package com.business.location.service;

import com.business.location.dao.RegionDAO;
import com.business.location.dto.response.RegionGetResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class RegionService {
    private final RegionDAO regionDAO;

    public List<RegionGetResponse> getAll() {
        return StreamSupport
                .stream(regionDAO.findAll().spliterator(), false)
                .map(r -> new RegionGetResponse(r.getId(), r.getName()))
                .toList();
    }
}
