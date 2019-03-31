package com.example.springboot2hikarcpmultiple.dao;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@org.hibernate.annotations.Table(appliesTo = "area_zh_",comment = "地址表")
public class AreaZh {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,columnDefinition = "varchar(16) comment '行政代码'")
    private String code;

    @Column(columnDefinition = "decimal(19,8) comment '纬度'")
    private BigDecimal lat;

    @Column(columnDefinition = "decimal(19,8) comment '经度'")
    private BigDecimal lng;

    @Column(nullable = false,columnDefinition = "smallint(1) comment '层级'")
    private Short level;

    @Column(columnDefinition = "varchar(255) comment '组合名称'")
    private String mergerName;

    @Column(columnDefinition = "varchar(50) comment '名称'")
    private String name;

    @Column(columnDefinition = "varchar(255) comment '拼音'")
    private String pinyin;

    @Column(columnDefinition = "varchar(150) comment '简称'")
    private String shortName;

    @Column(nullable = false,columnDefinition = "varchar(30) comment '电话区号'")
    private String telCode;

    @Column(nullable = false,columnDefinition = "varchar(50) comment '邮政编码'")
    private String zipCode;

    @ManyToOne
    private AreaZh parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<AreaZh> children;



}
