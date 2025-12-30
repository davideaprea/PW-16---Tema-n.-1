package com.business.group.location.service;

import com.business.group.location.dao.RegionDAO;
import com.business.group.location.dto.response.RegionGetResponse;
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
