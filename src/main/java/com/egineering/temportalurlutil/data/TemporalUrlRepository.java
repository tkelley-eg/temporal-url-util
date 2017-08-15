package com.egineering.temportalurlutil.data;

import com.egineering.temportalurlutil.domain.TemporalUrl;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TemporalUrlRepository extends MongoRepository<TemporalUrl, String> {

    public TemporalUrl findByUrlToken(String urlToken);

}
