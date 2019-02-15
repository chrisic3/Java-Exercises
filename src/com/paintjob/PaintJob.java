/*
    Bob is a wall painter and he needs your help. You have to write a program that helps Bob to calculate how many
        buckets of paint he needs to buy before going to work. Bob might also have some extra buckets at home.
        He knows what area he can cover with one bucket of paint.

    1. Write a method named getBucketCount with 4 parameters. First named width of type double, it represents width
        of the wall.

    The second parameter named height of type double, it represents the height of the wall.
    The third parameter named areaPerBucket, it represents the area that can be covered with one bucket of paint.
    The fourth parameter named extraBuckets, it represents the bucket count that Bob has at home.
    The method needs to return a value of type int that represents the number of buckets that Bob needs to buy before
        going to work. For calculating the bucket count check notes below.
    If one of the parameters width, height or areaPerBucket is less or equal to 0 or if extraBuckets is less than 0,
        method needs to return -1 to indicate invalid value.
    If all parameters are valid method needs to calculate the number of buckets and return it.

    Examples of input/output:
    * getBucketCount(-3.4, 2.1, 1.5, 2); → should return -1 since width parameter is invalid
    * getBucketCount(3.4, 2.1, 1.5, 2); → should return 3 since wall area is 7.14, single bucket can cover an area
        of 1.5 and Bob has 2 extra buckets home.
    * getBucketCount(2.75, 3.25, 2.5, 1); → should return 3 since wall area is 8.9375, single bucket can cover an
        area of 2.5 and Bob has 1 extra bucket at home.

    2. Bob does not like to enter 0 for extraBuckets parameter so he needs another method.

    Write another overloaded method named getBucketCount with 3 parameters width, height, and areaPerBucket
        (all of type double).
    The method needs to return a value of type int that represents the number of buckets that Bob needs to buy
        before going to work. For calculating the bucket count check notes below.
    If one of the parameters width, height or areaPerBucket is less or equal to 0 or if extraBuckets is less than 0,
        method needs to return -1 to indicate invalid value.
    If all parameters are valid method needs to calculate the number of buckets and return it.

    Examples of input/output:
    * getBucketCount(-3.4, 2.1, 1.5); → should return -1 since width parameter is invalid
    * getBucketCount(3.4, 2.1, 1.5); → should return 5 since wall area is 7.14, and single bucket can cover an
        area of 1.5.
    * getBucketCount(7.25, 4.3, 2.35); → should return 14 since wall area is 31.175, and single bucket can cover
        an area of 2.35 .

    3. In some cases, Bob does not know the width and height of the wall but he knows an area of the wall.
        He needs you to write another method.

    Write another overloaded method named getBucketCount with 2 parameters area and areaPerBucket
        (both of type double).
    The method needs to return a value of type int that represents the number of buckets that Bob needs to buy
        before going to work. For calculating the bucket count check notes below.
    If one of the parameters area or areaPerBucket is less or equal to 0 method needs to return -1 to indicate
        invalid value.
    If all parameters are valid method needs to calculate the number of buckets and return it.

    Examples of input/output:
    * getBucketCount(3.4, 1.5); → should return 3 since the area is 3.4 and single bucket can cover an area of 1.5
    * getBucketCount(6.26, 2.2); → should return 3 since wall area is 6.26 and single bucket can cover an area of 2.2.
    * getBucketCount(3.26, 0.75); → should return 5 since wall area is 3.26, and single bucket can cover an area
        of 0.75 .

    Do your best to help Bob .

    NOTE: Use method Math.ceil to round the number of calculated buckets (double) then convert it into an int before
        returning the value from the methods.
 */

package com.paintjob;

public class PaintJob {
    public static void main(String[] args) {
        System.out.println(getBucketCount(-3.4, 2.1, 1.5, 2));
        System.out.println(getBucketCount(3.4, 2.1, 1.5, 2));
        System.out.println(getBucketCount(2.75, 3.25, 2.5, 1));
        System.out.println(getBucketCount(2.75, 3.25, 2.5, 0));

        System.out.println("********************************");

        System.out.println(getBucketCount(-3.4, 2.1, 1.5));
        System.out.println(getBucketCount(3.4, 2.1, 1.5));
        System.out.println(getBucketCount(7.25, 4.3, 2.35));

        System.out.println("********************************");

        System.out.println(getBucketCount(-3.4, 1.5));
        System.out.println(getBucketCount(3.4, 1.5));
        System.out.println(getBucketCount(6.26, 2.2));
        System.out.println(getBucketCount(3.26, 0.75));
    }

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {
        // width and height are of the wall, areaPerBucket is area of wall per bucket, extraBuckets are already owned
        // return -1 if width, height, or areaPerBucket is <= 0 or if extraBucket < 0
        if ((width <= 0) || (height <= 0) || (areaPerBucket <= 0)) {
            return -1;
        }

        if (extraBuckets < 0) {
            return -1;
        }

        // calculate the number of buckets to buy and return it
        double wallArea = width * height;
        double totalBucketsNeeded = Math.ceil(wallArea / areaPerBucket);

        return ((int) totalBucketsNeeded - extraBuckets);
    }

    public static int getBucketCount(double width, double height, double areaPerBucket) {
        return getBucketCount(width, height, areaPerBucket, 0);
    }

    public static int getBucketCount(double area, double areaPerBucket) {
        // dividing area by length of 2 (arbitrary number) to get the width
        double width = area / 2;

        return getBucketCount(width, 2, areaPerBucket);
    }
}
