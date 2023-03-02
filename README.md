# partner-match-backend
Partner Match is a app website that you can  find a like-minded partner
## 简介

一个帮助大家找到志同道合的伙伴的移动端网站（APP 风格），包括用户登录注册、更新个人信息、按标签搜索用户、推荐相似用户、组队等功能

## 技术选型

### 前端

1. Vue 3
2. Vant UI 组件库
3. Vite 脚手架
4. Axios 请求库

### 后端

1. Java SpringBoot 2.7.x 框架
2. MySQL 数据库
3. MyBatis-Plus
4. MyBatis X 自动生成
5. Redis 缓存（Spring Data Redis 等多种实现方式）
6. Redisson 分布式锁
7. Easy Excel 数据导入
8. Spring Scheduler 定时任务
9. Swagger + Knife4j 接口文档
10. Gson：JSON 序列化库
11. **相似度匹配算法**

### 后期优化扩展

1. 接入chatGPT
2. 深度学习网络
3. 图像处理
4. 语音处理



## 核心功能实现

### 相似度匹配核心算法

![match-user](https://raw.githubusercontent.com/dingxinliang88/figure/master/img/match-user.png)

![algorithm-match](https://raw.githubusercontent.com/dingxinliang88/figure/master/img/algorithm-match.png)

### Tags

![tags](https://raw.githubusercontent.com/dingxinliang88/figure/master/img/tags.png)

### 缓存预热

![precache](https://raw.githubusercontent.com/dingxinliang88/figure/master/img/precache.png)

### 匹配效果图

![match](https://raw.githubusercontent.com/dingxinliang88/figure/master/img/match.png)

## 项目优势

本项目涵盖了大部分常见的场景及其解决方案比如登录注册、批量数据导入、信息检索展示、定时任务、资源抢占等。并且涵盖了分布式、并发编程、锁、事务、缓存、性能优化、幂等性、数据一致性、大数据、算法等
