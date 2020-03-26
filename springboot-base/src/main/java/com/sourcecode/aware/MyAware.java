package com.sourcecode.aware;

import org.springframework.beans.factory.Aware;

public interface MyAware extends Aware {

    void setFlag(Flag flag);

}
