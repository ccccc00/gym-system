package gms.cuit.mapper;


        import gms.cuit.entity.*;
        import org.apache.ibatis.annotations.Param;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface InschoolMapper {
/*根据学工号、姓名、身份证查找校内人员*/
        Gms_Inschool findSchooolMem(String username,String school_id,String idcard);

}
