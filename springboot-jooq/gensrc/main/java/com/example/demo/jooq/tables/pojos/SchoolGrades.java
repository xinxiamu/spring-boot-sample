/*
 * This file is generated by jOOQ.
*/
package com.example.demo.jooq.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SchoolGrades implements Serializable {

    private static final long serialVersionUID = 240572052;

    private Long schoolId;
    private Long gradesId;

    public SchoolGrades() {}

    public SchoolGrades(SchoolGrades value) {
        this.schoolId = value.schoolId;
        this.gradesId = value.gradesId;
    }

    public SchoolGrades(
        Long schoolId,
        Long gradesId
    ) {
        this.schoolId = schoolId;
        this.gradesId = gradesId;
    }

    public Long getSchoolId() {
        return this.schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public Long getGradesId() {
        return this.gradesId;
    }

    public void setGradesId(Long gradesId) {
        this.gradesId = gradesId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SchoolGrades (");

        sb.append(schoolId);
        sb.append(", ").append(gradesId);

        sb.append(")");
        return sb.toString();
    }
}
