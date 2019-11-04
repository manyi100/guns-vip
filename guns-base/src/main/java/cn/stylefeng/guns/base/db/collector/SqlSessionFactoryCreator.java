package cn.stylefeng.guns.base.db.collector;

import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.autoconfigure.SpringBootVFS;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * mybatis的一些配置收集
 *
 * @author fengshuonan
 * @date 2019-06-15-18:30
 */
@Data
@Slf4j
@Configuration
public class SqlSessionFactoryCreator {

    private final MybatisPlusProperties properties;

    private final Interceptor[] interceptors;

    private final DatabaseIdProvider databaseIdProvider;

    private final ApplicationContext applicationContext;


    public SqlSessionFactoryCreator(MybatisPlusProperties properties,
                                    ObjectProvider<Interceptor[]> interceptorsProvider,
                                    ObjectProvider<DatabaseIdProvider> databaseIdProvider,
                                    ApplicationContext applicationContext) {
        this.properties = properties;
        this.interceptors = interceptorsProvider.getIfAvailable();
        this.databaseIdProvider = databaseIdProvider.getIfAvailable();
        this.applicationContext = applicationContext;
    }

    /**
     * 创建SqlSessionFactory
     */
    public synchronized SqlSessionFactory createSqlSessionFactory(DataSource dataSource) {
        try {
            MybatisSqlSessionFactoryBean factory = new MybatisSqlSessionFactoryBean();
            factory.setDataSource(dataSource);
            factory.setVfs(SpringBootVFS.class);
            if (!ObjectUtils.isEmpty(this.interceptors)) {
                factory.setPlugins(this.interceptors);
            }
            if (this.databaseIdProvider != null) {
                factory.setDatabaseIdProvider(this.databaseIdProvider);
            }
            if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
                factory.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
            }
            if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
                factory.setMapperLocations(this.properties.resolveMapperLocations());
            }
            GlobalConfig globalConfig = this.properties.getGlobalConfig();
            if (this.applicationContext.getBeanNamesForType(MetaObjectHandler.class,
                    false, false).length > 0) {
                MetaObjectHandler metaObjectHandler = this.applicationContext.getBean(MetaObjectHandler.class);
                globalConfig.setMetaObjectHandler(metaObjectHandler);
            }

            //globalConfig中有缓存sqlSessionFactory，目前还没别的办法
            SqlSessionFactory sqlSessionFactory = factory.getObject();
            globalConfig.signGlobalConfig(sqlSessionFactory);

            factory.setGlobalConfig(globalConfig);
            return factory.getObject();
        } catch (Exception e) {
            log.error("初始化SqlSessionFactory错误！", e);
            throw new ServiceException(500, "初始化SqlSessionFactory错误！");
        }
    }

}
