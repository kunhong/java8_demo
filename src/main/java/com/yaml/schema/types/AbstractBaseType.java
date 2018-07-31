package com.yaml.schema.types;

import java.util.logging.Logger;

public abstract class AbstractBaseType {
    //private static Logger log = Logger.getLogger( AbstractBaseType.class );

    private static final String OPTIONAL_PREFIX = "-";

    private static final String REQUIRED_PREFIX = "+";

    private String name;

    private String description = "";

    private boolean required = true;
}
