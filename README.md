#### maven 不同环境的配置

1.1 在profiles中配置所需要的环境

1.2 配置不同环境的config配置文件所在目录及配置信息

1.3 在资源[resource目录下]配置文件中,引用之前不同的配置文件的属性

1.4 使用mvn clean package -P[env] -Dmaven.test.skip=true,指定不同环境