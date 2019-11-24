package legoshop.service.impl;

import legoshop.dao.TypeDao;
import legoshop.domain.Type;
import legoshop.service.TypeService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Реализация сервиса типов деталей
 */

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;


    @Transactional(readOnly = true)
    @Override
    public List<Type> findAll() {
        return typeDao.findAll();
    }

    @Override
    public List<String> getBase64List(List<Type> typesList) {
        List<String> base64List = new ArrayList<>();

        for (Type type : typesList) {
            if (type.getImage() != null) {
                byte[] encodeBase64 = Base64.encodeBase64(type.getImage());
                String base64Encoded = null;

                try {
                    base64Encoded = new String(encodeBase64, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                base64List.add(base64Encoded);
            } else {
                base64List.add("no image");
            }
        }
        return base64List;
    }
}
