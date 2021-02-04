package com.deepakmart.repository;

import com.deepakmart.entity.DeepakMartUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<DeepakMartUsers, String> {

}
