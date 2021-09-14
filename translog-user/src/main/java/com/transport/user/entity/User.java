package com.transport.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "freight_transport_region_user")
public class User {
    @Id
    private Integer userId;
}
