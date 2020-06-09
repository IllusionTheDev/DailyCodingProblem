package me.imillusion.dailycodingproblem;

import javafx.util.Pair;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class PointDIstance {

    /*
        Good morning! Here's your coding interview problem for today.

        This problem was asked by Google.

        Given a set of points (x, y) on a 2D cartesian plane, find the two closest points.
        For example, given the points [(1, 1), (-1, -1), (3, 4), (6, 1), (-1, -6), (-4, -3)],
        return [(-1, -1), (1, 1)]
     */

    private static Map<Pair<Point, Point>, Integer> distances = new HashMap<>();

    public static void main(String[] args)
    {
        //The problem doesn't specify inputs, to not waste time with string parsing I'm just going to emulate an input
        Point[] points = new Point[]{
                new Point(1, 1),
                new Point(-1, -1),
                new Point(3, 4),
                new Point(6, 1),
                new Point(-1, -6),
                new Point(-4, -3)
        };

        calculateDistances(points);

        List<Map.Entry<Pair<Point, Point>, Integer>> list = distances.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());

        Pair<Point, Point> closest = list.get(0).getKey();
        Point[] foundPoints = new Point[]{
                closest.getKey(),
                closest.getValue()
        };

        System.out.println(Arrays.toString(foundPoints));

    }

    private static void calculateDistances(Point[] points)
    {
        for(int current = 0; current < points.length - 1; current++)
        {
            Point point = points[current];
            for(int i = current + 1; i < points.length; i++)
            {
                Point second = points[i];
                int distance = (int) Math.hypot(point.getX() - second.getX(), point.getY() - second.getY());
                Pair<Point, Point> pair = new Pair<>(point, second);
                distances.put(pair, distance);
            }
        }
    }
}
