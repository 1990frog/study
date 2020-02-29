package com.source.ioc.ann;

import org.springframework.context.annotation.Bean;

public interface SuperConfiguration {

    @Bean
    default MyCat myCat() {
        return new MyCat();
    }

}
