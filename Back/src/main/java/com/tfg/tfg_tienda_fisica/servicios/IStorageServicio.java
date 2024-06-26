package com.tfg.tfg_tienda_fisica.servicios;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IStorageServicio {

    void init() throws IOException;
    String store(MultipartFile file);
    Resource loadAsResource(String filname);
}
