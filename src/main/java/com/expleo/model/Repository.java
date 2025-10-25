package com.expleo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * lombok - auto generates getter and setters
 *
 * @Builder
 * Enables a builder patter,
 * Repository repo=Repository.builder().id(101).name("new-repo")
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Repository {
    private Long id;
    private String name;
    private String full_name;

}
