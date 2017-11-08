package com.example.ymu.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPepoleBasic is a Querydsl query type for PepoleBasic
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPepoleBasic extends EntityPathBase<PepoleBasic> {

    private static final long serialVersionUID = -2117815051L;

    public static final QPepoleBasic pepoleBasic = new QPepoleBasic("pepoleBasic");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final DateTimePath<java.util.Date> birthdayTime = createDateTime("birthdayTime", java.util.Date.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final EnumPath<com.example.ymu.domain.type.SexType> sextType = createEnum("sextType", com.example.ymu.domain.type.SexType.class);

    public QPepoleBasic(String variable) {
        super(PepoleBasic.class, forVariable(variable));
    }

    public QPepoleBasic(Path<? extends PepoleBasic> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPepoleBasic(PathMetadata metadata) {
        super(PepoleBasic.class, metadata);
    }

}

