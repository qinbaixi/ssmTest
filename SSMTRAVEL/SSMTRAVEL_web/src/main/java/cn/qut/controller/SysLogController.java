package cn.qut.controller;

import cn.qut.domain.Orders;
import cn.qut.domain.SysLog;
import cn.qut.service.ISysLogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception {
//        ModelAndView mv=new ModelAndView();
//        List<SysLog> sysLogList= sysLogService.findAll();
//        mv.addObject("sysLogs",sysLogList);
//        mv.setViewName("syslog-list");
//        return mv;
//    }

    /**
     * 只有用户以上权限能访问
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogList = sysLogService.findAll(page, size);
        PageInfo pageInfo=new PageInfo(sysLogList);
        //PageInfo就是一个分页Bean
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("syslog-page-list");
        return mv;
    }

}