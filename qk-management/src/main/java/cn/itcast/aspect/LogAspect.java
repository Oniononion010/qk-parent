package cn.itcast.aspect;

import cn.hutool.json.JSONUtil;
import cn.itcast.pojo.OperateLog;
import cn.itcast.service.OperateLogService;
import com.itheima.common.UserHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect//标注是一个切面
public class LogAspect {

    @Autowired
    private OperateLogService operateLogService;

    @Autowired
    private UserHolder userHolder;

    // 挑出 delete , update, insert

    @Around("execution(* cn.itcast.controller.*.delete*(..)) ||" +
            "execution(* cn.itcast.controller.*.update*(..))|| " +
            "execution(* cn.itcast.controller.*.add*(..))||" +
            "@annotation(cn.itcast.aspect.Log)")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        Object proceed = null;
        long start = System.currentTimeMillis();
        try {
            proceed = pjp.proceed();
            return proceed;
        } finally {
            long end = System.currentTimeMillis();
            String className = pjp.getSignature().getDeclaringTypeName();
            String methodName = pjp.getSignature().getName();

            Object[] args = pjp.getArgs();
            String methodParams = JSONUtil.toJsonStr(args);
            String returnValue = proceed == null ? "" : JSONUtil.toJsonStr(proceed);
            //记录日志
            OperateLog operateLog = OperateLog.builder()
                    .operateUserId(userHolder.getUserId())
                    .operateTime(LocalDateTime.now())
                    .className(className)
                    .methodName(methodName)
                    .methodParams(methodParams)
                    .returnValue(returnValue)
                    .costTime(end - start)
                    .build();
            operateLogService.saveOrUpdate(operateLog);

        }
    }
}
