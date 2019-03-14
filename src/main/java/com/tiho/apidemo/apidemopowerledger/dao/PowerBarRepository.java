package com.tiho.apidemo.apidemopowerledger.dao;

import com.tiho.apidemo.apidemopowerledger.model.PowerBar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerBarRepository extends JpaRepository<PowerBar, Long> {

}
