package com.pi;

import org.springframework.data.jpa.repository.JpaRepository;

//CECI EST LE REPRESNTANT DU MODEL DE LA TABLE CITOYEN DANS LA BD
public interface CitoyenRepository extends JpaRepository<Citoyen, Integer>{

}
