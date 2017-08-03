package com.proto.services.impl;

import com.proto.beans.Artiste;
import com.proto.services.ArtisteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("artisteService")
public class ArtisteServiceImpl extends AbstractServiceImpl<Artiste> implements ArtisteService{

    private final Logger logger = LoggerFactory.getLogger(ArtisteServiceImpl.class);

}
