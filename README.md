# spring-security
### Springboot security 
* 实现自定义用户校验机制-2019-09-06 19:33:05
## 欢迎大家补充完善
### sql 脚本：
````mysql
        CREATE TABLE `persistent_logins` (
         `username` varchar(64) NOT NULL,
         `series` varchar(64) NOT NULL,
         `token` varchar(64) NOT NULL,
         `last_used` timestamp NOT NULL,
         PRIMARY KEY (`series`)
       ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
````
````mysql
        CREATE TABLE `sys_user_role` (
          `userRoleId` varchar(32) NOT NULL,
          `roleId` varchar(32) NOT NULL,
          `userId` varchar(255) NOT NULL,
          `updateUserId` varchar(32) NOT NULL,
          `createUserId` varchar(32) NOT NULL,
          `updateTime` timestamp NULL DEFAULT NULL,
          `createTime` timestamp NULL DEFAULT NULL,
          PRIMARY KEY (`userRoleId`),
          UNIQUE KEY `username` (`roleId`) USING BTREE
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
````

````mysql
        CREATE TABLE `sys_user` (
          `userId` varchar(32) NOT NULL,
          `userName` varchar(20) NOT NULL,
          `password` varchar(255) NOT NULL,
          `updateUserId` varchar(32) NOT NULL,
          `createUserId` varchar(32) NOT NULL,
          `updateTime` timestamp NULL DEFAULT NULL,
          `createTime` timestamp NULL DEFAULT NULL,
          PRIMARY KEY (`userId`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
````

````mysql
       CREATE TABLE `sys_role` (
         `roleId` varchar(32) NOT NULL,
         `name` varchar(255) NOT NULL,
         `state` tinyint(4) DEFAULT '1' COMMENT '1-有效 0-无效',
         `updateUserId` varchar(32) NOT NULL,
         `createUserId` varchar(32) NOT NULL,
         `updateTime` timestamp NULL DEFAULT NULL,
         `createTime` timestamp NULL DEFAULT NULL,
         PRIMARY KEY (`roleId`),
         UNIQUE KEY `username` (`roleId`) USING BTREE
       ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
````

     
       

