package gms.cuit.service;

        import gms.cuit.entity.*;
        import gms.cuit.mapper.InschoolMapper;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

@Service
public class InschoolService {

    @Autowired
    private InschoolMapper InschoolMapper;

    public Gms_Inschool findSchooolMem(String username, String school_id, String idcard) {
        return InschoolMapper.findSchooolMem(username,school_id,idcard);
    }

}

