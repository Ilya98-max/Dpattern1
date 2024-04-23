package edu.pattern.shapes.main;


import edu.pattern.shapes.creator.QuadrangleFactory;
import edu.pattern.shapes.creator.impl.QuadrangleFactoryImpl;
import edu.pattern.shapes.model.Quadrangle;
import edu.pattern.shapes.model.Warehouse;
import edu.pattern.shapes.service.QuadrangleService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        QuadrangleFactory quadrangleFactory = new QuadrangleFactoryImpl();
        List<Quadrangle> quadrangles = quadrangleFactory.createQuadranglesFromFile("/Quadrangle.txt");

        Warehouse warehouse = Warehouse.getInstance();
        for (Quadrangle quadrangle : quadrangles) {
            warehouse.put(quadrangle.getId(), QuadrangleService.calculatePerimeter(quadrangle));
        }

        System.out.println(warehouse);
    }
}
