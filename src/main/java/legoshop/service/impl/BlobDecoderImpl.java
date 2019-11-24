package legoshop.service.impl;

import legoshop.domain.AbstractEntityWithImage;
import legoshop.service.BlobDecoder;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlobDecoderImpl implements BlobDecoder {

    @Override
    public List<String> getBase64List(List<? extends AbstractEntityWithImage> entityList) {
        List<String> base64List = new ArrayList<>();

        for (AbstractEntityWithImage entity : entityList) {
            if (entity.getImage() != null) {
                byte[] encodeBase64 = Base64.encodeBase64(entity.getImage());
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
