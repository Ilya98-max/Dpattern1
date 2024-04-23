package edu.pattern.shapes.observer.impl;

import edu.pattern.shapes.model.Quadrangle;
import edu.pattern.shapes.model.Warehouse;
import edu.pattern.shapes.observer.QuadrangleObserver;
import edu.pattern.shapes.service.QuadrangleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuadrangleObserverImpl implements QuadrangleObserver {
    private static final Logger logger = LogManager.getLogger(QuadrangleObserverImpl.class.getName());

    @Override
    public void update(Quadrangle quadrangle) {
        QuadrangleService service = new QuadrangleService();
        double perimeter = QuadrangleService.calculatePerimeter(quadrangle);
        int key = quadrangle.getId();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(key, perimeter);
        logger.info("Warehouse updated for quadrangle with id " + key);
    }
}




