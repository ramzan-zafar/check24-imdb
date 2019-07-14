package com.check24.role.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.check24.common.model.RoleName;
import com.check24.role.model.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
	  Optional<Role> findByName(RoleName roleName);
}