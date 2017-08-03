package com.proto.services.impl;

import com.proto.beans.Pays;
import com.proto.services.PaysService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("paysService")
public class PaysServiceImpl extends AbstractServiceImpl<Pays> implements PaysService{

    private final Logger logger = LoggerFactory.getLogger(PaysServiceImpl.class);

}
