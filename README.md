# ordinary-cloud

### 项目介绍
    1，SpringBoot + SpringCloud搭建的一个完整分布式框架。
    2，项目有完整的业务逻辑体系，不掺杂其它无用代码，可以直接clone运用到实际项目中。
    3，项目实现SpringCloud常用组件，分布式事务，分布式锁等一些很普遍的功能。做到开箱即用的特点。

### 项目结构介绍
    api子模块：分离接口，把业务调用接口分离出来。
    common子模块：公用模块，里面可以添加公用的类。
    entity子模块：实体类。
    tm子模块：txlcn分布式事务管理控制台。
    eureka子模块：服务注册与发现。
    config子模块：SpringCloud-Config服务。
    turbine子模块：服务监控。
    zuul子模块：网关。
    commodity子模块：商品服务。
    user子模块：商品服务。
    order子模块：订单服务。

### 说明
    JDK使用的是11，idea自带JDK。如果你用的是2019版本之上的idea，可以直接clone就能跑项目了。
    SpringBoot使用的2.2.2.RELEASE(目前最新版)。
    分布式事务使用txlcn框架实现。
    分布式锁使用Redisson框架实现。（注：本项目使用的是哨兵模式。）
    数据库最好使用5.6及以上版本。
    
### 能用到的链接
    1，eureka可视化界面 http://localhost:8761
    2，zuul路由信息 http://localhost:8020/actuator/routes
    3，hystrix仪表盘 http://localhost:8010/hystrix
    4，turbine监控集群(这个是配置过的) http://localhost:8010/turbine.stream?cluster=default
    5，turbine监控信息 http://localhost:8010/clusters
    5，hystrix本地服务监控 http://localhost:9010/actuator/hystrix.stream
    6，config手动刷新 http://localhost:9010/actuator/refresh
    
### 打赏作者
![Image text](https://github.com/HyacinthFlower/ordinary-cloud/zhifubao.png)
    
### 作者微信 z967882
