package com.example.ymu.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPrincipal is a Querydsl query type for Principal
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPrincipal extends EntityPathBase<Principal> {

    private static final long serialVersionUID = 1155882274L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPrincipal principal = new QPrincipal("principal");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final EnumPath<com.example.ymu.domain.type.PrincipalType> PrincipalType = createEnum("PrincipalType", com.example.ymu.domain.type.PrincipalType.class);

    public final QTeacher teacher;

    public QPrincipal(String variable) {
        this(Principal.class, forVariable(variable), INITS);
    }

    public QPrincipal(Path<? extends Principal> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPrincipal(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPrincipal(PathMetadata metadata, PathInits inits) {
        this(Principal.class, metadata, inits);
    }

    public QPrincipal(Class<? extends Principal> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.teacher = inits.isInitialized("teacher") ? new QTeacher(forProperty("teacher"), inits.get("teacher")) : null;
    }

}

