package com.example.graalvm.graalvm.config;

import liquibase.changelog.ChangeLogHistoryServiceFactory;
import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

import java.util.Collections;

public class LiquibaseRuntimeHints implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints.resources().registerPattern("db/master-changelog.xml");
        hints.resources().registerPattern("db/changelog/initial/db_init.xml");
        hints.resources().registerPattern("db/changelog/2024/02/*.xml");
        //https://github.com/oracle/graalvm-reachability-metadata/issues/431
        hints.reflection().registerType(ChangeLogHistoryServiceFactory.class, (type) ->
                type.withConstructor(Collections.emptyList(), ExecutableMode.INVOKE));
    }
}