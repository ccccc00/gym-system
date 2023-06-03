package gms.cuit.controller;

        import gms.cuit.entity.*;
        import gms.cuit.service.InschoolService;
        import gms.cuit.service.UsernamePasswordUtilsService;
        import gms.cuit.service.UserService;
        import gms.cuit.utils.ExportExcelUtils;
        import gms.cuit.utils.SnowFlake;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.transaction.annotation.Transactional;
        import org.springframework.web.bind.annotation.*;

        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.net.URLEncoder;
        import java.text.DateFormat;
        import java.text.SimpleDateFormat;
        import java.util.*;

@RestController
@RequestMapping("/identity")
public class InschoolController {

    private SnowFlake snowFlake = new SnowFlake(2, 3);

    @Autowired
    private InschoolService InschoolService;

    /*
     * 查询使用get, 其它使用post
     * 首页部分
     */
    @PostMapping("/findSchooolMem")
    public Map<String, Object> findSchooolMem(@RequestParam Map<String, String> resmap) {
        Map<String, Object> map = new HashMap<>();
        /*查找学校有没有这个人*/
        Gms_Inschool schoolmem = InschoolService.findSchooolMem(resmap.get("username"), resmap.get("school_id"), resmap.get("idcard"));
        if (schoolmem != null) {
            map.put("state","2");
            map.put("info", schoolmem);
        } else {
            map.put("state","1");
            map.put("info", null);
        }
        return map;
    }


}