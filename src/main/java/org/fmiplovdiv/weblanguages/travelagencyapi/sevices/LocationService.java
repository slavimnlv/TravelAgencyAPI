package org.fmiplovdiv.weblanguages.travelagencyapi.sevices;

import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.*;

import java.time.LocalDateTime;
import java.util.List;

public interface LocationService {
    ResponseLocation create(CreateLocation location);
    Boolean delete(Long id);
    List<ResponseLocation> getAll();
    ResponseLocation get(Long id);
    ResponseLocation update(UpdateLocation location);

}
