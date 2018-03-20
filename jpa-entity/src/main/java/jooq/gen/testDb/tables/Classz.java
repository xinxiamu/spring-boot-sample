/*
 * This file is generated by jOOQ.
*/
package jooq.gen.testDb.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import jooq.gen.testDb.Indexes;
import jooq.gen.testDb.Keys;
import jooq.gen.testDb.Testdb;
import jooq.gen.testDb.tables.records.ClasszRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Classz extends TableImpl<ClasszRecord> {

    private static final long serialVersionUID = -1438536588;

    /**
     * The reference instance of <code>testDb.classz</code>
     */
    public static final Classz CLASSZ = new Classz();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ClasszRecord> getRecordType() {
        return ClasszRecord.class;
    }

    /**
     * The column <code>testDb.classz.id</code>.
     */
    public final TableField<ClasszRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>testDb.classz.cnum</code>.
     */
    public final TableField<ClasszRecord, Integer> CNUM = createField("cnum", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>testDb.classz.grade_id</code>.
     */
    public final TableField<ClasszRecord, Long> GRADE_ID = createField("grade_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * Create a <code>testDb.classz</code> table reference
     */
    public Classz() {
        this(DSL.name("classz"), null);
    }

    /**
     * Create an aliased <code>testDb.classz</code> table reference
     */
    public Classz(String alias) {
        this(DSL.name(alias), CLASSZ);
    }

    /**
     * Create an aliased <code>testDb.classz</code> table reference
     */
    public Classz(Name alias) {
        this(alias, CLASSZ);
    }

    private Classz(Name alias, Table<ClasszRecord> aliased) {
        this(alias, aliased, null);
    }

    private Classz(Name alias, Table<ClasszRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Testdb.TESTDB;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.CLASSZ_FKDGIFY2GAYJDKJYCB28EUA14U3, Indexes.CLASSZ_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ClasszRecord, Long> getIdentity() {
        return Keys.IDENTITY_CLASSZ;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ClasszRecord> getPrimaryKey() {
        return Keys.KEY_CLASSZ_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ClasszRecord>> getKeys() {
        return Arrays.<UniqueKey<ClasszRecord>>asList(Keys.KEY_CLASSZ_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ClasszRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ClasszRecord, ?>>asList(Keys.FKDGIFY2GAYJDKJYCB28EUA14U3);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Classz as(String alias) {
        return new Classz(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Classz as(Name alias) {
        return new Classz(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Classz rename(String name) {
        return new Classz(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Classz rename(Name name) {
        return new Classz(name, null);
    }
}