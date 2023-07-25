package com.gmail.sge.serejka.springgeohw.repository;

import com.gmail.sge.serejka.springgeohw.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
