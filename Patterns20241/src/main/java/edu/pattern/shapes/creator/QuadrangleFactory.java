package edu.pattern.shapes.creator;

import edu.pattern.shapes.model.Quadrangle;

import java.util.List;

public interface QuadrangleFactory {

    List<Quadrangle> createQuadranglesFromFile(String filePath);

}

