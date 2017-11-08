package com.example.ymu.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGrade is a Querydsl query type for Grade
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGrade extends EntityPathBase<Grade> {

    private static final long serialVersionUID = -1769191733L;

    public static final QGrade grade = new QGrade("grade");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final ListPath<Classz, QClassz> classzs = this.<Classz, QClassz>createList("classzs", Classz.class, QClassz.class, PathInits.DIRECT2);

    public final NumberPath<Integer> gnum = createNumber("gnum", Integer.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public QGrade(String variable) {
        super(Grade.class, forVariable(variable));
    }

    public QGrade(Path<? extends Grade> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGrade(PathMetadata metadata) {
        super(Grade.class, metadata);
    }

}

