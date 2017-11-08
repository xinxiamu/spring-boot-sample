package com.example.ymu.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QClassz is a Querydsl query type for Classz
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClassz extends EntityPathBase<Classz> {

    private static final long serialVersionUID = 869588366L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QClassz classz = new QClassz("classz");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> cnum = createNumber("cnum", Integer.class);

    public final QGrade grade;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final ListPath<Student, QStudent> students = this.<Student, QStudent>createList("students", Student.class, QStudent.class, PathInits.DIRECT2);

    public final ListPath<Teacher, QTeacher> teachers = this.<Teacher, QTeacher>createList("teachers", Teacher.class, QTeacher.class, PathInits.DIRECT2);

    public QClassz(String variable) {
        this(Classz.class, forVariable(variable), INITS);
    }

    public QClassz(Path<? extends Classz> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QClassz(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QClassz(PathMetadata metadata, PathInits inits) {
        this(Classz.class, metadata, inits);
    }

    public QClassz(Class<? extends Classz> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.grade = inits.isInitialized("grade") ? new QGrade(forProperty("grade")) : null;
    }

}

