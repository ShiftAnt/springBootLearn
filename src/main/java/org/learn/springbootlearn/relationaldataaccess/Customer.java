package org.learn.springbootlearn.relationaldataaccess;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Customer {
    private long id;
    private String firstName, lastName;
    
}
