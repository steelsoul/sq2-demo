This is implementation for the demonstration sq2 alghorithm using model MVC (Model View Controller) written in Java.

Problem

You are given n points in the plane. You are asked to cover these points with k squares.

The squares must all be the same size, and their edges must all be parallel to the coordinate axes.

A point is covered by a square if it lies inside the square, or on an edge of the square.

Squares can overlap.

Find the minimum length for the squares' edges such that you can cover the n points with k squares.

Input

The first line of input gives the number of cases, N. N test cases follow. The first line of each test contains two positive integers n and k. Each of the next n lines contains a point as two integers separated by exactly one space. No point will occur more than once within a test case.

Output

For each test case, you should output one line containing "Case #X: Y" (quotes for clarity), where X is the number of the test case, starting from 1, and Y is the minimum length for the squares' edges for that test case.

Limits

The points' coordinates are non-negative integers smaller than 64000.
1 ? N ? 10
Small dataset

1 ? k < n ? 7
Large dataset

1 ? k < n ? 15 