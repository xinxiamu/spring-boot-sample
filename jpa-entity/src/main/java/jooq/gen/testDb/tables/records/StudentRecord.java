/*
 * This file is generated by jOOQ.
*/
package jooq.gen.testDb.tables.records;


import javax.annotation.Generated;

import jooq.gen.testDb.tables.Student;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StudentRecord extends UpdatableRecordImpl<StudentRecord> implements Record3<Long, Long, Long> {

    private static final long serialVersionUID = 1367140653;

    /**
     * Setter for <code>testDb.student.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>testDb.student.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>testDb.student.pepole_basic_id</code>.
     */
    public void setPepoleBasicId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>testDb.student.pepole_basic_id</code>.
     */
    public Long getPepoleBasicId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>testDb.student.classz_id</code>.
     */
    public void setClasszId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>testDb.student.classz_id</code>.
     */
    public Long getClasszId() {
        return (Long) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, Long, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, Long, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Student.STUDENT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return Student.STUDENT.PEPOLE_BASIC_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return Student.STUDENT.CLASSZ_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getPepoleBasicId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getClasszId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getPepoleBasicId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getClasszId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StudentRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StudentRecord value2(Long value) {
        setPepoleBasicId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StudentRecord value3(Long value) {
        setClasszId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StudentRecord values(Long value1, Long value2, Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached StudentRecord
     */
    public StudentRecord() {
        super(Student.STUDENT);
    }

    /**
     * Create a detached, initialised StudentRecord
     */
    public StudentRecord(Long id, Long pepoleBasicId, Long classzId) {
        super(Student.STUDENT);

        set(0, id);
        set(1, pepoleBasicId);
        set(2, classzId);
    }
}
