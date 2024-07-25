package com.lyw.springcloudstarter.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.ddl.IDdl;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author: liuyaowen
 * @poject: spring-cloud-starter
 * @create: 2024-07-25 13:34
 * @Description:
 */
@Configuration
public class MybatisConfig {


    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    @Bean
    public IDdl ddl() {
        return new IDdl() {


            @Override
            public void runScript(Consumer<DataSource> consumer) {
                consumer.accept(null);
            }

            @Override
            public List<String> getSqlFiles() {
                return List.of("classpath:sql/user.sql");
            }
        };
    }

}
