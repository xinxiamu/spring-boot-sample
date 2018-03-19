#!/usr/bin/env bash
java -classpath jooq-3.10.5.jar:jooq-meta-3.10.5.jar:jooq-codegen-3.10.5.jar:mysql-connector-java-5.1.18.jar:. org.jooq.util.GenerationTool /testDb.xml
