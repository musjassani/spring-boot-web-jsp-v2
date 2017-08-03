package com.proto.services.impl;

import com.proto.beans.Genre;
import com.proto.services.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("genreService")
public class GenreServiceImpl extends AbstractServiceImpl<Genre> implements GenreService {

    private final Logger logger = LoggerFactory.getLogger(GenreServiceImpl.class);

}
