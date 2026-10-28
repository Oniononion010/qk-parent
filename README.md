# 轻客管家（qk）
 
教育行业的 CRM 系统，管理线索、商机、客户和活动。
 
## 技术栈
 
Spring Boot 3 / MyBatis / MySQL / Redis / Vue 3 / Element Plus
 
## 模块结构
 
| 模块 | 作用 |
|---|---|
| qk-common | 公共工具类、全局异常处理、通用结果封装 |
| qk-entities | 实体类与 Mapper |
| qk-management | 启动模块，Controller / Service / 配置 |
 
## 快速开始
 
1. 执行根目录 `data.sql` 建库建表（库名 `qk`）
2. 修改 `qk-management/src/main/resources/application.yml` 里的数据库和 Redis 连接
3. 运行 `QkApplication` 启动后端
4. 前端 `npm install && npm run dev`
 
## 数据库表
 
dept 部门 · course 课程 · role 角色 · user 用户 · activity 活动
clue 线索 · clue_track_record 线索跟进 · business 商机
business_track_record 商机跟进 · operate_log 操作日志
