package com.gcu.wpd2.db;

import com.gcu.wpd2.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    
    Role findByRole(String role);
}
