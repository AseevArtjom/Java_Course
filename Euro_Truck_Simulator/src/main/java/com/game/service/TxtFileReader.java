package com.game.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TxtFileReader
{
    public TxtFileReader(){}
    public List<String> readFile(String filename) throws IOException{
        Stream<String> lineStream = Files.lines(Paths.get(filename));
        return lineStream.collect(Collectors.toList());
    }
}
