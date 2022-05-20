package com.management.client.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.client.service.TaskService;
import com.management.client.vo.TaskVo;
import com.management.client.vo.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 *
 * @author 严虹钱
 * @since 2022/04/2
 *
 */

@Slf4j
@Controller
@ResponseBody
@RequestMapping("task")
public class TaskController {

    @Autowired
    TaskService taskService;

    /**
     * 增加新任务
     * addTask
     *
     * @param task task
     * @return
     */
    @PostMapping("/addTask")
    public Result addTask(@RequestBody TaskVo task) {
        try {
            taskService.insert(task);
            return new Result<>().success("add success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("add fail" + e.getMessage());
        }
    }

    /**
     * 删除任务
     * deleteTask
     *
     * @param id id
     * @return
     */
    @DeleteMapping("/deleteTask/{id}")
    public Result deleteTask(@PathVariable Integer id) {
        try {
            taskService.delete(id);
            return new Result<>().success("success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * 更新任务
     * updateTask
     *
     * @param task task
     * @return
     */
    @RequestMapping(path = "/updateTask/{id}", method = RequestMethod.PATCH)
    public Result updateTask(@RequestBody TaskVo task, @PathVariable Integer id) {
        try {
            task.setId(id);
            taskService.update(task);
            return new Result<>().success("success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * 查看某个任务
     * getTaskById
     *
     * @param id
     * @return
     */
    @GetMapping("getTaskById/{id}")
    public Result getTaskById(@PathVariable Integer id) {
        try {
            TaskVo Task = taskService.getTaskById(id);
            return new Result<>().success(Task);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("get fail" + e.getMessage());
        }
    }


    /**
     * 获取所有任务
     * getAllTask
     *
     * @return
     */
    @GetMapping("/getAllTask/{pageNum}/{pageSize}")
    public Result<PageInfo<TaskVo>> getAllTask(@PathVariable Integer pageNum, @PathVariable Integer pageSize,TaskVo task) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<TaskVo> Tasks = taskService.getTaskList(task);
            return new Result<>().success(new PageInfo<>(Tasks));
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    // 解析前台字符时间
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
