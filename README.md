 
  ## 知识点1、POI：Excel导入。
    详见代码

  ## 知识点2、存储过程与游标

### 存储过程与游标：
    create or replace procedure 过程名(参数名 in/out 数据类型) 
    BEGIN
        # 声明变量
        DECLARE  变量  数据类型 [默认值(可选)]
        # 遍历数据结束标志
        DECLARE done INT DEFAULT FALSE;
        # 游标
        DECLARE cur CURSOR FOR 
        #数据集
        一条或多条SQL语句组成的结果集
        # 将结束标志绑定到游标
        DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
        -- 打开游标
        OPEN cur;
        -- 开始循环
        label: LOOP
            -- 提取游标里的数据
            FETCH cur INTO 变量1，变量2...;
        -- 声明结束的时候
        IF done THEN
            LEAVE label;
        END IF;
            -- 事务处理
    　　　  #在这里做你想做的事（增删改查）
        END LOOP;
        -- 关闭游标
        CLOSE cur; 
    END