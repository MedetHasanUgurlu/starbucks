package com.medron.starbucks.adapter.abstracts;

import com.medron.starbucks.service.dto.request.CustomerCreateRequest;

public interface MernisService {
    void checkIdentity(CustomerCreateRequest request);
}
